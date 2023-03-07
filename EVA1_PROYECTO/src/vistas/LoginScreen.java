package vistas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import modelo.Usuario;
public class LoginScreen extends JFrame{
    private JLabel title;
    private JLabel passwordLbl;
    private JLabel userLbl;
    private ArrayList<Usuario> usuarios;

    public LoginScreen(ArrayList<Usuario> usuarios){
        super("BANCONY -  INICIO DE SESION");
        this.setSize(1280,720);
        this.setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(45,45,45));
        initComponents();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void initComponents(){
        title = new JLabel("Bancony");
        passwordLbl= new JLabel("Contraseña: ");
        userLbl= new JLabel("Usuario: ");

        title.setFont(new Font("Verdana",Font.PLAIN,16));
        title.setForeground(Color.white);
        passwordLbl.setFont(new Font("Verdana",Font.PLAIN,16));
        passwordLbl.setForeground(Color.white);
        userLbl.setFont(new Font("Verdana",Font.PLAIN,16));
        userLbl.setForeground(Color.white);

        GridBagConstraints gbc =  new GridBagConstraints();
        

        this.add(title);
        this.add(userLbl);
        this.add(passwordLbl);
        
        

    }
}
