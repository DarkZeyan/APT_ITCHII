package quebrados;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CreateView extends JPanel{

    JLabel title;
    JButton create, clean, back;
    public ArrayList<Quebrado> quebrados;
    JLabel numQuebradoLbl;
    JLabel lblNumerador, lblDenominador;
    JTextField txtNumerador, txtDenominador;
    OperationsView op;

    public CreateView(OperationsView op){
        this.op = op;
        quebrados = new ArrayList<Quebrado>();
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(41, 186, 230));
        initComponents();
    }
    private void initComponents() {
        // Label del titulo
        title = new JLabel("Crear quebrados");
        title.setFont(new Font("Tahoma", Font.BOLD, 36));
        title.setForeground(Color.white);
        title.setOpaque(true);
        title.setBackground(new Color(107, 191, 255));
        title.setBorder(BorderFactory.createEmptyBorder(20, 150, 20, 150));

        //
        JPanel dataContainer = new JPanel();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        dataContainer.setForeground(Color.white);
        dataContainer.setOpaque(true);
        dataContainer.setBackground(new Color(0, 98, 128));
        dataContainer.setBorder(BorderFactory.createEmptyBorder(100, 100, 150, 100));
        GridBagConstraints dgbc = new GridBagConstraints();
        dataContainer.setLayout(new GridBagLayout());

        dgbc.insets = new Insets(10, 0, 10, 0);
        // fill the container

        numQuebradoLbl = new JLabel("Quebrado No. " + (quebrados.size() + 1), SwingConstants.CENTER);
        numQuebradoLbl.setFont(new Font("Tahoma", Font.BOLD, 24));
        numQuebradoLbl.setForeground(Color.white);
        dgbc.weightx = 1.;
        dgbc.fill = GridBagConstraints.HORIZONTAL;
        dgbc.gridwidth = GridBagConstraints.REMAINDER;

        lblNumerador = new JLabel("Numerador del quebrado No. "+ (quebrados.size() + 1));
        lblNumerador.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNumerador.setForeground(Color.white);

        lblDenominador = new JLabel("Denominador del quebrado No. "+ (quebrados.size() + 1));
        lblDenominador.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblDenominador.setForeground(Color.white);

        txtNumerador = new JTextField();
        txtDenominador = new JTextField();
        txtNumerador.setSize(300, 50);
        txtDenominador.setSize(300, 50);

        dataContainer.add(numQuebradoLbl, dgbc);

        dataContainer.add(lblNumerador, dgbc);
        dataContainer.add(txtNumerador, dgbc);

        dataContainer.add(lblDenominador, dgbc);
        dataContainer.add(txtDenominador, dgbc);

        JPanel btnContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnContainer.setBackground(new Color(107, 191, 255));
        btnContainer.setBorder(new EmptyBorder(20, 20, 20, 20));
        initButtons(this);
        btnContainer.add(create);
        btnContainer.add(clean);
        btnContainer.add(back);

        this.add(title, gbc);

        this.add(dataContainer, gbc);
        this.add(btnContainer, gbc);
    }

    private void initButtons(CreateView cv) {
        create = new JButton("Crear nuevo quebrado");
        clean = new JButton("Limpiar campos");
        back = new JButton("Eliminar todos los quebrados");

        clean.setBackground(Color.black);
        clean.setForeground(Color.white);
        create.setBackground(Color.black);
        create.setForeground(Color.white);
        back.setBackground(Color.black);
        back.setForeground(Color.white);

        back.setFont(new Font("Tahoma", Font.BOLD, 12));
        create.setFont(new Font("Tahoma", Font.BOLD, 12));
        clean.setFont(new Font("Tahoma", Font.BOLD, 12));

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {

                try {
                    if (txtNumerador.getText().equals("") || txtDenominador.getText().equals(""))
                        throw new Exception("Uno de los campos esta vacio");
                    if (quebrados.size() != 2) {
                        quebrados.add(new Quebrado(Integer.parseInt(txtNumerador.getText()), Integer.parseInt(txtDenominador.getText())));
                        JOptionPane.showMessageDialog(null, "Quebrado creado exitosamente", "Exito",
                                JOptionPane.INFORMATION_MESSAGE);

                        if (quebrados.size() < 2) {
                            numQuebradoLbl.setText("Quebrado No. " + (quebrados.size() + 1));
                        } else {
                            numQuebradoLbl.setText("Quebrado No. " + quebrados.size());
                            op = new OperationsView(cv);

                        }
                    } else {

                        throw new Exception("Máximo de quebrados alcanzado");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "La entrada de algun campo no es un numero entero", "error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        clean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                try {
                    if (txtNumerador.getText().equalsIgnoreCase("") && txtDenominador.getText().equalsIgnoreCase(""))
                        throw new Exception("Los campos ya estan vacios");
                    else {
                        txtNumerador.setText("");
                        txtDenominador.setText("");
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
                    if (quebrados.size() == 0)
                        throw new Exception("No hay quebrados existentes");
                    else {
                        quebrados.clear();
                        numQuebradoLbl.setText("Quebrado No.  " + (quebrados.size() + 1));
                        op = new OperationsView(cv);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

}