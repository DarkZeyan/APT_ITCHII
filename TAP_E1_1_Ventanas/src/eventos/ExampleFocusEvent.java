package eventos;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class ExampleFocusEvent extends JFrame{

    JLabel lblName, lblLastName,lblAge;
    JTextField txtName, txtLastName, txtAge;
    JButton exit;
    public ExampleFocusEvent(){
        super("Focus event");
        this.setLayout(null);
        
        lblName = new JLabel("Nombre: ");
        lblLastName = new JLabel("Apellido: ");
        lblAge = new JLabel("Edad: ");


        txtName = new JTextField(80);
        txtLastName = new JTextField(80);
        txtAge = new JTextField(80);

        exit = new JButton("Salir");


        // set backgrounds and foregrounds.
        txtName.setBackground(Color.LIGHT_GRAY);
        txtName.setForeground(Color.BLACK);
        txtLastName.setBackground(Color.LIGHT_GRAY);
        txtLastName.setForeground(Color.BLACK);
        txtAge.setBackground(Color.LIGHT_GRAY);
        txtAge.setForeground(Color.BLACK);


        this.add(lblName);
        this.add(lblLastName);
        this.add(lblAge);
        this.add(txtName);
        this.add(txtLastName);
        this.add(txtAge);
        this.add(exit);

        lblName.setBounds(100,100,100,50);
        txtName.setBounds(220,100,200,50);
        
        lblLastName.setBounds(100,160,100,50);
        txtLastName.setBounds(220,160,200,50);

        lblAge.setBounds(100,220,100,50);
        txtAge.setBounds(220,220,200,50);
    

        exit.setBounds(220,280,100,50);

        txtName.addFocusListener(new FocusListener(){

            @Override
            public void focusGained(FocusEvent e){
                txtName.setBackground(Color.red);
                txtName.setForeground(Color.white);
            }

            @Override
            public void focusLost(FocusEvent e){
                txtName.setBackground(Color.LIGHT_GRAY);
                txtName.setForeground(Color.BLACK);
            }

        });
        txtLastName.addFocusListener(new FocusListener(){

            @Override
            public void focusGained(FocusEvent e){
                txtLastName.setBackground(Color.red);
                txtLastName.setForeground(Color.white);
            }

            @Override
            public void focusLost(FocusEvent e){
                txtLastName.setBackground(Color.LIGHT_GRAY);
                txtLastName.setForeground(Color.BLACK);
            }

        });
        txtAge.addFocusListener(new FocusListener(){

            @Override
            public void focusGained(FocusEvent e){
                txtAge.setBackground(Color.red);
                txtAge.setForeground(Color.white);
            }

            @Override
            public void focusLost(FocusEvent e){
                txtAge.setBackground(Color.LIGHT_GRAY);
                txtAge.setForeground(Color.BLACK);
            }

        });
        this.setBounds(100,100,500,600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new ExampleFocusEvent();
    }
}
