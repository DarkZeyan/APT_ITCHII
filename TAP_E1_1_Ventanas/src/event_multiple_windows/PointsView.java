package event_multiple_windows;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PointsView extends JPanel {
    JLabel title;
    JButton create, clean, back;
    public ArrayList<Punto> puntos;
    JLabel pointNumberLbl;
    JLabel lblX, lblY;
    JTextField txtX, txtY;
    byte pointCounter = 0;
    LineView lv;

    public PointsView(LineView lv) {
        this.lv = lv;
        puntos = new ArrayList<Punto>();
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(140, 60, 255));
        this.setBorder(new EmptyBorder(200, 300, 300, 300));
        initComponents();

    }

    private void initComponents() {
        // Label del titulo
        title = new JLabel("Crear puntos");
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setForeground(Color.white);
        title.setOpaque(true);
        title.setBackground(new Color(150, 90, 255));
        title.setBorder(BorderFactory.createEmptyBorder(20, 150, 20, 150));

        //
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

        dgbc.insets = new Insets(10, 0, 10, 0);
        // fill the container

        pointNumberLbl = new JLabel("Punto " + (pointCounter + 1));
        pointNumberLbl.setFont(new Font("Arial", Font.BOLD, 24));
        pointNumberLbl.setForeground(Color.white);
        dgbc.weightx = 1.;
        dgbc.fill = GridBagConstraints.HORIZONTAL;
        dgbc.gridwidth = GridBagConstraints.REMAINDER;

        lblX = new JLabel("Coordenada X");
        lblX.setFont(new Font("Arial", Font.BOLD, 24));
        lblX.setForeground(Color.white);

        lblY = new JLabel("Coordenada Y");
        lblY.setFont(new Font("Arial", Font.BOLD, 24));
        lblY.setForeground(Color.white);

        txtX = new JTextField();
        txtY = new JTextField();
        txtX.setSize(300, 50);
        txtY.setSize(300, 50);

        dataContainer.add(pointNumberLbl, dgbc);

        dataContainer.add(lblX, dgbc);
        dataContainer.add(txtX, dgbc);

        dataContainer.add(lblY, dgbc);
        dataContainer.add(txtY, dgbc);

        JPanel btnContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnContainer.setBackground(new Color(150, 90, 255));
        btnContainer.setBorder(new EmptyBorder(20, 20, 20, 20));
        initButtons(this);
        btnContainer.add(create);
        btnContainer.add(clean);
        btnContainer.add(back);

        this.add(title, gbc);

        this.add(dataContainer, gbc);
        this.add(btnContainer, gbc);
    }

    private void initButtons(PointsView pv) {
        create = new JButton("Crear punto");
        clean = new JButton("Limpiar campos");
        back = new JButton("Eliminar puntos");

        clean.setBackground(Color.black);
        clean.setForeground(Color.white);
        create.setBackground(Color.black);
        create.setForeground(Color.white);
        back.setBackground(Color.black);
        back.setForeground(Color.white);

        back.setFont(new Font("Arial", Font.BOLD, 12));
        create.setFont(new Font("Arial", Font.BOLD, 12));
        clean.setFont(new Font("Arial", Font.BOLD, 12));

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {

                try {
                    if (txtX.getText().equals("") || txtY.getText().equals(""))
                        throw new Exception("Uno de los campos esta vacio");
                    if (puntos.size() != 2) {
                        puntos.add(new Punto(Integer.parseInt(txtX.getText()), Integer.parseInt(txtY.getText())));
                        JOptionPane.showMessageDialog(null, "Punto creado exitosamente", "Exito",
                                JOptionPane.INFORMATION_MESSAGE);

                        if (puntos.size() < 2) {
                            pointNumberLbl.setText("Punto " + (puntos.size() + 1));
                        } else {
                            pointNumberLbl.setText("Punto " + puntos.size());
                            lv = new LineView(pv);

                        }
                    } else {

                        throw new Exception("Máximo de puntos alcanzado");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "La entrada de algun campo no es un numero", "error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        clean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                try {
                    if (txtX.getText().equalsIgnoreCase("") && txtY.getText().equalsIgnoreCase(""))
                        throw new Exception("Los campos ya estan vacios");
                    else {
                        txtX.setText("");
                        txtY.setText("");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                try {
                    if (puntos.size() == 0)
                        throw new Exception("No hay puntos existentes");
                    else {
                        puntos.clear();
                        pointNumberLbl.setText("Punto " + (puntos.size() + 1));
                        lv = new LineView(pv);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

}