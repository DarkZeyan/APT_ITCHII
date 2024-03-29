package com.controller;

import com.model.*;
import com.views.*;
import javax.swing.JPanel;

public class Controller {

    private ClientesActivos clientesActivos;
    private ClientesInactivos clientesInactivos;
    private CuentasCliente cuentasCliente;
    private Login login;
    private Movimientos movimientos;
    private Principal principal;
    private RegistrarCliente registrarCliente;
    private RegistrarCuenta registrarCuenta;
    private RegistrarTarjeta registrarTarjeta;
    private TablaTarjetas tablaTarjetas;
    private Screen pantalla;
    private LogicaCliente logicaCliente;
    private LogicaTarjeta logicaTarjeta;
    private LogicaMovimiento logicaMovimiento;
    private LogicaCuenta logicaCuenta;
    
    public Controller(ClientesActivos clientesActivos, ClientesInactivos clientesInactivos, CuentasCliente cuentasCliente, Login login,
            Movimientos movimientos, Principal principal, RegistrarCliente registrarCliente,
            RegistrarTarjeta registrarTarjeta, TablaTarjetas tablaTarjetas, Screen pantalla) {
        
        this.pantalla = pantalla;
        this.clientesInactivos=clientesInactivos;
        this.clientesActivos = clientesActivos;
        this.cuentasCliente = cuentasCliente;
        this.login = login;
        this.movimientos = movimientos;
        this.principal = principal;
        this.registrarCliente = registrarCliente;
        this.registrarTarjeta = registrarTarjeta;
        this.tablaTarjetas = tablaTarjetas;
    }
    
    public Controller(ClientesActivos clientesActivos, ClientesInactivos clientesInactivos,
            CuentasCliente cuentasCliente, Login login, Movimientos movimientos, Principal principal,
            RegistrarCliente registrarCliente, RegistrarTarjeta registrarTarjeta, TablaTarjetas tablaTarjetas,
            Screen pantalla, LogicaCliente logicaCliente, LogicaTarjeta logicaTarjeta,
            LogicaMovimiento logicaMovimiento, LogicaCuenta logicaCuenta,RegistrarCuenta registrarCuenta) {
        this.clientesActivos = clientesActivos;
        this.clientesInactivos = clientesInactivos;
        this.cuentasCliente = cuentasCliente;
        this.login = login;
        this.movimientos = movimientos;
        this.principal = principal;
        this.registrarCliente = registrarCliente;
        this.registrarTarjeta = registrarTarjeta;
        this.tablaTarjetas = tablaTarjetas;
        this.pantalla = pantalla;
        this.logicaCliente = logicaCliente;
        this.logicaTarjeta = logicaTarjeta;
        this.logicaMovimiento = logicaMovimiento;
        this.logicaCuenta = logicaCuenta;
        this.registrarCuenta=registrarCuenta;
    }

    public ClientesActivos getClientesActivos() {
        return clientesActivos;
    }

    public RegistrarCuenta getRegistrarCuenta() {
        return registrarCuenta;
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

    public void mostrarClientesActivos() {
        JPanel dashboard = pantalla.getDashboard();
        dashboard.removeAll();
        dashboard.add(clientesActivos);
        dashboard.revalidate();
        dashboard.repaint();
    }
    public void mostrarClientesInactivos() {
        JPanel dashboard = pantalla.getDashboard();
        dashboard.removeAll();
        dashboard.add(clientesInactivos);
        dashboard.revalidate();
        dashboard.repaint();
    }

    public void mostrarCuentasCliente() {
        JPanel dashboard = pantalla.getDashboard();
        dashboard.removeAll();
        dashboard.add(cuentasCliente);
        dashboard.revalidate();
        dashboard.repaint();
    }

    public void mostrarLogin() {
        JPanel dashboard = pantalla.getDashboard();
        dashboard.removeAll();
        dashboard.add(login);
        dashboard.revalidate();
        dashboard.repaint();
    }

    public void mostrarMovimientos() {
        JPanel dashboard = pantalla.getDashboard();
        dashboard.removeAll();
        dashboard.add(movimientos);
        dashboard.revalidate();
        dashboard.repaint();
    }

    public void mostrarPrincipal() {
        JPanel dashboard = pantalla.getDashboard();
        dashboard.removeAll();
        dashboard.add(principal);
        dashboard.revalidate();
        dashboard.repaint();
    }

    public void mostrarRegistrarCliente() {
        JPanel dashboard = pantalla.getDashboard();
        dashboard.removeAll();
        dashboard.add(registrarCliente);
        dashboard.revalidate();
        dashboard.repaint();
    }
    
       public void mostrarRegistrarCuenta() {
        JPanel dashboard = pantalla.getDashboard();
        dashboard.removeAll();
        dashboard.add(registrarCuenta);
        dashboard.revalidate();
        dashboard.repaint();
    }


    public void mostrarRegistrarTarjeta() {
        JPanel dashboard = pantalla.getDashboard();
        dashboard.removeAll();
        dashboard.add(registrarTarjeta);
        dashboard.revalidate();
        dashboard.repaint();
    }

    public void mostrarTablaTarjetas() {
        JPanel dashboard = pantalla.getDashboard();
        dashboard.removeAll();
        dashboard.add(tablaTarjetas);
        dashboard.revalidate();
        dashboard.repaint();
    }

    public Screen getPantalla() {
        return pantalla;
    }

    public void setPantalla(Screen pantalla) {
        this.pantalla = pantalla;
    }

    public ClientesInactivos getClientesInactivos() {
        return clientesInactivos;
    }

    public void setClientesInactivos(ClientesInactivos clientesInactivos) {
        this.clientesInactivos = clientesInactivos;
    }

    public LogicaCliente getLogicaCliente() {
        return logicaCliente;
    }

    public void setLogicaCliente(LogicaCliente logicaCliente) {
        this.logicaCliente = logicaCliente;
    }

    public LogicaTarjeta getLogicaTarjeta() {
        return logicaTarjeta;
    }

    public void setLogicaTarjeta(LogicaTarjeta logicaTarjeta) {
        this.logicaTarjeta = logicaTarjeta;
    }

    public LogicaMovimiento getLogicaMovimiento() {
        return logicaMovimiento;
    }

    public void setLogicaMovimiento(LogicaMovimiento logicaMovimiento) {
        this.logicaMovimiento = logicaMovimiento;
    }

    public LogicaCuenta getLogicaCuenta() {
        return logicaCuenta;
    }

    public void setLogicaCuenta(LogicaCuenta logicaCuenta) {
        this.logicaCuenta = logicaCuenta;
    }
}
