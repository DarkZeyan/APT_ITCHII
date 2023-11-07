/*
JORGE EDUARDO ESCOBAR BUGARINI - ISC - 21550317
 */
package com.model;

import com.controller.Controller;
import java.util.List;

/**
 *
 * @author user
 */
public class LogicaTarjeta {
      private TarjetaDAO tDAO = new TarjetaDAO();
    
     private Controller controller;

    public LogicaTarjeta() {
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
    
    public Tarjeta agregar(Tarjeta tarjeta){
        return tDAO.agregarTarjetaDAO(tarjeta);
    }
    
    public int eliminar(int c_cuenta, int clave_tarjeta){
        int cuenta = c_cuenta;
        int tarjeta = clave_tarjeta;
        return tDAO.eliminarTarjetaDAO(cuenta,tarjeta);
    }
    
    public Tarjeta consultar( int clave_tarjeta){
        return tDAO.consultarTarjetaDAO(clave_tarjeta);
    }
    
    public List<Tarjeta> getListaTarjetas(Cuenta cuenta){
        return tDAO.getTarjetasCuenta(cuenta);
    }
    
}
