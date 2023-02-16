package event_multiple_windows;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class App extends JFrame{
    
    JPanel mainContainer;
    JPanel btnContainer;
    JPanel windowContainer;
    JButton btnMainView, btnPointsView, btnLineView;
    MainView mv;
    PointsView pv;
    LineView lv;
    public App(){
        

        
        super("Recta entre dos puntos");
        displayButtons();
        windowContainer = new JPanel();
        windowContainer.setBackground(new Color(130,70,240));
        windowContainer.setLayout(new BorderLayout());
        displayButtons();
        mv = new MainView();
        pv = new PointsView();
        lv = new LineView();
        displayWindows(mv);
        mainContainer= new JPanel();
        mainContainer.setBackground(Color.white);
        mainContainer.setLayout(new BorderLayout());
        mainContainer.add(btnContainer,BorderLayout.NORTH);
        mainContainer.add(windowContainer,BorderLayout.CENTER);

        this.setLayout(new BorderLayout());
        this.add(mainContainer, BorderLayout.CENTER);
        this.setSize(900,750);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    private void displayButtons(){
        btnMainView = new JButton("Menú de inicio");
        btnMainView.setSize(200,40);
        btnMainView.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                displayWindows(mv);
            }
        });
        btnPointsView = new JButton("Crear puntos");
        btnPointsView.setSize(200,40);
        btnPointsView.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                displayWindows(pv);
            }
        });
        btnLineView = new JButton("Crear Recta");
        btnLineView.setSize(200,40);
        btnLineView.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                displayWindows(lv);
            }
        });


        btnContainer = new JPanel();
        btnContainer.setBackground(new Color(40,200,255));
        btnContainer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btnContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
        setButtonsStyle();
        btnContainer.add(btnMainView);
        btnContainer.add(btnPointsView);
        btnContainer.add(btnLineView);

    }
    private void setButtonsStyle(){
         btnMainView.setBackground(Color.black);
         btnMainView.setForeground(Color.white);
         btnPointsView.setBackground(Color.black);
         btnPointsView.setForeground(Color.white);
         btnLineView.setBackground(Color.black);
         btnLineView.setForeground(Color.white);

         btnLineView.setFont(new Font("Arial",Font.BOLD,12));
         btnPointsView.setFont(new Font("Arial",Font.BOLD,12));
         btnMainView.setFont(new Font("Arial",Font.BOLD,12));
    }    
    private void displayWindows(JPanel window){
        window.setSize(900,600);
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
        lblTitle = new JLabel("<html>Aplicación para calcular <br> la distancia de una recta</html>");
        
        lblTitle.setFont(new Font("Arial",Font.BOLD,36));
        lblTitle.setForeground(Color.white);
        lblTitle.setOpaque(true);
        lblTitle.setBackground(new Color(150, 90, 255));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(90,150,90,150));
        lblTitle.setLocation(0, 0);
        this.add(lblTitle);
        this.setBorder(BorderFactory.createEmptyBorder(90   ,150,90,150));
        this.setBackground(new Color(140, 60, 255));
    }


}
class PointsView extends JPanel{
    JLabel title;
    JButton create, clean, back;
    public ArrayList<Punto> puntos;
    JLabel pointNumberLbl;
    JLabel lblX,lblY;
    JTextField txtX,txtY;
    public byte pointCounter=0;

    public PointsView(){
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(140, 60, 255));
        this.setBorder(new EmptyBorder(200, 300, 300, 300));
        initComponents();
        
    }
    private void initComponents(){
        //Label del titulo
        title = new JLabel("Crear puntos");
        title.setFont(new Font("Arial",Font.BOLD,36));
        title.setForeground(Color.white);
        title.setOpaque(true);
        title.setBackground(new Color(150, 90, 255));
        title.setBorder(BorderFactory.createEmptyBorder(20,150,20,150));

        //
        boolean isPointCreated=false;
        byte pointsCounter=0;
        JPanel dataContainer = new JPanel();
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10,10,10,10);

        dataContainer.setForeground(Color.white);
        dataContainer.setOpaque(true);
        dataContainer.setBackground(new Color(190, 90, 255));
        dataContainer.setBorder(BorderFactory.createEmptyBorder(100,100,150,100));
        GridBagConstraints dgbc = new GridBagConstraints();
        dataContainer.setLayout(new GridBagLayout());
        
        
        dgbc.insets = new Insets(10,0,10,0);
        //fill the container
        
        pointNumberLbl = new JLabel("Punto "+(pointsCounter+1));
        pointNumberLbl.setFont(new Font("Arial",Font.BOLD,24));
        pointNumberLbl.setForeground(Color.white);
        dgbc.weightx=1.;
        dgbc.fill = GridBagConstraints.HORIZONTAL;
        dgbc.gridwidth = GridBagConstraints.REMAINDER;
        
        lblX = new JLabel("Coordenada X");
        lblX.setFont(new Font("Arial",Font.BOLD,24));
        lblX.setForeground(Color.white);
        
        lblY = new JLabel("Coordenada Y");
        lblY.setFont(new Font("Arial",Font.BOLD,24));
        lblY.setForeground(Color.white);

        txtX = new JTextField();
        txtY = new JTextField();
        txtX.setSize(300, 50);
        txtY.setSize(300,50);
        
        dataContainer.add(pointNumberLbl,dgbc);

        dataContainer.add(lblX,dgbc);
        dataContainer.add(txtX,dgbc);
        
        dataContainer.add(lblY,dgbc);
        dataContainer.add(txtY,dgbc);
        
        


        this.add(title,gbc);
        
        this.add(dataContainer,gbc);
    }

    
}
class LineView extends JPanel{
    public LineView(){
        this.setBackground(new Color(140, 60, 255));   
    }
}
