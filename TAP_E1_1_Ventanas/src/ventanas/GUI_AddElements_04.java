package ventanas;
import javax.swing.JFrame;



import javax.swing.JButton;
public class GUI_AddElements_04 {
    JButton btn;
    public GUI_AddElements_04(){
        JFrame jf = new JFrame("Sin herencia ni container");
        btn = new JButton("Action");
        jf.add(btn);
        jf.setBounds(100,100, 500, 300);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }

    public static void main(String[] args) {
        new GUI_AddElements_04();
    }
}
