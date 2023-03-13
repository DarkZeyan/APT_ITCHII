package vistas;
import javax.swing.*;

import modelo.Cliente;
import modelo.Fecha;

import static vistas.MainMenu.controlador;
import java.awt.*;
import java.awt.event.*;
public class NuevoClienteMenu extends JFrame{
    boolean flag;
    public NuevoClienteMenu(){
        super("Nuevo cliente");
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
        JLabel lblCurp, lblNombre, lblApPaterno, lblApMaterno, lblFechaNacimiento;
        JTextField curpField, nombreField, apPaternoField, apMaternoField, diaField, mesField, yearField;
        lblCurp= new JLabel("CURP");
        lblCurp.setFont(new Font("Verdana",Font.PLAIN,12));
        lblCurp.setForeground(Color.white);
        gbc.gridx=0;
        gbc.gridy=1;
        this.add(lblCurp,gbc);
        lblNombre= new JLabel("Nombre");
        lblNombre.setFont(new Font("Verdana",Font.PLAIN,12));
        lblNombre.setForeground(Color.white);
        gbc.gridx=0;
        gbc.gridy=2;
        this.add(lblNombre,gbc);
        lblApPaterno= new JLabel("Apellido paterno");
        lblApPaterno.setFont(new Font("Verdana",Font.PLAIN,12));
        lblApPaterno.setForeground(Color.white);
        gbc.gridx=0;
        gbc.gridy=3;
        this.add(lblApPaterno,gbc);
        lblApMaterno= new JLabel("Apellido materno");     
        lblApMaterno.setFont(new Font("Verdana",Font.PLAIN,12));
        lblApMaterno.setForeground(Color.white);
        gbc.gridx=0;
        gbc.gridy=4;
        this.add(lblApMaterno,gbc);   
        lblFechaNacimiento= new JLabel("Fecha de nacimiento");
        lblFechaNacimiento.setFont(new Font("Verdana",Font.PLAIN,12));
        lblFechaNacimiento.setForeground(Color.white);
        gbc.gridx=0;
        gbc.gridy=5;
        this.add(lblFechaNacimiento,gbc);

        curpField = new JTextField("INGRESE SU CURP");
        gbc.fill=gbc.HORIZONTAL;
        gbc.gridx=1;
        gbc.gridy=1;
        this.add(curpField,gbc);
        nombreField = new JTextField("INGRESE SU NOMBRE");
        gbc.gridx=1;
        gbc.gridy=2;
        this.add(nombreField,gbc);
        apPaternoField = new JTextField("INGRESE SU APELLIDO PATERNO");
        gbc.gridx=1;
        gbc.gridy=3;
        this.add(apPaternoField,gbc);
        apMaternoField = new JTextField("INGRESE SU APELLIDO MATERNO");
        gbc.gridx=1;
        gbc.gridy=4;
        this.add(apMaternoField,gbc);
        gbc.fill=gbc.NONE;
        gbc.ipadx=40;
        gbc.insets = new Insets(-50, 50, 0, 50);

    
        diaField = new JTextField("DIA");
        gbc.anchor=gbc.WEST;
        gbc.gridx=1;
        gbc.gridy=5;
        this.add(diaField,gbc);
        mesField = new JTextField("MES");
        gbc.gridx=1;
        gbc.gridy=5;
        gbc.anchor=gbc.CENTER;
        this.add(mesField,gbc);
        yearField = new JTextField("AÑO");
        gbc.gridx=1;
        gbc.gridy=5;
        gbc.anchor=gbc.EAST;
        this.add(yearField,gbc);
        gbc.anchor=gbc.CENTER;
        gbc.ipadx=0;
        gbc.insets=new Insets(0, 0, 50, 0);
        JButton createClient = new JButton("Registrar cliente y crear 1ra tarjeta");
        createClient.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                try{
                    Cliente cliente = new Cliente(curpField.getText(), nombreField.getText(), apPaternoField.getText(),
                    apMaternoField.getText(), new 
                    Fecha(Integer.parseInt(diaField.getText()),Integer.parseInt(mesField.getText()),Integer.parseInt(yearField.getText())));
                    controlador.getMenuPrincipalView().clientes.add(cliente);
                    synchronized(controlador.getNewCardView()){
                        controlador.callNewWindow(controlador.getNewClientView(), controlador.getNewCardView());
                        controlador.getNewCardView().wait();
                    }

                 
                    controlador.getMenuPrincipalView().revalidate();
                    controlador.getMenuPrincipalView().repaint();
                    controlador.getMenuPrincipalView().clientsTable.repaint();
                    JOptionPane.showMessageDialog(createClient.getRootPane(), "Cliente registrado con exito");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(createClient.getRootPane(), ex.getMessage());
                }
            }
            
        });
        gbc.gridy=6;
        gbc.fill=gbc.HORIZONTAL;
        gbc.gridx=1;
        this.add(createClient,gbc);



    }
}
