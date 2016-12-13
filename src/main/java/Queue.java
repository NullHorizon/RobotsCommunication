import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

/**
 * Created by AsmodeusX on 30.11.2016.
 */
public class Queue {

    static class Pair {
        private Agent A;
        private int B;

        public Pair(Agent a, int b)
        {
            this.A = a;
            this.B = b;
        }

        public Agent getA()
        {
            return this.A;
        }

        public void setA(Agent a)
        {
            this.A = a;
        }

        public int getB()
        {
            return this.B;
        }

        public void setB(int b)
        {
            this.B = b;
        }

        @Override
        public boolean equals(Object o)
        {
            if (o == null) {
                return false;
            }
            if (o == this) {
                return true;
            }
            if (!(o instanceof Pair)) {
                return false;
            }
            Pair p =(Pair)o;
            return (p.getA() == this.getA());
        }

        @Override
        public int hashCode()
        {
            int hash = 31;
            int koef = 17;
            hash += koef * this.getA().getId();
            return hash;
        }

        @Override
        public String toString()
        {
            return A.toString();
        }

    }

    private Vector<Pair> elements;
    private boolean working;
    private Agent owner;

    public Queue(Agent a)
    {
        this.elements = new Vector<Pair>();
        this.owner = a;
    }

    public void addToQueue(Agent a, int delay)
    {
        this.elements.add(new Pair(a, delay));
        if (!this.working) {
            this.Work();
        }
    }

    public void removeFromQueue(final Pair p)
    {
        owner.sendMessage(p.getA(), new Message(CONST.ACCMSG, new ArrayList<Agent>() {{add(p.getA());}}));
        this.elements.remove(p);
        main.logging(this.toString());
    }

    public Agent nowInWork()
    {
        if (this.elements.isEmpty()) {
            return null;
        }
        return this.elements.firstElement().getA();
    }

    public int whereIs(Agent a)
    {
        return this.elements.indexOf(new Pair(a, -1));
    }

    public int getLength() {
        return this.elements.size();
    }

    private void Work()
    {
        this.working = false;
        if (!elements.isEmpty())
        {
            this.working = true;
            final Pair firstElement = this.elements.firstElement();
            Timer tmr = new Timer();
            tmr.schedule(new TimerTask() {
                @Override
                public void run() {
                    this.cancel();
                    removeFromQueue(firstElement);
                    Work();
                }
            }, firstElement.getB());
        }
    }

    @Override
    public String toString()
    {
        String ans = "Elements in queue: ";
        for(Pair p : this.elements)
        {
            ans += (" " + p.toString());
        }
        return ans;
    }

}
