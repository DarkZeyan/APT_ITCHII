package ejemplo_jtable;

public class Persona {
    private String curp;
    private String nombre;
    private String apellido;
    private String celular;
    private int edad;
    private boolean soltero;

    public Persona(String curp, String nombre, String apellido, String celular, int edad, boolean soltero) {
        this.curp = curp;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.edad = edad;
        this.soltero = soltero;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isSoltero() {
        return soltero;
    }

    public void setSoltero(boolean soltero) {
        this.soltero = soltero;
    }

}
