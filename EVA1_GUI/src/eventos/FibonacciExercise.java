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
        
        
        // title.setBounds(450, 50, 300, 30);
        title.setSize(300,50);        

        JLabel numberLbl, resultLbl;
        numberLbl = new JLabel("Termino");
        resultLbl = new JLabel("Resultado");
        numberLbl.setBounds(300,100,250,20);
        resultLbl.setBounds(300,150,250,20);
        title.setFont(new Font("Serif",Font.PLAIN,24));
        resultLbl.setFont(new Font("Serif",Font.PLAIN,24));
        numberLbl.setFont(new Font("Serif",Font.PLAIN,24));
        
        title.setLocation(400,30 );
        input = new JTextField();  
        input.setLocation(400, 100);
        this.add(input);
        input.setBounds(450, 100, 300, 20);    
        result = new JTextArea("Digita un numero arriba para mostrar la serie.");
        result.setBounds(450, 150, 250, 150);
        result.setOpaque(true);
        result.setSize(300, 125);
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
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void createButtons(JFrame window){
        proceed = new JButton("Calcular Serie");
        exit = new JButton("Salir");
        
        proceed.setSize(150, 50);
        exit.setSize(150, 50);

        proceed.setLocation(300, 300);
        exit.setLocation(500, 300);
        
        //Add each button actions.
        proceed.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

                    try{
                        int entrada =  Integer.parseInt(input.getText());
                        
                        if(input.getText()==null || input.getText()=="") throw new NumberFormatException();
                        else if(entrada<0) throw new Exception("Numero invalido");
                        result.setText(getFibonacciString(entrada));
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(window, "La entrada no es un numero, coloca uno e intenta nuevamente", "ERROR", JOptionPane.ERROR_MESSAGE);
                        
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(window, "La serie no se puede calcular con numeros negativos, intentalo "+
                        "nuevamente", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
               
            }
        });
        
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                window.dispose();
                System.exit(0);
            }
        });


        //Add the buttons to the pane
        window.add(proceed);
        window.add(exit);
    }

    private static int calculateFibonacci(int n){
        if(n==0) 
            return 0;
        if(n==1)
            return 1;
        else
            return calculateFibonacci(n-1)+calculateFibonacci(n-2);
    }

    private String getFibonacciString(int n){
        String fiboString="";
        for(int i=0; i<=n; i++){
            fiboString+=(calculateFibonacci(i))+" ";
            if(i>0 && i%5==0) fiboString+="\n";
        }
        return fiboString;
    }
    public static void main(String[] args) {
        new FibonacciExercise();
    }

}