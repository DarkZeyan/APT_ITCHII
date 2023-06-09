/*
JORGE EDUARDO ESCOBAR BUGARINI - ISC - 21550317
 */
package com.model;

import LibreriaFecha.Fecha;
import java.util.ArrayList;
import java.util.List;

public class Cuenta {
   private Cliente cliente;
   private int c_cuenta;
   private String numerocuenta;
   private double tasainteres;
   private Fecha fechaPago;
   private Fecha fechaCorte;
   private Fecha fechaCreacion;

    public Cuenta(Cliente cliente, int c_cuenta, String numerocuenta, double tasainteres, Fecha fechaPago, Fecha fechaCorte, Fecha fechaCreacion) {
        setCliente(cliente);
        setC_cuenta(c_cuenta);
        setNumerocuenta(numerocuenta);
        setTasainteres(tasainteres);
        setFechaPago(fechaPago);
        setFechaCorte(fechaCorte);
        setFechaCreacion(fechaCreacion);
    }
    public Cuenta(int c_cuenta, String numerocuenta, double tasainteres, Fecha fechaPago, Fecha fechaCorte, Fecha fechaCreacion) {
        setNumerocuenta(numerocuenta);
        setTasainteres(tasainteres);
        setFechaPago(fechaPago);
        setFechaCorte(fechaCorte);
        setFechaCreacion(fechaCreacion);
    }
    public Cuenta(Cliente cliente, String numerocuenta, double tasainteres, Fecha fechaPago, Fecha fechaCorte, Fecha fechaCreacion) {
        setCliente(cliente);
        setC_cuenta(c_cuenta);
        setNumerocuenta(numerocuenta);
        setTasainteres(tasainteres);
        setFechaPago(fechaPago);
        setFechaCorte(fechaCorte);
        setFechaCreacion(fechaCreacion);
    }
    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getC_cuenta() {
        return c_cuenta;
    }

    public void setC_cuenta(int c_cuenta) {
        this.c_cuenta = c_cuenta;
    }

    public String getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(String numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public double getTasainteres() {
        return tasainteres;
    }

    public void setTasainteres(double tasainteres) {
        this.tasainteres = tasainteres;
    }

    public Fecha getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Fecha fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Fecha getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(Fecha fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public Fecha getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Fecha fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
