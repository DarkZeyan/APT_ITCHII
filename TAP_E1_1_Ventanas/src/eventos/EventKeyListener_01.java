package eventos;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class EventKeyListener_01 extends JFrame{

    JLabel imgLbl;
    ImageIcon icon;
    int displacement=400;
    int position=400;

    public EventKeyListener_01(){
        super("Key Listener Test");
        this.setLayout(null);
        icon = new ImageIcon(this.getClass().getResource("chocola.png"));
        imgLbl = new JLabel(icon);
        imgLbl.setBounds(position,450,150, 100);
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

                if(kc==39){
                    position+=displacement;
                    imgLbl.setBounds(position,450,150,100);
                }
                if(kc==37){ //
                    position+=displacement;
                    imgLbl.setBounds(position,450,150,100);
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                int kc = e.getKeyCode();
                int ekc = e.getExtendedKeyCode();
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                char c = e.getKeyChar();
                int kc = e.getKeyCode();
                int ekc = e.getExtendedKeyCode();
                
            }
        });

    }

}