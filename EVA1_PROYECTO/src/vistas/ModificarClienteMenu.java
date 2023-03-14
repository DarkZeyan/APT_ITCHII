package vistas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import static vistas.MainMenu.controlador;
import javax.swing.table.*;
import modelo.*;

public class ModificarClienteMenu extends JFrame{
    JLabel title;
    JTable movimientos;
    Tarjeta tarjeta;
    public ModificarClienteMenu(){
        super("Modificar cliente");
        this.setSize(1280,720);
        this.setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(45,45,45));
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void initComponents(){
        JLabel  tableTitle;
        JButton ingresarMovimientos, desactivarTarjeta;
        title = new JLabel();      
        drawTitle();
        tableTitle = new JLabel("Movimientos");
        GridBagConstraints gbc = new GridBagConstraints();
       
        DefaultTableModel dt = new DefaultTableModel(new Object[][] {

        }, new String[] {
                "Clave", "Fecha del movimiento", "Tipo Mov", "Cantidad"
        });
        movimientos = new JTable(dt);
        ingresarMovimientos = new JButton("Ingresar movimiento");
        desactivarTarjeta = new JButton("Dar tarjeta de baja");

        title.setFont(new Font("Verdana", Font.PLAIN, 18));
        title.setForeground(Color.white);
        tableTitle.setFont(new Font("Verdana", Font.PLAIN, 18));
        tableTitle.setForeground(Color.white);

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
                    controlador.callNewWindow(controlador.getModifyClientView(), controlador.getMenuPrincipalView());
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
        gbc.gridx=1;
        gbc.gridy=1;
        this.add(tableTitle,gbc);
        gbc.insets = new Insets(-30, -50, 30, -50);        
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = gbc.BOTH;
        movimientos.setPreferredScrollableViewportSize(new Dimension(500, 200));
        JScrollPane sp = new JScrollPane(movimientos);
        this.add(sp,gbc);
        gbc.insets = new Insets(10, 0, 30, 0);      
        gbc.fill=gbc.NONE;
        gbc.gridx=1;
        gbc.gridy=3;
        ingresarMovimientos = new JButton("Ingresar nuevo movimiento");
        gbc.anchor=gbc.WEST;
        this.add(ingresarMovimientos,gbc);
        desactivarTarjeta =  new JButton("Desactivar tarjeta");
        gbc.anchor=gbc.EAST;
        this.add(desactivarTarjeta,gbc);
        ingresarMovimientos.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

              try {
                if(tarjeta==null) throw new Exception("No se puede agregar movimientos ya que no hay una tarjeta seleccionada");
                byte tipoMovimiento = Byte.parseByte(JOptionPane.showInputDialog(null, "Introduzca el tipo de movimiento (Numero del 1 al 3)"));
                double cantidad = Double.parseDouble(JOptionPane.showInputDialog(null, "Introduzca la cantidad"));
                int dia =  Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca el dia del movimiento"));
                int mes =  Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca el mes del movimiento"));
                int año =  Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca el año del movimiento"));
                Movimiento m = new Movimiento(tarjeta.getMovimientosTarjeta().size()+1, tipoMovimiento, cantidad, new Fecha(dia,mes,año));
                tarjeta.getMovimientosTarjeta().add(m);
                Vector v = new Vector<>();
                v.add(m.getClave());
                v.add(m.getFechaMovimiento().toString());                
                v.add(m.tipoString());
                v.add(m.getCantidad());
                dt.addRow(v);


              } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
              }
       
            }
            
        });
        desactivarTarjeta.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                 
                    if(tarjeta==null) throw new Exception("No hay una tarjeta seleccionada que desactivar");
                    tarjeta.setActiva(false);
                 DefaultTableModel mtm   = (DefaultTableModel) controlador.getMenuPrincipalView().clientsTable
                            .getModel();
                DefaultTableModel dt = (DefaultTableModel) controlador.getInactiveClientView().inactivos
                            .getModel();
                   
                    for(int i=0; i<mtm.getRowCount(); i++){
                        if (((String)mtm.getValueAt(i, 1)).equals(tarjeta.getNumeroTarjeta())) {
                            Vector v = new Vector();
                            v.add(mtm.getValueAt(i, 0));
                            v.add(tarjeta.getNumeroTarjeta());
                            dt.addRow(v);
                            mtm.removeRow(i);
                            
                    }
                    JOptionPane.showMessageDialog(null, "Tarjeta desactivada exitosamente");
                }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            
        });
    }
    void drawTitle(){
        if(tarjeta!=null){
            title.setText("No. de Tarjeta: "+tarjeta.getNumeroTarjeta());
        }else{
            title.setText("No hay ninguna tarjeta seleccionada");
        }
    }
}
