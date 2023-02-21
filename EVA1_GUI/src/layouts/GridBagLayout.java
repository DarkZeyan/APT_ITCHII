package layouts;
import javax.swing.*;
import java.awt.*;


public class GridBagLayout {
    
    public static void main(String[] args) {
        new Window();
    }
    
}


class Window extends JFrame{

    public Window()
    {
        super ("GridBagLayout");
        this.setLayout(new java.awt.GridBagLayout());
        this.setSize(720, 480);
        initComponents();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void initComponents(){
        
        GridBagConstraints constraints = new GridBagConstraints();
        JTextArea txtBox = new JTextArea("Area de Texto");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 2;
        constraints.fill = GridBagConstraints.BOTH; 
        constraints.weighty = 1.0;
        this.getContentPane().add (txtBox, constraints);
        constraints.weighty = 0.0;


        JButton btn1 = new JButton ("Botón 1");
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.NONE;
        this.getContentPane().add (btn1, constraints);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weighty = 0.0;

        JButton btn2 = new JButton ("Botón 2");
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.NORTH;
        this.getContentPane().add (btn2, constraints);
        constraints.weighty = 0.0;
        constraints.anchor = GridBagConstraints.CENTER;

        JButton btn3 = new JButton ("Botón 3");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.getContentPane().add (btn3, constraints);

        JButton btn4 = new JButton ("Botón 4");
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.getContentPane().add (btn4, constraints);

        JTextField txtField = new JTextField ("Campo de texto");
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.getContentPane().add (txtField, constraints);
    }
}
