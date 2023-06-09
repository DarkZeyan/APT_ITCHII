/*
JORGE EDUARDO ESCOBAR BUGARINI - ISC - 21550317
 */
package com.model;

import LibreriaFecha.Fecha;

public class Movimiento {
    private Tarjeta tarjeta;
    private int clave_tarjeta;
    private Fecha fechaMovimiento;
    private int tipoMovimiento;
    private double cantidad;
    private int clave;

    public Movimiento(int tipoMovimiento, double cantidad, Fecha fechaMovimiento) {
        setCantidad(cantidad);
        setTipoMovimiento(tipoMovimiento);
        setFechaMovimiento(fechaMovimiento);
    }


    public Movimiento(Tarjeta tarjeta, Fecha fechaMovimiento, int tipoMovimiento, double cantidad,
            int clave) {
        setCantidad(cantidad);
        setTipoMovimiento(tipoMovimiento);
        setFechaMovimiento(fechaMovimiento);
        setTarjeta(tarjeta);

    }

    

    public Movimiento(int clave_tarjeta, Fecha fechaMovimiento, int tipoMovimiento, double cantidad,
            int clave) {
        setCantidad(cantidad);
        setClave_tarjeta(clave_tarjeta);
        setTipoMovimiento(tipoMovimiento);
        setFechaMovimiento(fechaMovimiento);
    }


    public int getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(int tipoMovimiento) {
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

    public String tipoString() {
        return switch (tipoMovimiento) {
            case 1 -> "Ingreso";
            case 2 -> "Retiro";
            case 3 -> "Cargo";
            default -> "Indefinido";
        };
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }


    public int getClave_tarjeta() {
        return clave_tarjeta;
    }


    public void setClave_tarjeta(int clave_tarjeta) {
        this.clave_tarjeta = clave_tarjeta;
    }
}
