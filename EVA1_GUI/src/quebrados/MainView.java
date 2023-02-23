package quebrados;
import javax.swing.*;
import java.awt.Font;
import java.awt.*;
import java.awt.Color;
public class MainView extends JPanel{
    public MainView(){
        
    JLabel lblTitle = new JLabel("<html><div style='text-align:center;'>Operaciones con quebrados</div></html>");

    lblTitle.setFont(new Font("Arial", Font.BOLD, 36));
    lblTitle.setForeground(Color.white);
    lblTitle.setOpaque(true);
    lblTitle.setBackground(new Color(107, 191, 255));
    lblTitle.setBorder(BorderFactory.createEmptyBorder(90, 150, 90, 150));
    this.setLayout(new GridBagLayout());
    lblTitle.setLocation(0, 0);
    this.add(lblTitle);
    this.setBorder(BorderFactory.createEmptyBorder(90, 150, 90, 150));
    this.setBackground(new Color(41, 186, 230));
    }
}
