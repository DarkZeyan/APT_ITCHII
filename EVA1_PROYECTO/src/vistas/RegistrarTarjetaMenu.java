package vistas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static vistas.MainMenu.controlador;
public class RegistrarTarjetaMenu extends JFrame{
    public RegistrarTarjetaMenu(){
        super("Registrar nueva tarjeta");
        this.setSize(1280,720);
        this.setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(45,45,45));
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void initComponents(){
        GridBagConstraints gbc = new GridBagConstraints();
        
        JLabel title = new JLabel("Registrar nuevo cliente");
        title.setFont(new Font("Verdana",Font.PLAIN,24));
        title.setForeground(Color.white);
        
        gbc.gridheight=1;
        gbc.gridwidth=1;
        gbc.insets=new Insets(0, 100, 100, 50);
        //
        gbc.gridx=1;
        gbc.gridy=0;
    
        this.add(title,gbc);
        JButton returnMenu = new JButton("Regresar al menu");
        //Funcionalidad del boton
        returnMenu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               controlador.callNewWindow(controlador.getNewClientView(),controlador.getMenuPrincipalView());
            }
            
        });
        gbc.ipady=1;
        gbc.gridy=0;
        gbc.gridx=0;
        gbc.fill=gbc.BOTH;
    
        this.add(returnMenu,gbc);
        gbc.fill=gbc.NONE;
        gbc.ipady=0;
        ImageIcon icon = new ImageIcon(this.getClass().getResource("../resources/Bancony.png"));
        
        icon.setImage(icon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        JLabel logo = new JLabel(icon);
        logo.setPreferredSize(new Dimension(200,200));;

        gbc.fill=gbc.NONE;
        gbc.gridx=2;
        gbc.gridy=0;
        this.add(logo,gbc);
        gbc.gridheight=1;
        gbc.insets=new Insets(0, 50, 50, 50);
    }
}
