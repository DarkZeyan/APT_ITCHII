package com.model;

import com.conexion.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import LibreriaFecha.Fecha;
import com.controller.Controller;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ClienteDAO {
    private final Connection conexion;
    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }
    
    public ClienteDAO() {
        this.conexion = ConexionBD.getConexionBD();
    }

    public Cliente agregarDAO(Cliente cliente) {
        try {
            String qryInsert;

            PreparedStatement ps;

            qryInsert = "INSERT INTO clientes(nombre, apellido_paterno, apellido_materno, celular, estadoNacimiento, " +
                    "sexo, curp, fechaNacimiento) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(qryInsert);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getPaterno());
            ps.setString(3, cliente.getMaterno());
            ps.setString(4, cliente.getCelular());
            ps.setString(5, cliente.getEstadoDeNacimiento());
            ps.setString(6, String.valueOf(cliente.getSexo()));
            ps.setString(7, cliente.getCurp());
            ps.setString(8, cliente.getFechadeNacimiento().toString());
            ps.executeUpdate();
            ResultSet query;
            query = conexion.prepareStatement("SELECT LAST_INSERT_ID()").executeQuery();
            if(query.next()){
                cliente.setC_cliente(query.getInt(1));
            }else{
                cliente = null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo añadir al cliente");
            cliente = null;
            return cliente;
        }
        return cliente;
    }

    public int modificarDAO(Cliente cliente) {
        int numRegistrosMod = 0;
        try {
            String qryUpdate;
            PreparedStatement ps;
            qryUpdate = "UPDATE clientes SET "
                    + "nombre = ?, "
                    + "apellido_paterno = ?, "
                    + "apellido_materno = ?, "
                    + "celular = ?, "
                    + "estadoNacimiento = ?, "
                    + "sexo = ?, "
                    + "fechaNacimiento = ?, "
                    + "WHERE c_cliente = ? ";
            ps = conexion.prepareStatement(qryUpdate);

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getPaterno());
            ps.setString(3, cliente.getMaterno());
            ps.setString(4, cliente.getCelular());
            ps.setString(5, cliente.getEstadoDeNacimiento());
            ps.setString(6, String.valueOf(cliente.getSexo()));
            ps.setString(7, cliente.getFechadeNacimiento().toString());
            ps.setInt(8, cliente.getC_cliente());
            numRegistrosMod = ps.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo llevar a cabo la modificacion");
            numRegistrosMod = 0;
        }
        return numRegistrosMod;
    }

    public Cliente consultarClienteDAO(int c_cliente) {
        String qrySelect;
        qrySelect = "SELECT * from clientes WHERE c_cliente = ?";
        PreparedStatement ps;
        ResultSet query;
        try {
            ps = conexion.prepareStatement(qrySelect);
            ps.setInt(1, c_cliente);
            query = ps.executeQuery();

            if (query.next()) {
                String curp = query.getString("curp");
                String nombre = query.getString("nombre");
                String paterno = query.getString("apellido_paterno");
                String materno = query.getString("apellido_materno");
                String celular = query.getString("telefono");
                String estadoNacimiento = query.getString("estadoNacimiento");
                String fechaNacimientoStr = query.getString("fechaNacimiento");
                char sexo = query.getString("sexo").charAt(0);

                int anioNacimiento = Integer.parseInt(fechaNacimientoStr.substring(0, 4));
                int mesNacimiento = Integer.parseInt(fechaNacimientoStr.substring(5, 7));
                int diaNacimiento = Integer.parseInt(fechaNacimientoStr.substring(8, 10));

                Fecha fechadeNacimiento = new Fecha(diaNacimiento, mesNacimiento, anioNacimiento);
                return new Cliente(c_cliente, curp, paterno, materno, nombre, celular, fechadeNacimiento,
                        estadoNacimiento, sexo);

            }

        } catch (SQLException e) {
            return null;
        } catch (Exception e) {

        }
        return null;
    }

    public int eliminarCuentaDAO(Cliente cliente) {
        int numRegistrosEliminados=0;
        try {
            

            String qryDelete = "DELETE FROM clientes WHERE c_cliente = ?";
            PreparedStatement ps;
            String qryInsert = "INSERT INTO clientesInactivos(nombre, apellido_paterno, apellido_materno, telefono, estadoNacimiento, " +
                    "sexo, curp, fechaNacimiento) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(qryInsert);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getPaterno());
            ps.setString(3, cliente.getMaterno());
            ps.setString(4, cliente.getCelular());
            ps.setString(5, cliente.getEstadoDeNacimiento());
            ps.setString(6, String.valueOf(cliente.getSexo()));
            ps.setString(7, cliente.getCurp());
            ps.setString(8, cliente.getFechadeNacimiento().toString());
            ps.executeUpdate();
            ResultSet query;
            query = conexion.prepareStatement("SELECT LAST_INSERT_ID()").executeQuery();
            if(query.next()){
                cliente.setC_cliente(query.getInt(1));
            }else{
                cliente = null;
            }
            ps = conexion.prepareStatement(qryDelete);
            ps.setInt(1, cliente.getC_cliente());
            numRegistrosEliminados =ps.executeUpdate();
            
        } catch (SQLException e) {
            // TODO: handle exception

        } catch (Exception e) {
            // TODO: handle exception
        }
        return numRegistrosEliminados;
    }

    private List<Cliente> consultarClientes() {
        List<Cliente> clientes = new ArrayList<>();

        String qrySelect = "SELECT * FROM `banco`.`clientes`  ORDER BY curp";

        PreparedStatement ps;

        ResultSet query;

        try {
            ps = conexion.prepareStatement(qrySelect);
            query = ps.executeQuery();
            while (query.next()) {
                
                int c_cliente = query.getInt("c_cliente");
                String curp = query.getString("curp");
                String nombre = query.getString("nombre");
                String paterno = query.getString("apellido_paterno");
                String materno = query.getString("apellido_materno");
                String celular = query.getString("telefono");
                String estadoNacimiento = query.getString("estadoNacimiento");
                String fechaNacimientoStr = query.getString("fechaNacimiento");
                char sexo = query.getString("sexo").charAt(0);
                int anioNacimiento = Integer.parseInt(fechaNacimientoStr.substring(0, 4));
                int mesNacimiento = Integer.parseInt(fechaNacimientoStr.substring(5, 7));
                int diaNacimiento = Integer.parseInt(fechaNacimientoStr.substring(8, 10));
               
                Fecha fechadeNacimiento = new Fecha(diaNacimiento, mesNacimiento, anioNacimiento);                
                Cliente cliente = new Cliente(c_cliente, curp, paterno, materno, nombre, celular, fechadeNacimiento,
                        estadoNacimiento, sexo);
                clientes.add(cliente);
            }
            return clientes;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getSQLState());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        System.out.println(clientes.size());
        return clientes;
    }

    public List<Cliente> getListaClientes() {
        List<Cliente> clientes = consultarClientes();
        return clientes;
    }

}
