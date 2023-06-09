package com.model;


import com.conexion.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ClienteDAO {
    private final Connection conexion;

    public ClienteDAO(){
        this.conexion = ConexionBD.getConexionBD();
    }

    public Cliente agregarDAO(Cliente cliente){
        try{    
            String qryInsert;
            
            PreparedStatement ps;

            qryInsert = "INSERT INTO clientes(nombre, apellido_paterno, apellido_materno, celular, estadoNacimiento, "+
            "sexo, curp, fechaNacimiento) "
            +"VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(qryInsert);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getPaterno());
            ps.setString(3, cliente.getMaterno());
            ps.setString(4, cliente.getCelular());
            ps.setString(5, cliente.getEstadoDeNacimiento());
            ps.setString(6, String.valueOf(cliente.getSexo()));
            ps.setString(7, cliente.getCurp());
            ps.setString(8, cliente.getFechadeNacimiento().toString());

        }catch(SQLException e){
            return null;
        }
        return cliente;
    }


}
