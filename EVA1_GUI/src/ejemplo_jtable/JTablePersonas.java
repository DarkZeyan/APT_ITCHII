package ejemplo_jtable;


import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.JButton;
import javax.swing.JPanel;
public class JTablePersonas extends JFrame{
    
    JTable table;
    JScrollPane scrollPane;
    JButton btnToggleConsole;
    JPanel pnl_buttons;


    public JTablePersonas(){
        super("Personas");

        // Desactivarla despues de mostrar los datos en consola
        DatosPersonas datos = new DatosPersonas();

        
        table = new JTable();
        table.setModel(new ModeloPersonas());

        table.setPreferredScrollableViewportSize(new Dimension(700,300));
        scrollPane = new JScrollPane(table);
        this.add(scrollPane,BorderLayout.CENTER);

        pnl_buttons = new JPanel();
        this.add(pnl_buttons,BorderLayout.SOUTH);
        btnToggleConsole = new JButton("Ver datos en consola");
        pnl_buttons.add(btnToggleConsole);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnToggleConsole.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //
                datos.deployDataOnConsole();    
            }
        });
        
    }
    public static void main(String[] args) {
        
        new JTablePersonas();
    }
}
