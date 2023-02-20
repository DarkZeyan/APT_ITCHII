package event_multiple_windows;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class App extends JFrame {

    JPanel mainContainer;
    JPanel btnContainer;
    JPanel windowContainer;
    JButton btnMainView, btnPointsView, btnLineView;
    MainView mv;
    PointsView pv;
    LineView lv;

    public App() {

        super("Recta entre dos puntos");
        displayButtons();
        windowContainer = new JPanel();
        windowContainer.setBackground(new Color(130, 70, 240));
        windowContainer.setLayout(new BorderLayout());
        displayButtons();
        mv = new MainView();
        lv = new LineView();
        pv = new PointsView(lv);

        displayWindows(mv);
        mainContainer = new JPanel();
        mainContainer.setBackground(Color.white);
        mainContainer.setLayout(new BorderLayout());
        mainContainer.add(btnContainer, BorderLayout.NORTH);
        mainContainer.add(windowContainer, BorderLayout.CENTER);

        this.setLayout(new BorderLayout());
        this.add(mainContainer, BorderLayout.CENTER);
        this.setSize(900, 800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void displayButtons() {
        btnMainView = new JButton("Menú de inicio");
        btnMainView.setSize(200, 40);
        btnMainView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayWindows(mv);
            }
        });
        btnPointsView = new JButton("Crear puntos");
        btnPointsView.setSize(200, 40);
        btnPointsView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayWindows(pv);
            }
        });
        btnLineView = new JButton("Crear Recta");
        btnLineView.setSize(200, 40);
        btnLineView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lv = pv.lv;
                displayWindows(lv);
            }
        });

        btnContainer = new JPanel();
        btnContainer.setBackground(new Color(40, 200, 255));
        btnContainer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btnContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
        setButtonsStyle();
        btnContainer.add(btnMainView);
        btnContainer.add(btnPointsView);
        btnContainer.add(btnLineView);

    }

    private void setButtonsStyle() {
        btnMainView.setBackground(Color.black);
        btnMainView.setForeground(Color.white);
        btnPointsView.setBackground(Color.black);
        btnPointsView.setForeground(Color.white);
        btnLineView.setBackground(Color.black);
        btnLineView.setForeground(Color.white);

        btnLineView.setFont(new Font("Arial", Font.BOLD, 12));
        btnPointsView.setFont(new Font("Arial", Font.BOLD, 12));
        btnMainView.setFont(new Font("Arial", Font.BOLD, 12));
    }

    private void displayWindows(JPanel window) {
        window.setSize(900, 600);
        window.setLocation(0, 0);

        windowContainer.removeAll();
        windowContainer.add(window, BorderLayout.CENTER);
        windowContainer.revalidate();
        windowContainer.repaint();
    }

    public static void main(String[] args) {
        new App();
    }
}

class MainView extends JPanel {
    private JLabel lblTitle;

    public MainView() {
        lblTitle = new JLabel("<html>Aplicación para calcular <br> la distancia de una recta</html>");

        lblTitle.setFont(new Font("Arial", Font.BOLD, 36));
        lblTitle.setForeground(Color.white);
        lblTitle.setOpaque(true);
        lblTitle.setBackground(new Color(150, 90, 255));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(90, 150, 90, 150));
        lblTitle.setLocation(0, 0);
        this.add(lblTitle);
        this.setBorder(BorderFactory.createEmptyBorder(90, 150, 90, 150));
        this.setBackground(new Color(140, 60, 255));
    }

}

class PointsView extends JPanel {
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

class LineView extends JPanel {
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
