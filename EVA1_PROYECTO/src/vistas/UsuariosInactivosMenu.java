package vistas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static vistas.MainMenu.controlador;
import javax.swing.table.*;
public class UsuariosInactivosMenu extends JFrame{
    JTable inactivos;
    public UsuariosInactivosMenu(){
        super("Clientes Inactivos");
        this.setSize(1280,720);
        this.setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(45,45,45));
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 private void initComponents(){
        JLabel  title;
        JButton  reactivarTarjeta;
        title = new JLabel("Tarjetas inactivas");      

   
        GridBagConstraints gbc = new GridBagConstraints();
       
        DefaultTableModel dt = new DefaultTableModel(new Object[][] {

        }, new String[] {
                "CURP", "Numero Tarjeta"
        });
        inactivos = new JTable(dt);
        reactivarTarjeta = new JButton("Reactivar tarjeta");
        title.setFont(new Font("Verdana", Font.PLAIN, 18));
        title.setForeground(Color.white);

        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 50, 50, 50);
        //
        gbc.gridx = 1;
        gbc.gridy = 0;

        this.add(title, gbc);
        JButton returnMenu = new JButton("Regresar al menu anterior");
        // Funcionalidad del boton
        returnMenu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {                
                    controlador.callNewWindow(controlador.getInactiveClientView(), controlador.getMenuPrincipalView());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(returnMenu.getRootPane(), ex.getMessage());
                }
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
        gbc.insets = new Insets(-30, -50, 30, -50);        
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = gbc.BOTH;
        inactivos.setPreferredScrollableViewportSize(new Dimension(500, 200));
        JScrollPane sp = new JScrollPane(inactivos);
        this.add(sp,gbc);
        gbc.insets = new Insets(10, 0, 30, 0);      
        gbc.fill=gbc.NONE;
        gbc.gridx=1;
        gbc.gridy=2;
        gbc.anchor=gbc.CENTER;
        this.add(reactivarTarjeta,gbc);
        reactivarTarjeta.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {            
             
            }
            
        });
    }
}