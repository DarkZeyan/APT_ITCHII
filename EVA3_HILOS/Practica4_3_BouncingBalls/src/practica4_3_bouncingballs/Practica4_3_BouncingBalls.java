/*
 * 
 * 
 */
package practica4_3_bouncingballs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author Jorge Eduardo Escobar Bugarini - ISC - 21550317
 */
public class Practica4_3_BouncingBalls extends JFrame{
    
    private ShapePanel drawPanel;
    private Vector<NewBall> Balls;
    private JTextField message;
    
    public Practica4_3_BouncingBalls(){
          super("Bouncing Bals");
        drawPanel = new ShapePanel(400, 345);
        message = new JTextField();
        message.setEditable(false);

        Balls = new Vector<NewBall>();
        add(drawPanel, BorderLayout.NORTH);
        add(message, BorderLayout.SOUTH);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    

    private class NewBall extends Thread {

        private Ellipse2D.Double thisBall;
        private boolean ballStarted;
        private int size, speed; // characteristics
        private int deltax, deltay; // of the ball

        public NewBall() {
            ballStarted = true;
            size = 10 + (int) (Math.random() * 60);
            speed = 10 + (int) (Math.random() * 100);
            int startx = (int) (Math.random() * 300);
            int starty = (int) (Math.random() * 300);
            deltax = -10 + (int) (Math.random() * 21);
            deltay = -10 + (int) (Math.random() * 21);
            if ((deltax == 0) && (deltay == 0)) {
                deltax = 1;
            }
            thisBall = new Ellipse2D.Double(startx, starty, size, size);
        }

        public void draw(Graphics2D g2d) {
            if (thisBall != null) {
                g2d.setColor(Color.BLUE);
                g2d.fill(thisBall);
            }
        }

        public void run() {
            while (ballStarted) 
            {
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    System.out.println("Woke up prematurely");
                }

                int oldx = (int) thisBall.getX();
                int oldy = (int) thisBall.getY();
                int newx = oldx + deltax;
                if (newx + size > drawPanel.getWidth() || newx < 0) {
                    deltax = -deltax;
                }
                int newy = oldy + deltay;
                if (newy + size > drawPanel.getHeight() || newy < 0) {
                    deltay = -deltay;
                }
                thisBall.setFrame(newx, newy, size, size);
                drawPanel.repaint();
            }
        }
    }
    
    private class ShapePanel extends JPanel{
        private int prefwid, prefht;       
        public ShapePanel(int pwid, int pht){
            prefwid = pwid;
            prefht = pht;
            
            addMouseListener(
                    new MouseAdapter(){
                        public void mouseClicked(MouseEvent e){
                            NewBall nextBall =  new NewBall();
                            Balls.addElement(nextBall);
                            nextBall.start();
                            message.setText("Number of Balls: "+Balls.size());
                        }
                    }
            );
        }
        public Dimension getPreferredSize(){
            return new Dimension(prefwid,prefht);
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D)g;
            for (int i = 0; i <Balls.size(); i++) {
                (Balls.elementAt(i)).draw(g2d);
            }
        }
    }
    
    public static void main(String[] args) {
        
        Practica4_3_BouncingBalls practica = new Practica4_3_BouncingBalls();
      
    }
    
}

