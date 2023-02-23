package quebrados;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class OperationsView extends JPanel {
    ArrayList<Quebrado> quebrados;
    JLabel title, lblNumeradores, lblDenominadores, suma, resta, multiplicacion, division;
    JButton clean, calculate;

    public OperationsView() {
        quebrados = new ArrayList<Quebrado>();
        this.setBackground(new Color(41, 186, 230));
        this.setLayout(new GridBagLayout());
        initComponents();
    }

    public OperationsView(CreateView cv) {
        quebrados = cv.quebrados;
        this.setBackground(new Color(41, 186, 230));
        this.setLayout(new GridBagLayout());
        initComponents();
    }

    public void initComponents() {

        title = new JLabel("Realizar calculos", SwingConstants.CENTER);
        title.setFont(new Font("Tahoma", Font.BOLD, 36));
        title.setForeground(Color.white);
        title.setOpaque(true);
        title.setBackground(new Color(107, 191, 255));
        title.setBorder(BorderFactory.createEmptyBorder(20, 150, 20, 150));

        JPanel dataContainer = new JPanel();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        dataContainer.setForeground(Color.white);
        dataContainer.setOpaque(true);
        dataContainer.setBackground(new Color(0, 98, 128));
        dataContainer.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        GridBagConstraints dgbc = new GridBagConstraints();
        dataContainer.setLayout(new GridBagLayout());
        if (quebrados.size() == 2) {
            dgbc.weightx = 1.;
            dgbc.fill = GridBagConstraints.HORIZONTAL;
            dgbc.gridwidth = GridBagConstraints.REMAINDER;
            dgbc.insets = new Insets(10, 0, 10, 0);
            lblNumeradores = new JLabel("Quebrado No.1: " + quebrados.get(0).toString());
            lblNumeradores.setFont(new Font("Tahoma", Font.BOLD, 16));
            lblNumeradores.setForeground(Color.white);

            lblDenominadores = new JLabel("Quebrado No.2: " + quebrados.get(1).toString());
            lblDenominadores.setFont(new Font("Tahoma", Font.BOLD, 16));
            lblDenominadores.setForeground(Color.white);
            suma = new JLabel("Suma: ");
            resta = new JLabel("Resta: ");
            multiplicacion = new JLabel("Multiplicacion: ");
            division = new JLabel("Division: ");
            suma.setFont(new Font("Tahoma", Font.BOLD, 16));
            suma.setForeground(Color.white);
            resta.setFont(new Font("Tahoma", Font.BOLD, 16));
            resta.setForeground(Color.white);
            multiplicacion.setFont(new Font("Tahoma", Font.BOLD, 16));
            multiplicacion.setForeground(Color.white);
            division.setFont(new Font("Tahoma", Font.BOLD, 16));
            division.setForeground(Color.white);
            dataContainer.add(lblNumeradores, dgbc);
            dataContainer.add(lblDenominadores, dgbc);
            dataContainer.add(suma, dgbc);
            dataContainer.add(resta, dgbc);
            dataContainer.add(multiplicacion, dgbc);
            dataContainer.add(division, dgbc);
        } else {
            lblNumeradores = new JLabel("<html> No hay quebrados suficientes para <br>realizar operaciones </html>",
                    SwingConstants.CENTER);
            lblNumeradores.setFont(new Font("Tahoma", Font.BOLD, 24));
            lblNumeradores.setForeground(Color.white);

            dataContainer.add(lblNumeradores, gbc);

        }

        JPanel btnContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnContainer.setBackground(new Color(107, 191, 255));
        btnContainer.setBorder(new EmptyBorder(20, 20, 20, 20));
        initButtons();
        btnContainer.add(calculate);
        btnContainer.add(clean);

        this.add(title, gbc);
        this.add(dataContainer, gbc);
        this.add(btnContainer, gbc);

    }

    public void initButtons() {
        calculate = new JButton("Realizar operaciones");
        clean = new JButton("Limpiar campos");

        clean.setBackground(Color.black);
        clean.setForeground(Color.white);
        calculate.setBackground(Color.black);
        calculate.setForeground(Color.white);

        calculate.setFont(new Font("Tahoma", Font.BOLD, 12));
        clean.setFont(new Font("Tahoma", Font.BOLD, 12));

        clean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                try {
                    if (suma == null)
                        throw new Exception("No hay quebrados para procesar las operaciones");
                    if (suma.getText().equalsIgnoreCase("Suma: "))
                        throw new Exception("Los campos ya estan vacios");
                    else {
                        suma.setText("Suma: ");
                        resta.setText("Resta: ");
                        multiplicacion.setText("Multiplicacion: ");
                        division.setText("Division: ");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                try {
                    if (quebrados.size() == 2) {
                        OpQuebrados oq = new OpQuebrados(quebrados.get(0), quebrados.get(1));
                        
                        suma.setText("Suma: "+oq.suma().toString());
                        resta.setText("Resta: "+oq.resta().toString());
                        multiplicacion.setText("Multiplicacion: "+oq.multiplicacion().toString());
                        division.setText("Division: "+oq.division().toString());

                    } else {
                        throw new Exception("Numero de quebrados insuficiente");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    public ArrayList<Quebrado> getQuebrados() {
        return quebrados;
    }

    public void setQuebrados(ArrayList<Quebrado> quebrados) {
        this.quebrados = quebrados;
    }

}