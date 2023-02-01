package ventanas;
import javax.swing.JFrame;

public class VJFrame extends JFrame{

    public VJFrame(){

        super("Ventana heredada de JFrame"); // This modifies the window title.
        this.setBounds(100,100,500,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        new VJFrame();
    }
}