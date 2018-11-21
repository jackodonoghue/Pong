import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel implements ActionListener, KeyListener{

    JButton startButton = new JButton();
    Font font = new Font("Arial", Font.PLAIN, 60);
    Timer t = new Timer(5, this);
    private int xVelBall = 2, yVelBall = 2, yVelPaddleL = 0, xLP = 20, yLP = 900/2 - 100, yRP = 900/2 - 100;
    private int xBall = 600, yBall = 450;

    public Panel () {

        super();
        setBackground(Color.BLACK);
        setLayout(null);
        add(startButton);
        setStartButton(startButton);
        t.start();
        addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {

                int key = e.getKeyCode();

                if( key == KeyEvent.VK_DOWN) {

                    yLP += 20;

                }

                if( key == KeyEvent.VK_UP) {

                    yLP -= 20;

                }

                repaint();

            }

            @Override
            public void keyTyped(KeyEvent e) {
                //NOT USED - Needed for implementing KeyListener
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //NOT USED - Needed for implementing KeyListener
            }
        });
        addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {

                int key = e.getKeyCode();

                if( key == KeyEvent.VK_W)) {

                    yRP += 20;

                }

                if( key == KeyEvent.VK_S) {

                    yRP -= 20;

                }

                repaint();

            }

            @Override
            public void keyTyped(KeyEvent e) {
                //NOT USED - Needed for implementing KeyListener
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //NOT USED - Needed for implementing KeyListener
            }
        });
        setFocusable(true);

    }

    public void setStartButton (JButton b) {

        b.setText("START");
        b.setSize(400,150);
        b.setFont(font);
        b.setForeground(Color.WHITE);
        b.setOpaque(false);
        b.setBorderPainted(false);
        b.setContentAreaFilled(false);
        b.setLocation(Main.FRAME_WIDTH/2 - b.getWidth()/2, Main.FRAME_HEIGHT/2 - b.getHeight()/2);
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                startButton.setVisible(false);

            }

        });

    }

    @Override
    public void paintComponent (Graphics g){ //https://www.youtube.com/watch?v=2l5-5PMUc5Y

        super.paintComponent(g);
        this.setBackground(Color.BLACK);

        if(!startButton.isVisible()) {

            //middle bar
            g.setColor(Color.WHITE);
            g.fillRect(600, 0, 10, 900);

            //ball
            g.setColor(Color.WHITE);
            g.fillRect((int)xBall, (int)yBall, 20, 20);

            //paddle left
            g.setColor(Color.WHITE);
            g.fillRect(xLP, yLP, 40, 200);

            //paddle right
            g.setColor(Color.WHITE);
            g.fillRect(1140, yRP, 40, 200);

        }

    }

    //Ball Movement
    @Override
    public void actionPerformed(ActionEvent e) {

        xBall += xVelBall;

        if(xBall <= 0 || xBall >= Main.FRAME_WIDTH - 20) {

            xVelBall = -xVelBall;

        }

        yBall += yVelBall;

        if(yBall <= 0 || yBall >= Main.FRAME_HEIGHT - 60) {

            yVelBall = -yVelBall;

        }

        repaint();

    }

    public void down(int y) {

        y += 20;


    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if( key == KeyEvent.VK_DOWN) {

            yLP += 20;

        }

        if( key == KeyEvent.VK_UP) {

            yLP -= 20;

        }

        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {
        //NOT USED - Needed for implementing KeyListener
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //NOT USED - Needed for implementing KeyListener
    }

}
