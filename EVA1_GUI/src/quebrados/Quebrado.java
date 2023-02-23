package quebrados;

public class Quebrado {
    private int numerador;
    private int denominador;

    public Quebrado(int numerador,int denominador){
        setNumerador(numerador);
        setDenominador(denominador);
    }

    public int getDenominador() {
        return denominador;
    }
    public int getNumerador() {
        return numerador;
    }
    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }
    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }
    public String toString(){
        return ""+getNumerador()+"/"+getDenominador();
    }
}
