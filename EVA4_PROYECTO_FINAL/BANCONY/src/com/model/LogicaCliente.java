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
public class LogicaCliente {
    private ClienteDAO cDAO = new ClienteDAO();
    
     private Controller controller;

     
    public LogicaCliente() {
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
    
    public Cliente agregar(Cliente cliente){
        return cDAO.agregarDAO(cliente);
    }
    
    public int modificar(Cliente cliente){
        return cDAO.modificarDAO(cliente);
    }
    
    public int eliminar(Cliente cliente){
        return cDAO.eliminarCuentaDAO(cliente);
    }
    
    public Cliente consultar(int c_cliente){
        return cDAO.consultarClienteDAO(c_cliente);
    }
    
    public List<Cliente> getListaClientes(){
        return cDAO.getListaClientes();
    }
    
}
