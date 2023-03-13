package vistas;

import javax.swing.*;

import modelo.Fecha;
import modelo.Tarjeta;

import java.awt.*;
import java.awt.event.*;
import static vistas.MainMenu.controlador;


public class RegistrarTarjetaMenu extends JFrame{
   
    JTextField numTarjetaField, limiteCreditoField, diaCreacionField, mesCreacionField, yearCreacionField,
            diaCorteField, mesCorteField, yearCorteField, diaPagoField, mesPagoField, yearPagoField,
            tasaInteresField, anualidadField, diaAnualidadField, mesAnualidadField, yearAnualidadField;
    JLabel numTarjetaLabel, limiteCreditoLabel, fechaCreacionLabel, fechaCorteLabel, fechaPagoLabel,
            tasaInteresLabel, anualidadLabel, fechaAnualidadLabel;
    JButton createCard;
    Tarjeta tarjeta;
    public RegistrarTarjetaMenu() {
        super("Registrar nueva tarjeta");
        this.setSize(1280, 720);
        this.setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(45, 45, 45));
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel title = new JLabel("Registrar nueva tarjeta");
        title.setFont(new Font("Verdana", Font.PLAIN, 24));
        title.setForeground(Color.white);

        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 100, 100, 50);
        //
        gbc.gridx = 1;
        gbc.gridy = 0;

        this.add(title, gbc);
        JButton returnMenu = new JButton("Regresar al menu anterior");
        // Funcionalidad del boton
        returnMenu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Si el numero de las tarjetas del cliente es menor a 0
                try {
                    if (controlador.getMenuPrincipalView().clientes
                            .get(controlador.getMenuPrincipalView().clientes.size() - 1).getTarjetasCliente().isEmpty()
                            || controlador.getNewClientView().cliente.getTarjetasCliente().isEmpty())
                        throw new Exception("No puedes regresar ya que el cliente no tiene tarjetas, creale una nueva");
                    controlador.callNewWindow(controlador.getNewCardView(), controlador.getNewClientView());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(returnMenu.getRootPane(), ex.getMessage());
                }

            }

        });
        gbc.ipady = 1;
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.fill = gbc.NONE;

        this.add(returnMenu, gbc);
        gbc.fill = gbc.NONE;
        gbc.ipady = 0;
        ImageIcon icon = new ImageIcon(this.getClass().getResource("../resources/Bancony.png"));

        icon.setImage(icon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        JLabel logo = new JLabel(icon);
        logo.setPreferredSize(new Dimension(200, 200));
        ;

        gbc.fill = gbc.NONE;
        gbc.gridx = 2;
        gbc.gridy = 0;
        this.add(logo, gbc);
        gbc.gridheight = 1;
        gbc.insets = new Insets(0, 50, 50, 50);

        numTarjetaLabel = new JLabel("Numero de tarjeta");
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(numTarjetaLabel, gbc);
        limiteCreditoLabel = new JLabel("Limite de credito");
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(limiteCreditoLabel, gbc);
        fechaCreacionLabel = new JLabel("Fecha de creacion");
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(fechaCreacionLabel, gbc);
        fechaCorteLabel = new JLabel("Fecha de corte");
        gbc.gridx = 0;
        gbc.gridy = 4;
        this.add(fechaCorteLabel, gbc);
        fechaPagoLabel = new JLabel("Fecha de pago");
        gbc.gridx = 0;
        gbc.gridy = 5;
        this.add(fechaPagoLabel, gbc);
        tasaInteresLabel = new JLabel("Tasa de interes");
        gbc.gridx = 0;
        gbc.gridy = 6;
        this.add(tasaInteresLabel, gbc);
        anualidadLabel = new JLabel("Anualidad");
        gbc.gridx = 0;
        gbc.gridy = 7;
        this.add(anualidadLabel, gbc);
        fechaAnualidadLabel = new JLabel("Fecha anualidad");
        gbc.gridx = 0;
        gbc.gridy = 8;
        this.add(fechaAnualidadLabel, gbc);

        numTarjetaField = new JTextField("INGRESE NUMERO DE TARJETA");
        gbc.fill = gbc.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(numTarjetaField, gbc);
        limiteCreditoField = new JTextField("INGRESE LIMITE DE CREDITO");
        gbc.fill = gbc.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(limiteCreditoField, gbc);
        diaCreacionField = new JTextField("DIA");
        gbc.ipadx = 40;
        gbc.fill = gbc.NONE;
        gbc.anchor = gbc.WEST;
        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(diaCreacionField, gbc);
        mesCreacionField = new JTextField("MES");
        gbc.anchor = gbc.CENTER;
        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(mesCreacionField, gbc);
        yearCreacionField = new JTextField("AÑO");
        gbc.anchor = gbc.EAST;
        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(yearCreacionField, gbc);
        diaCorteField = new JTextField("DIA");
        gbc.anchor = gbc.WEST;
        gbc.gridx = 1;
        gbc.gridy = 4;
        this.add(diaCorteField, gbc);
        mesCorteField = new JTextField("MES");
        gbc.anchor = gbc.CENTER;
        gbc.gridx = 1;
        gbc.gridy = 4;
        this.add(mesCorteField, gbc);
        yearCorteField = new JTextField("AÑO");
        gbc.anchor = gbc.EAST;
        gbc.gridx = 1;
        gbc.gridy = 4;
        this.add(yearCorteField, gbc);
        diaPagoField = new JTextField("DIA");
        gbc.anchor = gbc.WEST;
        gbc.gridx = 1;
        gbc.gridy = 5;
        this.add(diaPagoField, gbc);
        mesPagoField = new JTextField("MES");
        gbc.anchor = gbc.CENTER;
        gbc.gridx = 1;
        gbc.gridy = 5;
        this.add(mesPagoField, gbc);
        yearPagoField = new JTextField("AÑO");
        gbc.anchor = gbc.EAST;
        gbc.gridx = 1;
        gbc.gridy = 5;
        this.add(yearPagoField, gbc);
        tasaInteresField = new JTextField("INGRESE TASA DE INTERES");
        gbc.ipadx = 0;
        gbc.anchor = gbc.CENTER;
        gbc.fill = gbc.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 6;
        this.add(tasaInteresField, gbc);
        anualidadField = new JTextField("INGRESE ANUALIDAD");
        gbc.gridx = 1;
        gbc.gridy = 7;
        this.add(anualidadField, gbc);
        diaAnualidadField = new JTextField("DIA");
        gbc.ipadx = 40;
        gbc.fill = gbc.NONE;
        gbc.anchor = gbc.WEST;
        gbc.gridx = 1;
        gbc.gridy = 8;
        this.add(diaAnualidadField, gbc);
        mesAnualidadField = new JTextField("MES");
        gbc.anchor = gbc.CENTER;
        gbc.gridx = 1;
        gbc.gridy = 8;
        this.add(mesAnualidadField, gbc);
        yearAnualidadField = new JTextField("AÑO");
        gbc.anchor = gbc.EAST;
        gbc.gridx = 1;
        gbc.gridy = 8;
        this.add(yearAnualidadField, gbc);
        createCard = new JButton("Registrar tarjeta");
        createCard.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                   tarjeta  = new Tarjeta(String.valueOf(controlador.getMenuPrincipalView().clientes.size()),
                            numTarjetaField.getText(), Double.parseDouble(limiteCreditoField.getText()),
                            new Fecha(Integer.parseInt(diaCreacionField.getText()),
                                    Integer.parseInt(mesCreacionField.getText()),
                                    Integer.parseInt(yearCreacionField.getText())),
                            new Fecha(Integer.parseInt(diaCorteField.getText()),
                                    Integer.parseInt(mesCorteField.getText()),
                                    Integer.parseInt(yearCorteField.getText())),
                            new Fecha(Integer.parseInt(diaPagoField.getText()),
                                    Integer.parseInt(mesPagoField.getText()),
                                    Integer.parseInt(yearPagoField.getText())),
                            Double.parseDouble(tasaInteresField.getText()),
                            Double.parseDouble(anualidadField.getText()),
                            new Fecha(Integer.parseInt(diaAnualidadField.getText()),
                                    Integer.parseInt(mesAnualidadField.getText()),
                                    Integer.parseInt(yearAnualidadField.getText())));
                        controlador.getNewClientView().cliente.getTarjetasCliente().add(tarjeta);
                  
                        
                        controlador.getMenuPrincipalView().revalidate();
                        controlador.getMenuPrincipalView().repaint();
                        controlador.getMenuPrincipalView().clientsTable.repaint();
                        JOptionPane.showMessageDialog(createCard.getRootPane(), "Cliente registrado con exito");
                        controlador.callNewWindow(controlador.getNewCardView(), controlador.getNewClientView());

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(createCard.getRootPane(), ex.getMessage());
                }
            }

        });
        gbc.gridy = 9;
        gbc.ipadx = 0;
        gbc.fill = gbc.HORIZONTAL;
        gbc.gridx = 1;
        this.add(createCard, gbc);
    }
}
