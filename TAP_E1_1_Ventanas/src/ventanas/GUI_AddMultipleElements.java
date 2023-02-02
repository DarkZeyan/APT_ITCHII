package ventanas;
import javax.swing.JFrame;
import javax.swing.JButton;
public class GUI_AddMultipleElements extends JFrame {
    JButton btn1,btn2,btn3;
    public GUI_AddMultipleElements(){
        btn1 = new JButton("Boton 1");
        btn2 = new JButton("Boton 2");
        btn3 = new JButton("Boton 3");

        btn1.setBounds(100,100,100,30);
        btn2.setBounds(130,100,100,30);
        btn3.setBounds(150,100,100,30);
        this.setBounds(100, 100 , 300, 800);
        this.add(btn1);
        this.add(btn2);
        this.add(btn3);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    public static void main(String[] args) {
        new GUI_AddMultipleElements();
    }
}
