package eventos;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class SimpleEventAction extends JFrame {

    JButton btn;
    
    public SimpleEventAction(){
        super("Events");
        this.setLayout(null);        
        btn = new JButton("Action");
        

        btn.setBounds(100,100,100,50);
        this.add(btn);
        
        btn.addActionListener(new ActionListener(){
            

            @Override
            public void actionPerformed(ActionEvent e) {
                // The tasks the button will perform.
                JOptionPane.showMessageDialog(btn.getRootPane(), "Se detecta el evento con ActionListener.");
            }
        });

        this.setBounds(100,100,500,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new SimpleEventAction();
    }
}
