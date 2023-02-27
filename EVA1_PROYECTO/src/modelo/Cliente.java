package modelo;

public class Cliente {
    private String curp;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    //private Fecha fechaNacimiento;
    //private List<Credito> cuentasCredito;

    

    public String getCurp() {
        return curp;
    }
    public Cliente(String curp, String nombre, String apPaterno, String apMaterno) {
        setCurp(curp);
        setNombre(nombre);
        setApPaterno(apPaterno);
        setApMaterno(apMaterno);
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
    public String getApPaterno() {
        return apPaterno;
    }
    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }
    public String getApMaterno() {
        return apMaterno;
    }
    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }
    
}
