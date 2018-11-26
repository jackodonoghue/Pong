import javax.swing.*;
import java.awt.*;

public class FinalMessage extends JLabel {

    public FinalMessage() {
        super();
        setSize(248,100);
        setLocation( Main.FRAME_WIDTH/2 - getWidth()/2, Main.FRAME_HEIGHT/2 - getHeight()/2);
        setForeground(Color.WHITE);
        setFont(new Font("Arial", Font.PLAIN, 40));
        setVisible(false);
    }

   //

}
