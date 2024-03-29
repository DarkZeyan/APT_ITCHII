/*
JORGE EDUARDO ESCOBAR BUGARINI - ISC - 21550317
 */
package com.model;

import LibreriaFecha.Fecha;
import LibreriaPersona.CurpInvalida;

import LibreriaPersona.Persona;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona{
    
    private int c_cliente;
   
    public void setC_cliente(int c_cliente) {
        this.c_cliente = c_cliente;
    }
    public int getC_cliente() {
        return c_cliente;
    }

    public Cliente(int c_cliente, String curp, String paterno, String materno, String nombre, String celular, Fecha fechadeNacimiento, String estadoDeNacimiento, char sexo) throws CurpInvalida {
        super(curp, paterno, materno, nombre, celular, fechadeNacimiento, estadoDeNacimiento, sexo);
        setC_cliente(c_cliente);
    }

    
    public Cliente(String curp, String paterno, String materno, String nombre, String celular,
            Fecha fechadeNacimiento, String estadoDeNacimiento, char sexo) throws CurpInvalida {
        super(curp, paterno, materno, nombre, celular, fechadeNacimiento, estadoDeNacimiento, sexo);
    }
    @Override
    public String toString(){
        return getCurp()+" "+getNombre()+" "+getPaterno()+" "+getMaterno();
    }
    


}
