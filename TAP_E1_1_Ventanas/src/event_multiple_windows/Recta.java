package event_multiple_windows;
import java.util.ArrayList;
public class Recta {
    private Punto punto1;
    private Punto punto2;
    private ArrayList<Punto> puntos;

    public Recta(Punto punto1, Punto punto2){

    }
    public void setPunto1(Punto punto1) {
        this.punto1 = punto1;
    }
    public void setPunto2(Punto punto2) {
        this.punto2 = punto2;
    }
    public void setPuntos(ArrayList<Punto> puntos) {
        this.puntos = puntos;
    }

    public Punto getPunto1() {
        return punto1;
    }
    public Punto getPunto2() {
        return punto2;
    }
    public ArrayList<Punto> getPuntos() {
        return puntos;
    }
    public double distancia(){
        return 1;
    }
}   

