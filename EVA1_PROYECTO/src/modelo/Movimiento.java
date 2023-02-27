package modelo;

public class Movimiento {
    private int clave;
    //private Fecha fechaMovimiento;
    private byte tipoMovimiento;
    private double cantidad;
    
    public Movimiento(int clave, byte tipoMovimiento, double cantidad) {
        setClave(clave);
        setCantidad(cantidad);
        setTipoMovimiento(tipoMovimiento);
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
    
}
