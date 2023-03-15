package LibreriaGraficos;
import java.awt.Graphics;
public class Circulo extends Figura{

    @Override
    public void paint(Graphics g) {
        
        super.paint(g);
        int d=getWidth()-1;
        if(getHeight()<getWidth()){
            d=getHeight()-1;            
        }
        g.fillOval(0, 0, d, d);
    }
    
}
