package quebrados;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class App extends JFrame{
    JPanel mainContainer;
    JPanel btnContainer;
    JPanel windowContainer;
    JButton btnMainView, btnPointsView, btnLineView;
    MainView mv;
    CreateView cv;
    OperationsView op;

    public App() {

        super("Operaciones con quebrados");
        displayButtons();
        windowContainer = new JPanel();
        windowContainer.setBackground(new Color(130, 70, 240));
        windowContainer.setLayout(new BorderLayout());
        displayButtons();
        mv = new MainView();
        op = new OperationsView();
        cv = new CreateView(op);

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
        btnMainView = new JButton("Página de inicio");
        btnMainView.setSize(200, 40);
        btnMainView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayWindows(mv);
            }
        });
        btnPointsView = new JButton("Crear quebrados");
        btnPointsView.setSize(200, 40);
        btnPointsView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayWindows(cv);
            }
        });
        btnLineView = new JButton("Operaciones de quebrados");
        btnLineView.setSize(200, 40);
        btnLineView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = cv.op;
                displayWindows(op);
            }
        });

        btnContainer = new JPanel();
        btnContainer.setBackground(new Color(0, 132, 255));
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
