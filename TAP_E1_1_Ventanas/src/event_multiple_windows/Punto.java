package event_multiple_windows;

public class Punto {
    private int x;
    private int y;

    public Punto(){
        this.x = 0;
        this.y = 0;
    }

    public Punto(int x, int y){
        setX(x);
        setY(y);
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    
}
