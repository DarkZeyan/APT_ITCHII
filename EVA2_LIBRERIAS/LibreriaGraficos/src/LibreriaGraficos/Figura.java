package LibreriaGraficos;
import javax.swing.JComponent;
import java.awt.event.MouseMotionListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class Figura extends JComponent implements MouseListener, MouseMotionListener{
    private int xi, yi;
    
    public Figura(){
        setSize(100,100);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    private static Figura seleccionada = null;

    public static Figura getSeleccionada(){
        return seleccionada;
    }

    
    

    @Override
    public void paint(Graphics g) {
        
        super.paint(g);
        if(Figura.getSeleccionada()==this) g.setColor(Color.RED);
        else g.setColor(Color.black);
    }




    @Override
    public void mouseDragged(MouseEvent e) {
       
        int xf,yf,increX,increY;
        xf=e.getX();
        yf=e.getY();
        increX =xf-xi;
        increY =yf-yi;
        setLocation(getX()+increX, getY()+increY);     
    }

    @Override
    public void mouseMoved(MouseEvent e) {
       
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
        xi = e.getX();
        yi = e.getY();
        setSeleccionada(this);
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
        
    }



    public void setXi(int xi) {
        this.xi = xi;
    }



    public void setYi(int yi) {
        this.yi = yi;
    }

    




    public static void setSeleccionada(Figura aSeleccionada) {
        Figura auxi = seleccionada; //seleccionada actual se referencia en auxi
        seleccionada = aSeleccionada; // se asigna seleccionada a la nueva figura
        if(auxi!=null){
            auxi.repaint(); //Llamar a repintar a auxi, regresandole su color
             
        }
        //Cambiar el color de seleccionada.
        seleccionada.repaint();
    }



    public int getXi() {
        return xi;
    }



    public int getYi() {
        return yi;
    }
}
