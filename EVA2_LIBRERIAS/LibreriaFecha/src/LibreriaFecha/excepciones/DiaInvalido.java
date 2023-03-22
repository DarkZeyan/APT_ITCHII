package LibreriaFecha.excepciones;

public class DiaInvalido extends Exception {
    public DiaInvalido(){
         super("Fecha imposible, dia inexistente, mes inexistente o año negativo");
    }
}
