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
public class LogicaMovimiento {
      private MovimientosDAO mDAO = new MovimientosDAO();
    
     private Controller controller;

     
     public LogicaMovimiento() {
    }
    
    public Movimiento agregar(Movimiento movimiento){
        return mDAO.agregarMovimientoDAO(movimiento);
    }
    
    public int eliminar(int c_movimiento, int clave_tarjeta){
        int movimiento = c_movimiento;
        int tarjeta = clave_tarjeta;
        return mDAO.eliminarMovimientoDAO(movimiento,tarjeta);
    }
    
    public Movimiento consultar(int clave_tarjeta){
        return mDAO.consultarMovimientoDAO(clave_tarjeta);
    }
    
    public List<Movimiento> getListaMovimientos(Tarjeta tarjeta){
        return mDAO.getMovimientos(tarjeta);
    }

    public void setmDAO(MovimientosDAO mDAO) {
        this.mDAO = mDAO;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
    
}
