package modelo;

public class Credito {
    private String numeroCuenta;
    private String numeroTarjeta;
    private double limiteCredito;
    private Fecha fechaCreacion;
    private Fecha fechaCorte;
    private Fecha fechaPago;
    private double tasaInteresAnual;
    private double anualidad;
    private Fecha fechaAplicacionAnualidad;
    private boolean activa;
    

    public Credito(String numeroCuenta, String numeroTarjeta, double limiteCredito, Fecha fechaCreacion,
            Fecha fechaCorte, Fecha fechaPago, double tasaInteresAnual, double anualidad,
            Fecha fechaAplicacionAnualidad) {
        setNumeroCuenta(numeroCuenta);
        setNumeroTarjeta(numeroTarjeta);
        setLimiteCredito(limiteCredito);
        setFechaCreacion(fechaCreacion);
        setFechaCorte(fechaCorte);
        setFechaPago(fechaPago);
        setTasaInteresAnual(tasaInteresAnual);
        setAnualidad(anualidad);
        setFechaAplicacionAnualidad(fechaAplicacionAnualidad);
        setActiva(true);
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

    public Fecha getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Fecha fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Fecha getFechaCorte() {
        return fechaCorte;
    }


    public void setFechaCorte(Fecha fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public Fecha getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Fecha fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Fecha getFechaAplicacionAnualidad() {
        return fechaAplicacionAnualidad;
    }

    public void setFechaAplicacionAnualidad(Fecha fechaAplicacionAnualidad) {
        this.fechaAplicacionAnualidad = fechaAplicacionAnualidad;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    
}
