package event_multiple_windows;
import java.util.ArrayList;
public class Recta {
    private Punto punto1;
    private Punto punto2;

    public Recta(Punto punto1, Punto punto2){
        setPunto1(punto1);
        setPunto2(punto2);
    }
    public void setPunto1(Punto punto1) {
        this.punto1 = punto1;
    }
    public void setPunto2(Punto punto2) {
        this.punto2 = punto2;
    }
    public Punto getPunto1() {
        return punto1;
    }
    public Punto getPunto2() {
        return punto2;
    }
    public double distancia(){
        return Math.sqrt(Math.pow((punto2.getX()-punto1.getX()),2)+Math.pow((punto2.getY()-punto1.getY()),2));
    }
}   

