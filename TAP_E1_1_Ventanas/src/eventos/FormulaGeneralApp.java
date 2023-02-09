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
        this.getContentPane().setBackground(new Color(180,206,235));
        this.setBounds(600,600,1000,700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void initComponents(JFrame window) {

        JLabel title = new JLabel("Sucesion de fibonacci");

        // title.setBounds(450, 50, 300, 30);
        title.setSize(300, 50);

        JLabel cTCLbl,cTLLbl,cTILbl, resultLbl;
        cTCLbl = new JLabel("Termino Cuadratico");
        cTLLbl = new JLabel("Termino Lineal");
        cTILbl = new JLabel("Termino Independiente");
        resultLbl = new JLabel("Resultado");
        cTCLbl.setBounds(300, 100, 250, 20);
        cTLLbl.setBounds(300, 100, 250, 20);
        cTILbl.setBounds(300, 100, 250, 20);
        resultLbl.setBounds(300, 150, 250, 20);
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
        inputCTL.setLocation(400, 100);
        window.add(inputCTL);
        inputCTL.setBounds(450, 100, 300, 20);
        inputCTI = new JTextField();
        inputCTI.setLocation(400, 100);
        window.add(inputCTI);
        inputCTI.setBounds(450, 100, 300, 20);
        result = new JTextArea("Digita un numero arriba para mostrar la serie.");
        result.setBounds(450, 150, 250, 150);
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
        proceed = new JButton("Calcular Serie");
        exit = new JButton("Salir");
        clean = new JButton("Limpiar resultados");
        proceed.setSize(150, 50);
        exit.setSize(150, 50);

        proceed.setLocation(300, 300);
        exit.setLocation(500, 300);

        // Add each button actions.
        proceed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    // Fibonacci fb = new Fibonacci(Byte.parseByte(input.getText()));

                    // if (input.getText() == null || input.getText() == "")
                    //     throw new NumberFormatException();
                    // else if (fb.getNumeroTerminos() < 0)
                    //     throw new Exception("Numero invalido");
                    // result.setText(fb.getFibonacciString());
                    // fb = null;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(window, "La entrada no es un numero, coloca uno e intenta nuevamente",
                            "ERROR", JOptionPane.ERROR_MESSAGE);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(window,
                            "La serie no se puede calcular con numeros negativos, intentalo " +
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

        // Add the buttons to the pane
        window.add(proceed);
        window.add(exit);
    }

}
