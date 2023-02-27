package modelo;

public class Credito {
    private String numeroCuenta;
    private String numeroTarjeta;
    private double limiteCredito;
    //private Fecha fechaCreacion;
    //private Fecha fechaCorte;
    //private Fecha fechaPago;
    private double tasaInteresAnual;
    private double anualidad;
    //private Fecha fechaAplicacionAnualidad;

    

    public boolean isActive(){
        boolean activa=false;
        return activa;
    }



    public Credito(String numeroCuenta, String numeroTarjeta, double limiteCredito, double tasaInteresAnual,
            double anualidad) {
        setNumeroCuenta(numeroCuenta);
        setNumeroTarjeta(numeroTarjeta);
        setLimiteCredito(limiteCredito);
        setTasaInteresAnual(tasaInteresAnual);
        setAnualidad(anualidad);
    }



    public String getNumeroCuenta() {
        return numeroCuenta;
    }



    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }



    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }



    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }



    public double getLimiteCredito() {
        return limiteCredito;
    }



    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }



    public double getTasaInteresAnual() {
        return tasaInteresAnual;
    }



    public void setTasaInteresAnual(double tasaInteresAnual) {
        this.tasaInteresAnual = tasaInteresAnual;
    }



    public double getAnualidad() {
        return anualidad;
    }



    public void setAnualidad(double anualidad) {
        this.anualidad = anualidad;
    }
    
}
