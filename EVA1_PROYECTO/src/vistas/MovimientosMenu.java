package vistas;
import javax.swing.*;
import java.awt.*;
import static vistas.MainMenu.controlador;
import java.awt.event.*;
public class MovimientosMenu extends JFrame{
    
    public MovimientosMenu(){
        super("Movimientos");
        this.setSize(1280,720);
        this.setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(45,45,45));
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void initComponents(){
        
    }
}
