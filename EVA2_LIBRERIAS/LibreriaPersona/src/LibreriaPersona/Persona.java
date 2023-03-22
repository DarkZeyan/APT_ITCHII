package LibreriaPersona;
public class Persona {
    private String curp;
    private String paterno;
    private String materno;
    private String nombre;
    private String celular;
    //private Fecha fechadNacimiento;
    private String estadoDeNacimiento;
    private char sexo;
    public Persona(){

    }
    public String getCurp() {
        return curp;
    }
    public void setCurp(String curp) {
        this.curp = curp;
    }
    public String getPaterno() {
        return paterno;
    }
    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }
    public String getMaterno() {
        return materno;
    }
    public void setMaterno(String materno) {
        this.materno = materno;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getEstadoDeNacimiento() {
        return estadoDeNacimiento;
    }
    public void setEstadoDeNacimiento(String estadoDeNacimiento) {
        this.estadoDeNacimiento = estadoDeNacimiento;
    }
    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
}
