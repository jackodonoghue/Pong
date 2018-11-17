import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Panel extends JPanel implements ActionListener{

    JButton startButton = new JButton();
    FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
    Font font = new Font("Arial", Font.PLAIN, 60);
    boolean startClicked = true;



    public Panel () {
        super();
        setBackground(Color.BLACK);
        setLayout(null);
        add(startButton);
        setStartButton(startButton);
    }

    public void setStartButton (JButton b) {
        b.setText("START");
        b.setSize(400,150);
        b.setFont(font);
        b.setForeground(Color.WHITE);
        b.setOpaque(false);
        b.setBorderPainted(false);
        b.setContentAreaFilled(false);
        b.setLocation(1200/2 - b.getWidth()/2, 900/2 - b.getHeight()/2);
        b.addActionListener(this);
    }

    public void paintComponent (Graphics g){ //https://www.youtube.com/watch?v=2l5-5PMUc5Y

        super.paintComponent(g);
        this.setBackground(Color.BLACK);

        if(!startButton.isVisible()) {
            g.setColor(Color.WHITE);
            g.fillRect(600, 0, 10, 900);
        }



       /*() g.setColor(Color.BLUE);
        g.fillRect((x, (int)y, 20, 20);*/

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        startButton.setVisible(false);
    }
}
