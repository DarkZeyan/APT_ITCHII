
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JLabel;


/**
 *
 * @author Jorge Eduardo Escobar Bugarini -  ISC  - 21550317
 */
public class Liga extends JLabel implements MouseListener{

    private boolean subraya=false;
    private Color previousColor;
    
        private static Color colorSubrayado = Color.magenta;

    public static Color getColorSubrayado() {
        return colorSubrayado;
    }

    public static void setColorSubrayado(Color colorSubrayado) {
        Liga.colorSubrayado = colorSubrayado;
    }

    private String comando = "calc.exe";

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    
    
    

    public Liga(){
        addMouseListener(this);
    }
    @Override

    public void paint(Graphics g) {
    
        super.paint(g);
        if(subraya){
            g.drawLine(2,getHeight()-2,getWidth()-2, getHeight()-2);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        try{
                Runtime runtime =  Runtime.getRuntime();
                runtime.exec(getComando());
      
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        previousColor = getForeground();
        setForeground(getColorSubrayado());
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        subraya =  true;
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setForeground(previousColor);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        subraya=false;
        repaint();
    }
    
}
