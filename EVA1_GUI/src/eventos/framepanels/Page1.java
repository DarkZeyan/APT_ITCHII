package eventos.framepanels;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Page1 extends JPanel{
    JLabel title;

    public Page1(){
        title = new JLabel("Pagina 1");
        title.setFont(new Font("Serif",Font.BOLD,36));
        title.setForeground(new Color(255,255,255));

        this.setBackground(new Color(255,33,92));
        this.setSize(680,420);
        this.add(title, BorderLayout.CENTER);
    }
    
}
