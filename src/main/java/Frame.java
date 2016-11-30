
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * Created by shepkan on 30.11.2016.
 */
public class Frame extends JFrame implements ActionListener {

    private JPanel but_panel, robots_panel, cluster_panel, que_panel ;
    private final int w=CONST.width+200, h=CONST.height;
    private JRadioButton que1_butt, que2_butt, que3_butt,cluster1_butt, cluster2_butt, cluster3_butt;
    private JButton someButt;
    private ArrayList<Line> lines;

    public Frame(){
        super("Robots communication");
        setSize(w,h);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        lines=new ArrayList<Line>();

        but_panel=new JPanel();
        but_panel.setSize(200,h);
        but_panel.setBounds(0,0,200,h);
        but_panel.setLayout(new FlowLayout());

        someButt= new JButton("Some button");
        but_panel.add(someButt);

        cluster_panel=new JPanel();
        cluster_panel.setBorder(BorderFactory.createLoweredBevelBorder());
        cluster_panel.setLayout(new GridLayout(3,1));
        ButtonGroup cluster_group= new ButtonGroup();
        cluster1_butt=new JRadioButton("No cluster", true);
        cluster2_butt=new JRadioButton("Simple cluster", false);
        cluster3_butt= new JRadioButton("Leader cluster", false);
        cluster_group.add(cluster1_butt);
        cluster_group.add(cluster2_butt);
        cluster_group.add(cluster3_butt);
        cluster_panel.add(cluster1_butt);
        cluster_panel.add(cluster2_butt);
        cluster_panel.add(cluster3_butt);
        but_panel.add(cluster_panel);

        que_panel=new JPanel();
        que_panel.setBorder(BorderFactory.createLoweredBevelBorder());
        que_panel.setLayout(new GridLayout(3,1));
        ButtonGroup que_group= new ButtonGroup();
        que1_butt=new JRadioButton("Que type 1", true);
        que2_butt=new JRadioButton("Que type 2", false);
        que3_butt= new JRadioButton("Que type 3", false);
        que_group.add(que1_butt);
        que_group.add(que2_butt);
        que_group.add(que3_butt);
        que_panel.add(que1_butt);
        que_panel.add(que2_butt);
        que_panel.add(que3_butt);
        but_panel.add(que_panel);

        add(but_panel);

        robots_panel=new RobotsPanel(w-200,h);
        robots_panel.setBounds(200,0,w,h);
        add(robots_panel);

        setVisible(true);
    }

    public void addLine(Point p1, Point p2, Color color){
        lines.add(new Line(p1,p2,color));
    }

    public void addLine(Point p1, Point p2){
        lines.add(new Line(p1,p2));
    }

    public void removeLine(Point p1, Point p2) {
        for (int i = 0; i < lines.size(); i++) {
            Line l = lines.get(i);
            if ((l.p1 == p1 && l.p2 == p2) || (l.p1 == p2 && l.p2 == p1)) {
                lines.remove(i);
            }
        }
    }

    public int getQueType(){
        if (que1_butt.isSelected()){
            return 1;
        }
        if (que1_butt.isSelected()){
            return 2;
        }
        if (que1_butt.isSelected()){
            return 3;
        }
        return 0;
    }

    public int getClusterType(){
        if (cluster1_butt.isSelected()){
            return 1;
        }
        if (cluster2_butt.isSelected()){
            return 2;
        }
        if (cluster3_butt.isSelected()){
            return 3;
        }
        return 0;
    }

    public void actionPerformed(ActionEvent e) {
        /*switch (e.getActionCommand()){
            case "Some button": main.logging("Something happend");
        }*/
    }

    private class RobotsPanel extends JPanel {
        private int w,h;
        public RobotsPanel(int w, int h){
            super();
            this.w=w;
            this.h=h;
            setSize(w, h);
            setBackground(Color.WHITE);
        }

        @Override
        public void paint(Graphics g){
            g.setColor(Color.WHITE);
            g.fillRect(0,0,w,h);
            for (int i=0; i<CONST.N;i++){
                Agent a=main.agents.get(i);
                g.setColor(a.getColor());
                g.fillArc(a.getPos().x,a.getPos().y,a.getR(),a.getR(),0,360);
            }
            System.out.println(lines.size());
            for (int i=0; i<lines.size();i++){
                lines.get(i).draw(g);
            }
        }

    }

    private static class Line{
        Color color;
        Point p1, p2;

        public Line(Point p1, Point p2, Color color){
            this.p1=p1;
            this.p2=p2;
            this.color=color;
        }

        public Line(Point p1, Point p2){
            this.p1=p1;
            this.p2=p2;
            this.color=Color.black;
        }

        public void draw(Graphics g){
            g.setColor(color);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }
}
