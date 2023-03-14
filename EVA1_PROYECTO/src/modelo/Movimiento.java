package modelo;

public class Movimiento {
    private int clave;
    private Fecha fechaMovimiento;
    private byte tipoMovimiento;
    private double cantidad;
    
    public Movimiento(int clave, byte tipoMovimiento, double cantidad,Fecha fechaMovimiento) {
        setClave(clave);
        setCantidad(cantidad);
        setTipoMovimiento(tipoMovimiento);
        setFechaMovimiento(fechaMovimiento);
    }
    public int getClave() {
        return clave;
    }
    public void setClave(int clave) {
        this.clave = clave;
    }
    public byte getTipoMovimiento() {
        return tipoMovimiento;
    }
    public void setTipoMovimiento(byte tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }
    public double getCantidad() {
        return cantidad;
    }
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    public Fecha getFechaMovimiento() {
        return fechaMovimiento;
    }
    public void setFechaMovimiento(Fecha fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }   
    public String tipoString(){
        switch(tipoMovimiento){
            case 1:return "Ingreso";
            case 2: return "Retiro";
            case 3: return "Cargo";
            default: return "Indefinido";
        }
    }
    
}
