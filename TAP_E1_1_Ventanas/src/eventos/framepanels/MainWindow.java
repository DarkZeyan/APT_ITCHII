package eventos.framepanels;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainWindow extends JPanel {
    private JLabel lblTitle;

    public MainWindow(){
        lblTitle = new JLabel("Bienvenido al menu principal");
        lblTitle.setFont(new Font("Serif",Font.BOLD,36));
        lblTitle.setForeground(Color.white);


        this.add(lblTitle,BorderLayout.CENTER);
        this.setBackground(new Color(140, 60, 255));
    }

}
