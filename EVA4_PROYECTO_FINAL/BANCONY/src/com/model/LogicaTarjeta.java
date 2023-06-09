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
    
    public int eliminar(Tarjeta tarjeta){
        return tDAO.eliminarTarjetaDAO(tarjeta);
    }
    
    public Tarjeta consultar(Tarjeta tarjeta){
        return tDAO.consultarTarjetaDAO(tarjeta.getClave_tarjeta());
    }
    
    public List<Tarjeta> getListaTarjetas(Cuenta cuenta){
        return tDAO.getTarjetasCuenta(cuenta);
    }
    
}
