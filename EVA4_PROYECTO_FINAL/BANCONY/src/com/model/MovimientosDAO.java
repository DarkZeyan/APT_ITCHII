package com.model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import LibreriaFecha.Fecha;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.conexion.ConexionBD;
public class MovimientosDAO {
    private final Connection conexion;

    public MovimientosDAO() {
        conexion = ConexionBD.getConexionBD();
    }

     public Movimiento agregarMovimientoDAO(Movimiento movimiento) {
        try {
            String qryInsert;
            PreparedStatement ps;
            qryInsert = "INSERT INTO movimientos(tarjetas_clave_tarjeta, tipo_movimiento, " +
                    "fecha_movimiento, cantidad) " +
                    "VALUES(?,?,?,?)";

            ps = conexion.prepareStatement(qryInsert);
            ps.setInt(1, movimiento.getTarjeta().getClave_tarjeta());
            ps.setInt(2, movimiento.getTipoMovimiento());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date fecha = new java.sql.Date(sdf.parse(movimiento.getFechaMovimiento().toString()).getTime());
            ps.setDate(3, fecha);
            ps.setDouble(4, movimiento.getCantidad());
            ps.execute();
            ResultSet query;
            query = conexion.prepareStatement("SELECT LAST_INSERT_ID()").executeQuery();
            if (query.next()) {
                movimiento.setClave((query.getInt(1)));
            } else {
                movimiento = null;
            }
        } catch (SQLException | ParseException e) {
            JOptionPane.showMessageDialog(null,  e.getMessage());
            movimiento = null;
            return movimiento;
        }
        return movimiento;
    }

    
    public Movimiento consultarMovimientoDAO(int clave_tarjeta) {
        String qrySelect;

        qrySelect = "SELECT * from movimientos WHERE tarjetas_clave_tarjeta=?";
        PreparedStatement ps;
        ResultSet query;
        try {
            ps = conexion.prepareStatement(qrySelect);
            ps.setInt(1, clave_tarjeta);
            query = ps.executeQuery();

            if (query.next()) {
                int clave = query.getInt("c_movimiento");
                int tipoMovimiento = query.getInt("tipo_movimiento");
                double cantidad = query.getDouble("cantidad");
                String fechaMovimientoStr = query.getString("fecha_movimiento");
                int anioMovimiento = Integer.parseInt(fechaMovimientoStr.substring(0, 4));
                int mesMovimiento = Integer.parseInt(fechaMovimientoStr.substring(5, 7));
                int diaMovimiento = Integer.parseInt(fechaMovimientoStr.substring(8, 10));

                Fecha fechaMovimiento = new Fecha(diaMovimiento, mesMovimiento, anioMovimiento);

                return new Movimiento(clave_tarjeta,fechaMovimiento,tipoMovimiento,cantidad,clave);

            }

        } catch (SQLException e) {
            
        } catch (Exception e) {

        }
        return null;
    }

    public int eliminarMovimientoDAO(int c_movimiento, int clave_tarjeta) {
        int numRegistrosEliminados = 0;
        try {

            String qryDelete = "DELETE FROM movimientos WHERE c_movimiento=? and tarjetas_clave_tarjeta=?";
            PreparedStatement ps;
            ps = conexion.prepareStatement(qryDelete);
            ps.setInt(1, c_movimiento);
            ps.setInt(2, clave_tarjeta);
            numRegistrosEliminados = ps.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el movimiento");

        } catch (Exception e) {
            // TODO: handle exception
        }
        return numRegistrosEliminados;
    }

    private List<Movimiento> getListaMovimientosTarjeta(Tarjeta tarjeta) {
        List<Movimiento> movimientos = new ArrayList<>();

        String qrySelect = "SELECT * FROM movimientos WHERE tarjetas_clave_tarjeta=" + tarjeta.getClave_tarjeta()
                + " ORDER BY c_movimiento";

        PreparedStatement ps;
        ResultSet query;
        try {
            ps = conexion.prepareStatement(qrySelect);
            query = ps.executeQuery();

            while (query.next()) {
                int tipoMovimiento = query.getInt("tipo_movimiento");
                int clave = query.getInt("c_movimiento");
                double cantidad = query.getDouble("cantidad");
                String fechaMovimientoStr = query.getString("fecha_movimiento");
                int anioMovimiento = Integer.parseInt(fechaMovimientoStr.substring(0, 4));
                int mesMovimiento = Integer.parseInt(fechaMovimientoStr.substring(5, 7));
                int diaMovimiento = Integer.parseInt(fechaMovimientoStr.substring(8, 10));

                 Fecha fechaMovimiento = new Fecha(diaMovimiento, mesMovimiento, anioMovimiento);
                movimientos.add(
                        new Movimiento(tarjeta.getClave_tarjeta(),fechaMovimiento,tipoMovimiento,cantidad,clave));

            }
            return movimientos;
        } catch (SQLException e) {
           
        } catch (Exception e) {

        }
        return null;
    }

    public List<Movimiento> getMovimientos(Tarjeta t){
        List<Movimiento> movimientos = new ArrayList<>();
        movimientos = getListaMovimientosTarjeta(t);
        return movimientos;
    }

}
