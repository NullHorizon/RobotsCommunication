import com.sun.org.glassfish.gmbal.ManagedObject;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.*;
/**
 * Created by shepkan on 30.11.2016.
 */
public class RobotsPanel extends JPanel {
    private int w,h;
    public RobotsPanel(int w, int h){
        super();
        setSize(w, h);
        setBackground(Color.white);
    }

    /*@Override
    public void paint(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0,0,w,h);

    }*/

}
