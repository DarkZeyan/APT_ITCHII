package vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

import modelo.Cliente;
import modelo.Tarjeta;
import modelo.Usuario;
import controlador.Controller;
import javax.swing.table.DefaultTableModel;

public class MainMenu extends JFrame {
    Usuario usuario;
    ArrayList<Cliente> clientes;
    JTable clientsTable;
    DefaultTableModel tblModel;
    static Controller controlador;

    public MainMenu(Usuario usuario) {

        super("BANCONY -  Menu principal");
        this.usuario = usuario;
        clientes = new ArrayList<Cliente>();

        this.setSize(1280, 720);
        this.setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(45, 45, 45));
        initComponents();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ModificarClienteMenu mcm = new ModificarClienteMenu();

        NuevoClienteMenu ncm = new NuevoClienteMenu();
        UsuariosInactivosMenu uim = new UsuariosInactivosMenu();
        RegistrarTarjetaMenu rtm = new RegistrarTarjetaMenu();
        controlador = new Controller(this, rtm, uim, ncm, mcm);
    }

    private void initComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.anchor = gbc.NORTH;

        JLabel title = new JLabel(("Bienvenido a Bancony " + usuario.getUsername()).toUpperCase());
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Verdana", Font.BOLD, 16));
        this.add(title, gbc);
        gbc.anchor = gbc.CENTER;
        tblModel = new DefaultTableModel(new Object[][] {

        }, new String[] {
                "CURP CLIENTE", "NUMERO TARJETA"
        });
        gbc.insets = new Insets(50, 100, 100, 100);
        clientsTable = new JTable(tblModel);
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.fill = gbc.BOTH;
        clientsTable.setPreferredScrollableViewportSize(new Dimension(400, 200));
        JScrollPane sp = new JScrollPane(clientsTable);

        this.add(sp, gbc);

        // reset del gbc
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.fill = gbc.NONE;
        // añadir botones
        JButton registrarCliente = new JButton("Registrar nuevo cliente");
        gbc.weightx = 0.2;
        gbc.weighty = 0.2;
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(registrarCliente, gbc);
        JButton modificarCliente = new JButton("Modificar tarjeta seleccionada");
        gbc.weightx = 0.2;
        gbc.weighty = 0.2;
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(modificarCliente, gbc);
        JButton clientesInactivos = new JButton("Listado de clientes inactivos");
        gbc.weightx = 0.2;
        gbc.weighty = 0.2;
        gbc.gridx = 2;
        gbc.gridy = 2;
        this.add(clientesInactivos, gbc);

        // Añadir funcionalidad a botones;
        registrarCliente.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.callNewWindow(controlador.getMenuPrincipalView(), controlador.getNewClientView());
            }

        });
        modificarCliente.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              
                controlador.callNewWindow(controlador.getMenuPrincipalView(), controlador.getModifyClientView());
                controlador.getModifyClientView().tarjeta=tarjetaSeleccionada();
                controlador.getModifyClientView().drawTitle();

                
            }

        });
        clientesInactivos.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.callNewWindow(controlador.getMenuPrincipalView(), controlador.getInactiveClientView());
            }

        });

    }

    public void fillTable(ArrayList<Cliente> clientes) {
        if (clientes != null) {
            try {
                for (Cliente cliente : clientes) {
                    Vector v = new Vector();
                    v.add(cliente.getCurp());
                    for (Tarjeta tarjeta : cliente.getTarjetasCliente()) {
                        v.add(tarjeta.getNumeroTarjeta());
                        DefaultTableModel dt = (DefaultTableModel) clientsTable.getModel();
                        dt.addRow(v);
                    }
                }

            } catch (Exception e) {

            }
        }
    }
    public Tarjeta tarjetaSeleccionada(){
        int fila = clientsTable.getSelectedRow();
        int column = clientsTable.getSelectedColumn();
        Tarjeta tarjeta=null;
        if(fila>=0 && column>=0){
            try{
                for(Cliente cliente : clientes){
                 
                    for(Tarjeta tarjetaTemp : cliente.getTarjetasCliente()){
                 
                        if(tarjetaTemp.getNumeroTarjeta().equals((clientsTable.getModel().getValueAt(fila, column)))){
                            
                            tarjeta=tarjetaTemp;
                            return tarjeta;
                        }
                    }
                }
            }catch(Exception e){

            }
            
        }
        return tarjeta;
    }
}
