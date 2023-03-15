package LibreriaGraficos;
import java.awt.Color;
import java.awt.Graphics;
public class Rectangulo extends Figura {
    @Override
    public void paint(Graphics g) {
        
        g.setColor(Color.GREEN);
        super.paint(g);
        g.fillRect(0, 0, getWidth()-1, getHeight()-1);
    }
}
