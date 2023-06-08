package com.controller;

import com.views.*;


public class Controller{

    private ClientesActivos clientesActivos;
    private CuentasCliente cuentasCliente;
    private Login login;
    private Movimientos movimientos;
    private Principal principal;
    private RegistrarCliente registrarCliente;
    private RegistrarTarjeta registrarTarjeta;    
    private TablaTarjetas tablaTarjetas;

    
    public ClientesActivos getClientesActivos() {
        return clientesActivos;
    }
    public void setClientesActivos(ClientesActivos clientesActivos) {
        this.clientesActivos = clientesActivos;
    }
    public CuentasCliente getCuentasCliente() {
        return cuentasCliente;
    }
    public void setCuentasCliente(CuentasCliente cuentasCliente) {
        this.cuentasCliente = cuentasCliente;
    }
    public Login getLogin() {
        return login;
    }
    public void setLogin(Login login) {
        this.login = login;
    }
    public Movimientos getMovimientos() {
        return movimientos;
    }
    public void setMovimientos(Movimientos movimientos) {
        this.movimientos = movimientos;
    }
    public Principal getPrincipal() {
        return principal;
    }
    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }
    public RegistrarCliente getRegistrarCliente() {
        return registrarCliente;
    }
    public void setRegistrarCliente(RegistrarCliente registrarCliente) {
        this.registrarCliente = registrarCliente;
    }
    public RegistrarTarjeta getRegistrarTarjeta() {
        return registrarTarjeta;
    }
    public void setRegistrarTarjeta(RegistrarTarjeta registrarTarjeta) {
        this.registrarTarjeta = registrarTarjeta;
    }
    public TablaTarjetas getTablaTarjetas() {
        return tablaTarjetas;
    }
    public void setTablaTarjetas(TablaTarjetas tablaTarjetas) {
        this.tablaTarjetas = tablaTarjetas;
    }

    



}