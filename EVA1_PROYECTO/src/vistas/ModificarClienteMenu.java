package vistas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ModificarClienteMenu extends JFrame{
    public ModificarClienteMenu(){
        super("Modificar cliente");
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
