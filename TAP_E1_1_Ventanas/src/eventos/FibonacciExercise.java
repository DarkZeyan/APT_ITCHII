package eventos;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
public class FibonacciExercise extends JFrame {
    private JButton proceed, exit;
    private JTextField input;
    private JTextArea result;

    public FibonacciExercise(){
        super("Fibonacci Exercise with manual GUI");
        JLabel title = new JLabel("Sucesion de fibonacci");
        this.setLocationRelativeTo(null);    
        
        // title.setBounds(450, 50, 300, 30);
        title.setSize(300,50);        

        JLabel numberLbl, resultLbl;
        numberLbl = new JLabel("Termino");
        resultLbl = new JLabel("Resultado");
        numberLbl.setBounds(350,100,250,20);
        resultLbl.setBounds(350,150,250,20);
        title.setFont(new Font("Serif",Font.PLAIN,24));
        resultLbl.setFont(new Font("Serif",Font.PLAIN,24));
        numberLbl.setFont(new Font("Serif",Font.PLAIN,24));
        
        title.setLocation(400,30 );
        input = new JTextField();
        input.setLocation(450, 100);
        this.add(input);
        input.setBounds(500, 100, 300, 20);    
        result = new JTextArea("Digita un numero arriba para mostrar la serie.");
        result.setBounds(500, 150, 250, 150);
        result.setOpaque(true);
        result.setSize(300, 50);
        result.setEditable(false);
        this.add(title);
        this.add(numberLbl);
        this.add(resultLbl);
        this.add(result);
        createButtons(this);
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(135,206,235));
        this.setBounds(600,600,1000,700);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void createButtons(JFrame window){
        proceed = new JButton("Calcular Serie");
        exit = new JButton("Salir");
        
        proceed.setSize(150, 50);
        exit.setSize(150, 50);

        proceed.setLocation(300, 250);
        exit.setLocation(500, 250);
        
        //Add each button actions.
        proceed.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

            }
        });
        
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

            }
        });


        //Add the buttons to the pane
        window.add(proceed);
        window.add(exit);
    }


    public static void main(String[] args) {
        new FibonacciExercise();
    }

}
