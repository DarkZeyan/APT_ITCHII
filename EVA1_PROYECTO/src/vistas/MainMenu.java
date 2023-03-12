package vistas;

import static eva1_proyecto.App.saveUsers;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import modelo.Usuario;
public class MainMenu extends JFrame{
    public MainMenu(ArrayList<Usuario> usuarios,Usuario usuario){
        
        
        super("BANCONY -  Menu principal");
        
        this.setSize(1280,720);
        this.setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(45,45,45));
        // initComponents();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        saveUsers(usuarios);
    }

    private void initComponets(){


        
    }
}
