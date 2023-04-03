
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Jorge Eduardo Escobar Bugarini
 */
public class MiBoton extends JComponent{
    
    private int estilo = 0;

    /**
     * Get the value of estilo
     *
     * @return the value of estilo
     */
    public int getEstilo() {
        return estilo;
    }

    /**
     * Set the value of estilo
     *
     * @param estilo new value of estilo
     */
    public void setEstilo(int estilo) {
        if(estilo==0 || estilo==1)
            this.estilo = estilo;
        else
            this.estilo=0;
    }

    @Override
    public void paint(Graphics g) {
      int a=getWidth()-1;
      int h = getHeight()-1;
      super.paint(g);
      g.fillRect(0,0,a,h);
      
      java.awt.Color aux = g.getColor();
      if(getEstilo()==0){
          g.setColor(java.awt.Color.black);
          g.drawLine(0,h,a,h);
          g.drawLine(a, h, a, 0);
          g.setColor(java.awt.Color.DARK_GRAY);
          g.drawLine(0, h-1, a-1, h-1);
          g.drawLine(a-1, h-1, a-1, 0);
          g.setColor(java.awt.Color.white);
          g.drawLine(0, 0, 0, h-1);
          g.drawLine(0, 0, a-1, 0);
          g.setColor(java.awt.Color.LIGHT_GRAY);
          g.drawLine(1, 1, 1, h-2);
          g.drawLine(1,1,a-2,1);      
      }
      g.setColor(aux);
    }
    

}
