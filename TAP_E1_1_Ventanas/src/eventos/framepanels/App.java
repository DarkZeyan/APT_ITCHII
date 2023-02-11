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
    
    public void initButtons(){
        btnPage1 = new JButton("Pagina 1");
        btnPage1.setSize(200,40);
        btnPage1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
        });
    }
}
