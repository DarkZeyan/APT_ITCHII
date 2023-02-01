package ventanas;
import javax.swing.JFrame;

public class VJFrame_SinHerencia {
    JFrame jf = new JFrame("Sin herencia");
    public VJFrame_SinHerencia(){
        jf.setBounds(100,100, 400, 200);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        new VJFrame_SinHerencia();
    }
}
