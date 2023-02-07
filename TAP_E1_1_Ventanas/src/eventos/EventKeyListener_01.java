package eventos;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

//

public class EventKeyListener_01 extends JFrame{

    JLabel imgLbl;
    ImageIcon icon;
    int displacement=250;
    int position=400;

    public EventKeyListener_01(){
        super("Key Listener Test");
        this.setLayout(null);
        icon = new ImageIcon(this.getClass().getResource("chocola.png"));
        imgLbl = new JLabel(icon);
        imgLbl.setBounds(position,150,icon.getIconWidth(),icon.getIconHeight());
        this.add(imgLbl);
        this.setBounds(100,100,900,600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        
        this.addKeyListener(new KeyListener(){
            @Override
            public void keyPressed(KeyEvent e){
                char c = e.getKeyChar();
                int kc = e.getKeyCode();
                int ekc = e.getExtendedKeyCode();

                if(kc==39 && position<900-250){// Right arrow key movement
                
                    position+=displacement;
                    imgLbl.setBounds(position,150,icon.getIconWidth(),icon.getIconHeight());
                }
                if(kc==37 && position>0){ // Left arrow key movement
                    position-=displacement;
                    imgLbl.setBounds(position,150,icon.getIconWidth(),icon.getIconHeight());
                }
            }

            @Override
            //When key is typed (not pressed) do this
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                int kc = e.getKeyCode();
                int ekc = e.getExtendedKeyCode();
                
            }
            
            //Do this when key is released.
            @Override
            public void keyReleased(KeyEvent e) {
                char c = e.getKeyChar();
                int kc = e.getKeyCode();
                int ekc = e.getExtendedKeyCode();
                
            }
        });

    }
    public static void main(String[] args) {
        new EventKeyListener_01();
    }
}