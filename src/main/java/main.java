import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by AsmodeusX on 30.11.2016.
 */
public class main {
    public static void logging(String msg)
    {
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss:SS ");
        System.out.println(ft.format(date) + msg);
    }
    public static void main(String args[])
    {
        Frame fr = new Frame();
        Agent A = new Agent();
        Agent B = new Agent();
        Agent C = new Agent();
        Agent D = new Agent();
        A.sendMessage(D, "Hello!");
        B.sendMessage(D, "HelloHelloHello!");
        C.sendMessage(D, "HelloHelloHelloHelloHelloHello!");
    }
}
