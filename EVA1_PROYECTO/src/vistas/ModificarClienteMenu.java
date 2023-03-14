package vistas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static vistas.MainMenu.controlador;
import javax.swing.table.*;
import modelo.*;

public class ModificarClienteMenu extends JFrame{
    
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
        JLabel title, tableTitle;
        JButton ingresarMovimientos, desactivarTarjeta;
        title = new JLabel();
        if(tarjeta!=null){
            title.setText("No. de Tarjeta: "+controlador.getMenuPrincipalView().tarjetaSeleccionada().getNumeroTarjeta());
        }else{
            title.setText("No hay ninguna tarjeta seleccionada");
        }
        tableTitle = new JLabel("Movimientos");
        GridBagConstraints gbc = new GridBagConstraints();
        movimientos = new JTable();
        DefaultTableModel dt = new DefaultTableModel(new Object[][] {

        }, new String[] {
                "Clave", "Fecha del movimiento", "Tipo Mov", "Cantidad"
        });
        movimientos.setModel(dt);
    }
}
