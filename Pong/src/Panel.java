import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel implements ActionListener{

    JButton startButton = new JButton();
    public Font font = new Font("Arial", Font.PLAIN, 60);
    Timer t = new Timer(5, this);
    JLabel score;
    FinalMessage finalMessage;
    private int xVelBall = 4, yVelBall = 4, yVelPaddleL = 20, yVelPaddleR = 20, xLP = 20, yLP = 900/2 - 100, xRP = 1140, yRP = 900/2 - 100;
    private final int BALL_X_ORIGIN = 600, BALL_Y_ORIGIN = 450;
    private int xBall = BALL_X_ORIGIN, yBall = BALL_Y_ORIGIN;
    private int scoreP1 = 0, scoreP2 = 0;

    public Panel () {

        super();
        setBackground(Color.BLACK);
        setLayout(null);
        add(startButton);
        setStartButton(startButton);
        t.start();
        setSize(1200, 880);

        addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {

                int key = e.getKeyCode();


                if( key == KeyEvent.VK_DOWN) {

                    yLP += yVelPaddleL;

                    if(yLP + 200 <= 880 && yLP + 200 >= 860) {
                        yVelPaddleL = 0;
                    }

                    else {
                        yVelPaddleL = 20;
                    }

                }

                if( key == KeyEvent.VK_UP) {

                    //up(yLP, yVelPaddleL);
                    yLP -= yVelPaddleL;

                    if(yLP >= 0 && yLP <=20) {
                        yVelPaddleL = 0;
                    }

                    else {
                        yVelPaddleL = 20;
                    }
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

                if( key == KeyEvent.VK_S) {

                    yRP += yVelPaddleR;

                    if(yRP + 200 <= 880 && yRP + 200 >= 860) {
                        yVelPaddleR = 0;
                    }

                    else {
                        yVelPaddleR = 20;
                    }

                }

                if( key == KeyEvent.VK_W) {

                    //up(yLP, yVelPaddleL);
                    yRP -= yVelPaddleR;

                    if(yRP >= 0 && yRP <=20) {
                        yVelPaddleR = 0;
                    }

                    else {
                        yVelPaddleR = 20;
                    }
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
        score = new JLabel(scoreP1 + "     " + scoreP2);
        add(score);
        setScore(score);
        add(finalMessage = new FinalMessage());
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
                score.setVisible(true);
                finalMessage.setVisible(false);
                scoreP1 = 0;
                scoreP2 = 0;
            }

        });

    }

    public void setScore(JLabel s) {

        s.setVisible(false);
        s.setSize(200,100);
        s.setFont(font);
        s.setForeground(Color.WHITE);
        s.setLocation(Main.FRAME_WIDTH/2 - 75,0);

    }

    @Override
    public void paintComponent (Graphics g){ //https://www.youtube.com/watch?v=2l5-5PMUc5Y

        super.paintComponent(g);
        this.setBackground(Color.BLACK);

        if(!startButton.isVisible() && (scoreP1 < 10 && scoreP2 < 10)) {


            //ball
            g.setColor(Color.WHITE);
            g.fillRect(xBall, yBall, 20, 20);

            //paddle left
            g.setColor(Color.WHITE);
            g.fillRect(xLP, yLP, 40, 200);

            //paddle right
            g.setColor(Color.WHITE);
            g.fillRect(xRP, yRP, 40, 200);

        }

    }

    //Ball Movement
    @Override
    public void actionPerformed(ActionEvent e) {

        if(!startButton.isVisible()) {
            xBall -= xVelBall;
            yBall -= yVelBall;

            if(xBall == 0) {

                resetBall();
                updateScore(1);

            }

            if(xBall >= Main.FRAME_WIDTH - 20) {

                resetBall();

                updateScore(2);

            }

            if(yBall <= 0 || yBall >= Main.FRAME_HEIGHT - 60) {

                yVelBall = -yVelBall;

            }

            detectCollisionLP();

            detectCollisionRP();
        }



        repaint();

    }

    public void updateScore(int s) {

        if(scoreP1 != 10 && scoreP2 != 10){
            if(s == 2) {
                scoreP1++;
            }

            else {
                scoreP2++;
            }
        }

        if(scoreP1 == 10 || scoreP2 == 10) {
            endGame();

            xLP = 20;
            yLP = 900/2 - 100;
            xRP = 1140;
            yRP = 900/2 - 100;



            resetBall();
        }

        score.setText(scoreP1 + "     " + scoreP2);

    }

    public void resetBall () {
        if((int)(Math.random() * 2) +1 == 1) {
            xBall = BALL_X_ORIGIN;
            yBall = BALL_Y_ORIGIN;
            xBall -= xVelBall;
        }
        else {
            xBall = BALL_X_ORIGIN;
            yBall -= BALL_Y_ORIGIN;
            xBall += xVelBall;
        }

        if((int)(Math.random() * 2) +1 == 1) {
            xBall = BALL_X_ORIGIN;
            yBall = BALL_Y_ORIGIN;
            yBall += yVelBall;
        }
        else {
            xBall = BALL_X_ORIGIN;
            yBall = BALL_Y_ORIGIN;
            yBall -= yVelBall;
        }

    }

    private void detectCollisionLP() {

        if(xBall == 60 && (yBall <= yLP + 200 && yBall + 20 >= yLP)) {
            xVelBall = -xVelBall;
        }

    }

    private void detectCollisionRP() {

        if(xBall + 20 == xRP && (yBall <= yRP + 200 && yBall + 20 >= yRP)) {
            xVelBall = -xVelBall;
        }

    }

    private void endGame() {

        finalMessage.setVisible(true);

        startButton.setText("Restart Game");
        startButton.setVisible(true);
        startButton.setSize(420, 150);
        startButton.setLocation(Main.FRAME_WIDTH / 2 - startButton.getWidth() / 2, 700);

        if (scoreP1 == 10) {
            finalMessage.setText("Player 1 wins!");
        } else {
            finalMessage.setText("Player 2 wins!");
        }

    }
}
