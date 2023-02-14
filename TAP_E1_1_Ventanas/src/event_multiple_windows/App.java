package event_multiple_windows;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame{
    
    JPanel mainContainer;
    JPanel btnContainer;
    JPanel windowContainer;
    JButton btnMainView, btnPointsView, btnLineView;

    
    public App(){
        super("Recta entre dos puntos");
        displayButtons();
        windowContainer = new JPanel();
        windowContainer.setBackground(new Color(130,70,240));
        windowContainer.setLayout(new BorderLayout());
        displayButtons();
        displayWindows(new MainView());
        mainContainer= new JPanel();
        mainContainer.setBackground(Color.white);
        mainContainer.setLayout(new BorderLayout());
        mainContainer.add(btnContainer,BorderLayout.NORTH);
        mainContainer.add(windowContainer,BorderLayout.CENTER);

        this.setLayout(new BorderLayout());
        this.add(mainContainer, BorderLayout.CENTER);
        this.setBounds(100,100,720,480);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    private void displayButtons(){
        btnMainView = new JButton("Pagina 1");
        btnMainView.setSize(200,40);
        btnMainView.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                displayWindows(new MainView());
            }
        });
        btnPointsView = new JButton("Pagina 2");
        btnPointsView.setSize(200,40);
        btnPointsView.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                displayWindows(new PointsView());
            }
        });
        btnLineView = new JButton("Crear Recta");
        btnLineView.setSize(200,40);
        btnLineView.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                displayWindows(new PointsView());
            }
        });


        btnContainer = new JPanel();
        btnContainer.setBackground(new Color(30,80,240));
        btnContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnContainer.add(btnMainView);
        btnContainer.add(btnPointsView);
        btnContainer.add(btnLineView);

    }
    
    private void displayWindows(JPanel window){
        window.setSize(720,480);
        window.setLocation(0,0);

        windowContainer.removeAll();
        windowContainer.add(window,BorderLayout.CENTER);
        windowContainer.revalidate();
        windowContainer.repaint();
    }
    public static void main(String[] args) {
        new App();
    }
}
class MainView extends JPanel{
    private JLabel lblTitle;

    public MainView(){
        lblTitle = new JLabel("Aplicacion para calcular la distancia de una recta");
        lblTitle.setFont(new Font("Serif",Font.BOLD,36));
        lblTitle.setForeground(Color.white);
        lblTitle.setOpaque(true);
        lblTitle.setBackground(new Color(150, 90, 255));
        //Trying to vertically align.
        JPanel gb = new JPanel();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weighty = 1;

        this.add(lblTitle,BorderLayout.CENTER);
        this.setBackground(new Color(140, 60, 255));
    }

}
class PointsView extends JPanel{
    public PointsView(){

    }
}
class LineView extends JPanel{
    public LineView(){

    }
}
