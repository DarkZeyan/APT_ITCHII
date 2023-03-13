package vistas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import modelo.Usuario;
import static eva1_proyecto.App.saveUsers;
public class LoginScreen extends JFrame{
    private JLabel title;
    private JLabel passwordLbl;
    private JLabel userLbl;
    private JLabel legend;
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton signIn, createAccount;
    private ArrayList<Usuario> usuarios;


    public LoginScreen(ArrayList<Usuario> usuarios){
        super("BANCONY -  INICIO DE SESION");
        this.usuarios = usuarios;
        this.setSize(600,600);
        this.setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(45,45,45));
        initComponents(this);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void initComponents(JFrame window){
        title = new JLabel("BANCONY",JLabel.CENTER);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        passwordLbl= new JLabel("Contraseña: ");
        userLbl= new JLabel("Usuario: ");

        title.setFont(new Font("Verdana",Font.PLAIN,24));
        title.setForeground(Color.white);
        passwordLbl.setFont(new Font("Verdana",Font.PLAIN,16));
        passwordLbl.setForeground(Color.white);
        userLbl.setFont(new Font("Verdana",Font.PLAIN,16));
        userLbl.setForeground(Color.white);

        GridBagConstraints gbc =  new GridBagConstraints();
        gbc.anchor=GridBagConstraints.NORTH;
        gbc.insets =  new Insets(0,225,0,0);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridheight=1;
        gbc.gridwidth=1;
        gbc.weighty=0.1;
        gbc.weightx=0;

        this.add(title,gbc);
        gbc.insets=new Insets(0, 0, 0, 0);
        gbc.weighty=0;


        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridheight=1;
        gbc.weighty=0.01;
        gbc.gridwidth=1;
        
        this.add(userLbl,gbc);        
        gbc.weighty=0;
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridheight=1;
        gbc.weighty=0.01;
        gbc.gridwidth=1;
        this.add(passwordLbl,gbc);

        gbc.weighty=0.0;

        userField =  new JTextField("Introduce tu usuario");
        passwordField =  new JPasswordField("Introduce tu contraseña");
        passwordField.setEchoChar((char)0);
        userField.setSize(150, 30);
        userField.addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {
                
               if(userField.getText().equals("Introduce tu usuario")) userField.setText("");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
               
            }   

            @Override
            public void keyReleased(KeyEvent e) {
              
                
            }

        });
        passwordField.addKeyListener(new KeyListener(){

            
            @Override
            public void keyTyped(KeyEvent e) {
                

                String psw = new String(passwordField.getPassword());
                
               if(psw.equals("Introduce tu contraseña")){
                passwordField.setText("");
                passwordField.setEchoChar('*');
               }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
               
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
                
            }

        });
        passwordField.setSize(150,30);
        
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weighty=0.01;
        this.add(userField,gbc);
        gbc.fill=GridBagConstraints.NONE;
        gbc.gridx=1;
        gbc.gridy=2;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        
        gbc.weighty=0.01;
        this.add(passwordField,gbc);

        gbc.weighty=0;
        
        
        
        legend = new JLabel("¿No tienes un usuario? Crea uno nuevo");
        legend.setFont(new Font("Verdana",Font.PLAIN,12));
        legend.setForeground(Color.white);
        
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.gridx=0;
        gbc.gridy=3;
        
        gbc.weightx=1;
        this.add(legend,gbc);
        createAccount =  new JButton("Crear usuario");
        createAccount.setSize(200,30);
        createAccount.setForeground(Color.white);
        createAccount.setBackground(Color.black);
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.gridx=1;
        gbc.gridy=3;
        
        
        this.add(createAccount,gbc);

        
        signIn = new JButton("Iniciar sesion");
        signIn.setSize(200,30);
        signIn.setForeground(Color.white);
        signIn.setBackground(Color.black);
        gbc.gridheight=1;
        gbc.gridwidth=1;
        gbc.gridx=0;
        gbc.gridy=4;
        gbc.insets = new Insets(100, 225, 220, 0);
        
        signIn.addActionListener((ActionEvent e) -> {
            int i=0;
            
            for(Usuario user: usuarios){
                
                String psw = new String(passwordField.getPassword());
                if(userField.getText().equals(user.getUsername()) && psw.equals(user.getPassword())){
                    JOptionPane.showMessageDialog(window, "Inicio de sesion exitoso");
                    saveUsers(usuarios);
                    MainMenu mm=new MainMenu(user);
                    mm.setVisible(true);
                    dispose();
                    break;
                }
                else{
                    i++;
                }
            }
            if(i==usuarios.size()){
                JOptionPane.showMessageDialog(window, "Usuario y/o contraseña incorrecto");
            }
        });

        createAccount.addActionListener((ActionEvent e) -> {
            try {
                String username = JOptionPane.showInputDialog(window, "Introduce tu usuario");
                String pw = JOptionPane.showInputDialog(window, "Introduce tu contraseña");
                if(username == null || username.equalsIgnoreCase("")) throw new Exception("Nombre de usuario invalido");
                if(pw == null || pw.equalsIgnoreCase("")) throw new Exception("Contraseña vacia intentalo nuevamente");
                
                
                JOptionPane.showMessageDialog(window,"Usuario creado exitosamente","Exito",JOptionPane.INFORMATION_MESSAGE);
                usuarios.add(new Usuario(username,pw));
                saveUsers(usuarios);
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(window, ex.getMessage(), "Error al crear usuario",JOptionPane.ERROR_MESSAGE);
            }
        });
    
        this.add(signIn,gbc);
        
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
}
