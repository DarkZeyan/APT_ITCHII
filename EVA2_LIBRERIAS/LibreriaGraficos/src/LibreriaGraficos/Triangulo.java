    package LibreriaGraficos;
import java.awt.Graphics;

public class Triangulo extends Figura{

    @Override
    public void paint(Graphics g) {
        
        super.paint(g);

        int xPoints[] = {0,0,getWidth()-1};
        int yPoints[] = {0,getHeight()-1,getHeight()-1};

        g.fillPolygon(xPoints, yPoints, 3);
    }
    
}
