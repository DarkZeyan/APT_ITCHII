package ventanas;
import javax.swing.JFrame;

public class VJFrame extends JFrame{

    public VJFrame(){
        this.setBounds(100,100,500,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        new VJFrame();
    }
}