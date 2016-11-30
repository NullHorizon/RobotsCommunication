
import javax.swing.*;
import java.awt.*;


/**
 * Created by shepkan on 30.11.2016.
 */
public class Frame extends JFrame {

    private JPanel but_panel;
    private JPanel robots_panel;
    private final int w=800, h=600;

    public Frame(){
        super("Robots communication");
        setSize(w,h);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        but_panel=new JPanel();
        but_panel.setSize(200,h);
        but_panel.setBounds(0,0,200,h);
        add(but_panel);

        robots_panel=new RobotsPanel(w-200,h);
        robots_panel.setBounds(200,0,w,h);
        add(robots_panel);

        setVisible(true);
    }


}
