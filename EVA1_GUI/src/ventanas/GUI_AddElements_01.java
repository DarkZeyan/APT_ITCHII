package ventanas;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Container;
public class GUI_AddElements_01 extends JFrame{
    
    private Container panel;
    private JButton button;
    public GUI_AddElements_01(){
        super("Con herencia y container");
        button = new JButton("Aceptar");
        // panel = getContentPane(); //Since Java JDK 1.5 it is not necessary anymore to add the container.
        panel = this.getContentPane();
        panel.add(button);

        //this.pack();
        this.setBounds(30,50,200,200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new GUI_AddElements_01();
    }

}
