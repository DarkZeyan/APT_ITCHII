/*
JORGE EDUARDO ESCOBAR BUGARINI - ISC - 21550317
 */
package com.model;

import LibreriaFecha.Fecha;

public class Movimiento {
    private Tarjeta tarjeta;
    private Fecha fechaMovimiento;
    private byte tipoMovimiento;
    private double cantidad;
    private int clave;

    public Movimiento(byte tipoMovimiento, double cantidad, Fecha fechaMovimiento) {
        setCantidad(cantidad);
        setTipoMovimiento(tipoMovimiento);
        setFechaMovimiento(fechaMovimiento);
    }

    public Movimiento(Tarjeta tarjeta, Fecha fechaMovimiento, byte tipoMovimiento, double cantidad,
            int clave) {
        setCantidad(cantidad);
        setTipoMovimiento(tipoMovimiento);
        setFechaMovimiento(fechaMovimiento);
        setTarjeta(tarjeta);

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
}
