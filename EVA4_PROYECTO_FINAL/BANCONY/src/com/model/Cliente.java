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
    private List<Cuenta> cuentas;
    public void setC_cliente(int c_cliente) {
        this.c_cliente = c_cliente;
    }
    public int getC_cliente() {
        return c_cliente;
    }

    public Cliente(int c_cliente, String curp, String paterno, String materno, String nombre, String celular, Fecha fechadeNacimiento, String estadoDeNacimiento, char sexo, List<Cuenta> cuentas) throws CurpInvalida {
        super(curp, paterno, materno, nombre, celular, fechadeNacimiento, estadoDeNacimiento, sexo);
        setC_cliente(c_cliente);
    }

    @Override
    public String toString(){
        return getCurp()+" "+getNombre()+" "+getPaterno()+" "+getMaterno();
    }
    
        public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setTarjetas(List<Cuenta> cuentas) {
        if(cuentas==null){
            this.cuentas = new ArrayList<Cuenta>();
        }else{
            this.cuentas=cuentas;
        }
    }

}
