/*
JORGE EDUARDO ESCOBAR BUGARINI - ISC - 21550317
 */
package com.model;

import LibreriaFecha.Fecha;
import java.util.ArrayList;
import java.util.List;

public class Tarjeta {
    private int clave_tarjeta;
    private String numero_tarjeta;
    private Cuenta cuenta;
    private Fecha fecha_anualidad;
    private double anualidad;
    private List<Movimiento> movimientos;
    private double limite_credito;

    public Tarjeta(int clave_tarjeta, String numero_tarjeta, Cuenta cuenta, Fecha fecha_anualidad, double anualidad, List<Movimiento> movimientos, double limite_credito) {
        setClave_tarjeta(clave_tarjeta);
        setNumero_tarjeta(numero_tarjeta);
        setCuenta(cuenta);
        setFecha_anualidad(fecha_anualidad);
        setAnualidad(anualidad);
        setMovimientos(movimientos);
        setLimite_credito(limite_credito);
    }

    public Tarjeta(String numero_tarjeta, Cuenta cuenta, Fecha fecha_anualidad, double anualidad, List<Movimiento> movimientos, double limite_credito) {
        setNumero_tarjeta(numero_tarjeta);
        setCuenta(cuenta);
        setFecha_anualidad(fecha_anualidad);
        setAnualidad(anualidad);
        setMovimientos(movimientos);
        setLimite_credito(limite_credito);
    }

    public int getClave_tarjeta() {
        return clave_tarjeta;
    }

    public void setClave_tarjeta(int clave_tarjeta) {
        this.clave_tarjeta = clave_tarjeta;
    }

    public String getNumero_tarjeta() {
        return numero_tarjeta;
    }

    public void setNumero_tarjeta(String numero_tarjeta) {
        this.numero_tarjeta = numero_tarjeta;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Fecha getFecha_anualidad() {
        return fecha_anualidad;
    }

    public void setFecha_anualidad(Fecha fecha_anualidad) {
        this.fecha_anualidad = fecha_anualidad;
    }

    public double getAnualidad() {
        return anualidad;
    }

    public void setAnualidad(double anualidad) {
        this.anualidad = anualidad;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
       if(movimientos == null){
           this.movimientos  = new ArrayList<>();
       }else{
           this.movimientos = movimientos;
       }
    }

    public double getLimite_credito() {
        return limite_credito;
    }

    public void setLimite_credito(double limite_credito) {
        this.limite_credito = limite_credito;
    }
    
    
    
}
