import java.util.ArrayList;

/**
 * Created by AsmodeusX on 13.12.2016.
 */
public class Message
{
    private String content;
    private ArrayList<Agent> chain;

    public Message(String x, ArrayList<Agent> a)
    {
        this.content = x;
        this.chain = a;
        if (this.chain == null)
            this.chain = new ArrayList<Agent>();
    }

    public void setContent(String x)
    {
        this.content = x;
    }
    public String getContent()
    {
        return this.content;
    }

    public ArrayList<Agent> getChain()
    {
        return this.chain;
    }

    public boolean addToChain(Agent a)
    {
        if (this.chain.indexOf(a) != -1)
        {
            this.chain.add(a);
            return true;
        }
        return false;
    }

    public boolean removeFromChain(Agent a)
    {
        if (this.chain.indexOf(a) != -1)
        {
            this.chain.remove(this.chain.indexOf(a));
            return true;
        }
        return false;
    }

    public String toString()
    {
        String chainStr = "";
        for(int i = 0; i < this.chain.size(); i++)
            chainStr += this.chain.get(i).getId();
        return chainStr + " " + this.content;
    }
}
