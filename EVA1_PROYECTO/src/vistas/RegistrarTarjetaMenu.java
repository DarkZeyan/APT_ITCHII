package vistas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class RegistrarTarjetaMenu extends JFrame{
    public RegistrarTarjetaMenu(){
        super("Registrar nueva tarjeta");
        this.setSize(1280,720);
        this.setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(45,45,45));
        //initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void initComponents(){
        
    }
}
