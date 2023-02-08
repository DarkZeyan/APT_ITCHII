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
public class FibonacciOOP  extends JFrame{
    private JButton proceed, exit;
    private JTextField input;
    private JTextArea result;

    public FibonacciOOP(){
        super("Fibonacci usando POO");
        initComponents(this);
        createButtons(this);
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(180,206,235));
        this.setBounds(600,600,1000,700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void initComponents(JFrame window){
      
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
        window.add(input);
        input.setBounds(450, 100, 300, 20);    
        result = new JTextArea("Digita un numero arriba para mostrar la serie.");
        result.setBounds(450, 150, 250, 150);
        result.setOpaque(true);
        result.setSize(300, 125);
        result.setEditable(false);
        window.add(title);
        window.add(numberLbl);
        window.add(resultLbl);
        window.add(result);
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
                        Fibonacci fb = new Fibonacci();
                        fb.setNumeroTerminos(Byte.parseByte(input.getText()));
                        
                        if(input.getText()==null || input.getText()=="") throw new NumberFormatException();
                        else if(fb.getNumeroTerminos()<0) throw new Exception("Numero invalido");
                        result.setText(fb.getFibonacciString());
                        fb = null;
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
    public static void main(String[] args) {
        new FibonacciOOP();
    }
}


class Fibonacci{
    public Fibonacci() {
        setNumeroTerminos(numeroTerminos);
    }

    byte numeroTerminos;
    public byte getNumeroTerminos() {
        return numeroTerminos;
    }
    public void setNumeroTerminos(byte numeroTerminos) {
        this.numeroTerminos = numeroTerminos;
    }
    private static long calculateFibonacci(long n){
        if(n==0) 
            return 0;
        if(n==1)
            return 1;
        else
            return calculateFibonacci(n-1)+calculateFibonacci(n-2);
    }

    public String getFibonacciString(){
        String fiboString="";
        for(byte i=0; i<=numeroTerminos; i++){
            fiboString+=(calculateFibonacci(i))+" ";
            if(i>0 && i%5==0) fiboString+="\n";
        }
        return fiboString;
    }
    


}