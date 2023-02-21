package event_multiple_windows;

import javax.swing.*;
import java.awt.*;
class MainView extends JPanel {
    private JLabel lblTitle;

    public MainView() {
        lblTitle = new JLabel("<html>Aplicación para calcular <br> la distancia de una recta</html>");

        lblTitle.setFont(new Font("Arial", Font.BOLD, 36));
        lblTitle.setForeground(Color.white);
        lblTitle.setOpaque(true);
        lblTitle.setBackground(new Color(150, 90, 255));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(90, 150, 90, 150));
        lblTitle.setLocation(0, 0);
        this.add(lblTitle);
        this.setBorder(BorderFactory.createEmptyBorder(90, 150, 90, 150));
        this.setBackground(new Color(140, 60, 255));
    }

}