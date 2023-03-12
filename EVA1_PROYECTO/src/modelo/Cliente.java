package modelo;
import java.util.ArrayList;
public class Cliente {
    private String curp;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private Fecha fechaNacimiento;
    private ArrayList<Tarjeta> tarjetasCliente;

    public Cliente(String curp, String nombre, String apPaterno, String apMaterno, Fecha fechaNacimiento) {
        setCurp(curp);
        setNombre(nombre);
        setApPaterno(apPaterno);
        setApMaterno(apMaterno);
        setFechaNacimiento(fechaNacimiento);
        setTarjetasCliente();
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
    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public ArrayList<Tarjeta> getTarjetasCliente() {
        return tarjetasCliente;
    }
    public void setTarjetasCliente(ArrayList<Tarjeta> tarjetasCliente) {
        this.tarjetasCliente = tarjetasCliente;
    }
    public void setTarjetasCliente(){
        tarjetasCliente = new ArrayList<Tarjeta>();
    }
    public String getCurp() {
        return curp;
    }
}
