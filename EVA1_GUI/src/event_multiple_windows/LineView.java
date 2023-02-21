package event_multiple_windows;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LineView extends JPanel {
    ArrayList<Punto> puntos;
    JLabel title, lblX, lblY, distancia;
    JTextField txtDistancia;
    JButton clean, calculate;

    public LineView() {
        puntos = new ArrayList<Punto>();
        this.setBackground(new Color(140, 60, 255));
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(140, 60, 255));
        this.setBorder(new EmptyBorder(200, 300, 300, 300));
        initComponents();
    }

    public LineView(PointsView pv) {
        puntos = pv.puntos;
        this.setBackground(new Color(140, 60, 255));
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(140, 60, 255));
        this.setBorder(new EmptyBorder(200, 300, 300, 300));
        initComponents();

    }

    public void initComponents() {

        title = new JLabel("Crear recta");
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setForeground(Color.white);
        title.setOpaque(true);
        title.setBackground(new Color(150, 90, 255));
        title.setBorder(BorderFactory.createEmptyBorder(20, 150, 20, 150));

        JPanel dataContainer = new JPanel();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        dataContainer.setForeground(Color.white);
        dataContainer.setOpaque(true);
        dataContainer.setBackground(new Color(190, 90, 255));
        dataContainer.setBorder(BorderFactory.createEmptyBorder(100, 100, 150, 100));
        GridBagConstraints dgbc = new GridBagConstraints();
        dataContainer.setLayout(new GridBagLayout());
        if (puntos.size() == 2) {
            dgbc.weightx = 1.;
            dgbc.fill = GridBagConstraints.HORIZONTAL;
            dgbc.gridwidth = GridBagConstraints.REMAINDER;
            dgbc.insets = new Insets(15,0,15,0);
            lblX = new JLabel("Coordenadas X: " + puntos.get(0).getX() + " , " + puntos.get(1).getX());
            lblX.setFont(new Font("Arial", Font.BOLD, 24));
            lblX.setForeground(Color.white);

            lblY = new JLabel("Coordenadas Y: " + puntos.get(0).getY() + " , " + puntos.get(1).getY());
            lblY.setFont(new Font("Arial", Font.BOLD, 24));
            lblY.setForeground(Color.white);
            txtDistancia = new JTextField();
            txtDistancia.setSize(300, 50);
            dataContainer.add(lblX, dgbc);
            dataContainer.add(lblY, dgbc);
            dataContainer.add(txtDistancia, dgbc);
        } else {
            lblX = new JLabel("<html> No hay puntos suficientes <br> para calcular la recta </html>");
            lblX.setFont(new Font("Arial", Font.BOLD, 24));
            lblX.setForeground(Color.white);

            dataContainer.add(lblX, gbc);

        }

        JPanel btnContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnContainer.setBackground(new Color(150, 90, 255));
        btnContainer.setBorder(new EmptyBorder(20, 20, 20, 20));
        initButtons();
        btnContainer.add(calculate);
        btnContainer.add(clean);

        this.add(title, gbc);

        this.add(dataContainer, gbc);
        this.add(btnContainer, gbc);

    }

    public void initButtons() {
        calculate = new JButton("Calcular recta");
        clean = new JButton("Limpiar campos");

        clean.setBackground(Color.black);
        clean.setForeground(Color.white);
        calculate.setBackground(Color.black);
        calculate.setForeground(Color.white);

        calculate.setFont(new Font("Arial", Font.BOLD, 12));
        clean.setFont(new Font("Arial", Font.BOLD, 12));

        clean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                try {
                    if (txtDistancia == null)
                        throw new Exception("No hay puntos para procesar la distancia");
                    if (txtDistancia.getText().equalsIgnoreCase(""))
                        throw new Exception("Los campos ya estan vacios");
                    else {
                        txtDistancia.setText("");
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
                    if (puntos.size() == 2) {
                        Recta r = new Recta(puntos.get(0), puntos.get(1));
                        txtDistancia.setText("La distancia entre los puntos es: " + r.distancia());
                    } else {
                        throw new Exception("Numero de puntos insuficiente");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    public ArrayList<Punto> getPuntos() {
        return puntos;
    }

    public void setPuntos(ArrayList<Punto> puntos) {
        this.puntos = puntos;
    }
}