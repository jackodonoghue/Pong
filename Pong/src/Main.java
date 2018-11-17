import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Main {

    private static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();; //https://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution

    public static final int FRAME_HEIGHT = 900;
    public static final int FRAME_WIDTH = 1200;

    public static void main(String[] args) {
        /*JFrame pongFrame = new JFrame("Pong");
        Panel panel = new Panel();
        pongFrame.setSize(1200,900);
        pongFrame.setLocation(dim.width/2 - dim.getSize().width/2, dim.height/2 - dim.getSize().height/2);
        pongFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pongFrame.add(panel);

        pongFrame.setVisible(true);*/

        JFrame frame = new JFrame("Pong");

        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        frame.setLocation(dim.width/2 - frame.getSize().width/2, dim.height/2 - frame.getSize().height/2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Panel());
        frame.setVisible(true);
        frame.setResizable(false);
    }

}
