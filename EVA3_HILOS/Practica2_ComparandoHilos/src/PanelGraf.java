/**
 *
 * @author Jorge Eduardo Escobar Bugarini -  ISC  - 21550317
 */

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
public class PanelGraf extends JPanel implements Runnable{

    Graphics gra;
    Thread t;

    public PanelGraf(){
        super();
        t = new Thread(this);
    }

    public void pintar(){
        int cx =  getWidth()/2;
        int cy = getHeight()/2;

        // Se define el color de las lineas;

        gra.setColor(Color.CYAN);
        int radio =  getWidth()/2;
        //Ciclo que va alterando el valor del angulo de 0 hasta 360 y pinta lineas.
        for(int ang = 0 ; ang<360; ang++){
            int xn = cx+(int)(radio*Math.cos(Math.toRadians(ang)));
            int yn = cy-(int)(radio*Math.sin(Math.toRadians(ang)));
            gra.drawLine(cx,cy,xn,yn);
            //Ciclos vacios para generar retraso.
            for(int i=0; i<100000;i++ ){
                for(int j=0; j<100; j++){

                }
            }

        }
    }

    public void run(){
        pintar();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        setBackground(Color.white);
        gra = getGraphics();

    }
    
}
