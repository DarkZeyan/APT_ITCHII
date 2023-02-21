package ventanas;
import javax.swing.JFrame;
import javax.swing.JButton;
public class GUI_AddElements_02 extends JFrame {
    JButton myBtn;
    public GUI_AddElements_02(){
        super("With heritancy without container");
        myBtn = new JButton("ACTION");
        this.add(myBtn);
        this.setBounds(30,30,200,200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new GUI_AddElements_02();
    }
}
