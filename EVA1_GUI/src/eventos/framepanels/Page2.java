package eventos.framepanels;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Page2 extends JPanel{
    JLabel title;

    public Page2(){
        title = new JLabel("Bienvenido a la pagina 2");
        title.setFont(new Font("Serif",Font.BOLD,36));
        title.setForeground(new Color(255,255,255));

        this.setBackground(new Color(180,70,92));
        this.setSize(680,420);
        this.add(title, BorderLayout.CENTER);
    }
  
}