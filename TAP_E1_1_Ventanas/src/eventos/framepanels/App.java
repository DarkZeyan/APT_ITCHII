package eventos.framepanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class App  extends JFrame{
    
    JPanel mainContainer;
    JPanel btnContainer;
    JPanel windowContainer;
    JButton btnPage1, btnPage2;

    public App(){
        
    }
    
    public void displayButtons(){
        btnPage1 = new JButton("Pagina 1");
        btnPage1.setSize(200,40);
        btnPage1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                displayWindows(new Page1());
            }
        });
        btnPage2 = new JButton("Pagina 2");
        btnPage2.setSize(200,40);
        btnPage2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                displayWindows(new Page2());
            }
        });


        btnContainer = new JPanel();
        btnContainer.setBackground(new Color(30,80,240));
        btnContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnContainer.add(btnPage1);

    }
    private void displayWindows(JPanel window){
        window.setSize(720,480);
        window.setLocation(0,0);

        windowContainer.removeAll();
        windowContainer.add(window,BorderLayout.CENTER);
        windowContainer.revalidate();
        windowContainer.repaint();
    }
}
