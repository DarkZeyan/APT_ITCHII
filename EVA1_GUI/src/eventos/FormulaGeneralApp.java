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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FormulaGeneralApp extends JFrame{
    private JButton proceed, exit, clean;
    private JTextField inputCTC,inputCTL,inputCTI;
    private JTextArea result;
    

    public FormulaGeneralApp() {
        super("Aplicacion Formula General");
        initComponents(this);
        createComponentsUsingEvents(this);
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(255,33,92));
        this.setBounds(600,600,1000,700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void initComponents(JFrame window) {

        JLabel title = new JLabel("Formula General");

        // title.setBounds(450, 50, 300, 30);
        title.setSize(300, 50);

        JLabel cTCLbl,cTLLbl,cTILbl, resultLbl;
        cTCLbl = new JLabel("Termino Cuadratico");
        cTLLbl = new JLabel("Termino Lineal");
        cTILbl = new JLabel("Termino Independiente");
        resultLbl = new JLabel("Resultado");
        cTCLbl.setBounds(200, 100, 250, 20);
        cTLLbl.setBounds(200, 140, 250, 20);
        cTILbl.setBounds(200, 180, 250, 20);
        resultLbl.setBounds(300, 275, 250, 20);
        title.setFont(new Font("Serif", Font.PLAIN, 24));
        resultLbl.setFont(new Font("Serif", Font.PLAIN, 24));
        cTCLbl.setFont(new Font("Serif", Font.PLAIN, 24));
        cTLLbl.setFont(new Font("Serif", Font.PLAIN, 24));
        cTILbl.setFont(new Font("Serif", Font.PLAIN, 24));

        title.setLocation(400, 30);
        inputCTC = new JTextField();
        inputCTC.setLocation(400, 100);
        window.add(inputCTC);
        inputCTC.setBounds(450, 100, 300, 20);
        inputCTL = new JTextField();
        inputCTL.setLocation(400, 140);
        window.add(inputCTL);
        inputCTL.setBounds(450, 140, 300, 20);
        inputCTI = new JTextField();
        inputCTI.setLocation(400, 180);
        window.add(inputCTI);
        inputCTI.setBounds(450, 180, 300, 20);
        result = new JTextArea("Digita los coeficientes para imprimir el resultado");
        result.setBounds(450, 230, 250, 150);
        result.setOpaque(true);
        result.setSize(300, 125);
        result.setEditable(false);
        window.add(title);
        window.add(cTCLbl);
        window.add(cTLLbl);
        window.add(cTILbl);
        window.add(resultLbl);
        window.add(result);
    }

    private void createComponentsUsingEvents(JFrame window) {
        proceed = new JButton("Calcular raíces");
        exit = new JButton("Salir");
        clean = new JButton("Limpiar campos");

        proceed.setSize(150, 50);
        exit.setSize(150, 50);
        clean.setSize(150, 50);

        proceed.setLocation(300, 400);
        exit.setLocation(500, 400);
        clean.setLocation(400,480);


        //Focus TextFields.

        inputCTC.addFocusListener(new FocusListener(){

            @Override
            public void focusGained(FocusEvent e){
                inputCTC.setBackground(new Color(115,192,255));
                inputCTC.setForeground(Color.black);
            }

            @Override
            public void focusLost(FocusEvent e){
                inputCTC.setBackground(new Color(53,109,156));
                inputCTC.setForeground(Color.white);
            }

        });
        inputCTL.addFocusListener(new FocusListener(){

            @Override
            public void focusGained(FocusEvent e){
                inputCTL.setBackground(new Color(115,192,255));
                inputCTL.setForeground(Color.black);
            }

            @Override
            public void focusLost(FocusEvent e){
                inputCTL.setBackground(new Color(53,109,156));
                inputCTL.setForeground(Color.white);
            }

        });
        inputCTI.addFocusListener(new FocusListener(){

            @Override
            public void focusGained(FocusEvent e){
                inputCTI.setBackground(new Color(115,192,255));
                inputCTI.setForeground(Color.black);
            }

            @Override
            public void focusLost(FocusEvent e){
                inputCTI.setBackground(new Color(53,109,156));
                inputCTI.setForeground(Color.white);
            }

        });
    

        // Add each button actions.
        proceed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    // Fibonacci fb = new Fibonacci(Byte.parseByte(input.getText()));

                    if (inputCTC.getText().equals("") || inputCTI.getText().equals("") || inputCTL.getText().equals(""))
                        throw new Exception();
                    else{
                        FormulaGeneral fg = new FormulaGeneral(Byte.parseByte(inputCTC.getText()), Byte.parseByte(inputCTL.getText()), Byte.parseByte(inputCTI.getText()));
                        result.setText("La raiz 1 es: "+fg.x1()+"\n"+"La raiz 2 es: "+fg.x2());
                        fg=null;
                    }
                    
                    // result.setText(fb.getFibonacciString());
                    // fb = null;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(window, "La entrada no es un numero, coloca uno e intenta nuevamente",
                            "ERROR", JOptionPane.ERROR_MESSAGE);

                }catch(NegativeDiscriminatorException ex){
                    JOptionPane.showMessageDialog(window, ex.getMessage(),
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(window,
                            "Uno de los campos esta vacio, llenalo e intentalo " +  
                                    "nuevamente",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            }
        });



        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
                System.exit(0);
            }
        });

        clean.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(result.getText().equals("") && inputCTC.getText().equals("") && inputCTI.getText().equals("") && inputCTL.getText().equals(""))
                    JOptionPane.showMessageDialog(window,
                    "Los campos ya estan vacios","ERROR", JOptionPane.ERROR_MESSAGE);
                else{
                    inputCTC.setText("");                    
                    inputCTL.setText("");                    
                    inputCTI.setText("");                    
                    result.setText("");
                }
            }
        });

        // Add the buttons to the pane
        window.add(proceed);
        window.add(exit);
        window.add(clean);
    }
    public static void main(String[] args) {
        new FormulaGeneralApp();
    }
}
