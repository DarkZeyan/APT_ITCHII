package vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import modelo.Usuario;
public class MainMenu extends JFrame{
    public MainMenu(Usuario usuario){
        
        
        super("BANCONY -  Menu principal");
        
        this.setSize(1280,720);
        this.setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(45,45,45));
        // initComponents();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void initComponets(){


        
    }
}
