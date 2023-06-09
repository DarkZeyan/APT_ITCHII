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
public class LogicaCuenta {
    private CuentaDAO cuentaDao = new CuentaDAO();

    private Controller controller;

    public LogicaCuenta() {    
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Cuenta agregar(Cuenta cuenta) {
        return cuentaDao.agregarCuentaDAO(cuenta);
    }

    public int modificar(Cuenta cuenta) {
        return cuentaDao.modificarCuentaDAO(cuenta);
    }

    public int eliminar(Cuenta cuenta) {
        return cuentaDao.eliminarCuentaDAO(cuenta);
    }

    public Cuenta consultar(int c_cuenta) {
        return cuentaDao.consultarCuentaDAO(c_cuenta);
    }

    public List<Cuenta> getListaCuentas(Cliente cliente) {
        return cuentaDao.getListaCuentasClienteDAO(cliente);
    }

}
