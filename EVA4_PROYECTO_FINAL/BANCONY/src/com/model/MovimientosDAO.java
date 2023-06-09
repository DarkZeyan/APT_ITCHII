package com.model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import LibreriaFecha.Fecha;
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
            qryInsert = "INSERT INTO movimientos(tarjetas_tarjeta_clave, tipo_movimiento, " +
                    "fecha_movimiento, cantidad) " +
                    "VALUES(?,?,?,?)";

            ps = conexion.prepareStatement(qryInsert);
            ps.setInt(1, movimiento.getTarjeta().getClave_tarjeta());
            ps.setInt(2, movimiento.getTipoMovimiento());
            ps.setString(3, movimiento.getFechaMovimiento().toString());
            ps.setDouble(4, movimiento.getCantidad());
            ps.execute();
            ResultSet query;
            query = conexion.prepareStatement("SELECT LAST_INSERT_ID()").executeQuery();
            if (query.next()) {
                movimiento.setClave((query.getInt(1)));
            } else {
                movimiento = null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo añadir el movimiento");
            movimiento = null;
            return movimiento;
        }
        return movimiento;
    }

    
    public Movimiento consultarMovimientoDAO(int clave) {
        String qrySelect;

        qrySelect = "SELECT * from movimientos WHERE clave=?";
        PreparedStatement ps;
        ResultSet query;
        try {
            ps = conexion.prepareStatement(qrySelect);
            ps.setInt(1, clave);
            query = ps.executeQuery();

            if (query.next()) {
                int c_tarjeta = query.getInt("tarjetas_clave_tarjeta");
                int tipoMovimiento = query.getInt("tipo_movimiento");
                double cantidad = query.getDouble("cantidad");
                String fechaMovimientoStr = query.getString("fecha_movimiento");
                int diaMovimiento = Integer.parseInt(fechaMovimientoStr.substring(0, 4));
                int mesMovimiento = Integer.parseInt(fechaMovimientoStr.substring(5, 7));
                int anioMovimiento = Integer.parseInt(fechaMovimientoStr.substring(8, 10));

                Fecha fechaMovimiento = new Fecha(diaMovimiento, mesMovimiento, anioMovimiento);

                return new Movimiento(c_tarjeta,fechaMovimiento,tipoMovimiento,cantidad,clave);

            }

        } catch (SQLException e) {
            return null;
        } catch (Exception e) {

        }
        return null;
    }

    public int eliminarMovimientoDAO(Movimiento movimiento) {
        int numRegistrosEliminados = 0;
        try {

            String qryDelete = "DELETE FROM movimientos WHERE clave=?";
            PreparedStatement ps;
            ps = conexion.prepareStatement(qryDelete);
            ps.setInt(1, movimiento.getClave());
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

        String qrySelect = "SELECT * FROM movimientos WHERE tarjetas_tarjeta_clave=" + tarjeta.getClave_tarjeta()
                + " ORDER BY clave";

        PreparedStatement ps;
        ResultSet query;
        try {
            ps = conexion.prepareStatement(qrySelect);
            query = ps.executeQuery();

            while (query.next()) {
                int tipoMovimiento = query.getInt("tipo_movimiento");
                int clave = query.getInt("clave");
                double cantidad = query.getDouble("cantidad");
                String fechaMovimientoStr = query.getString("fecha_movimiento");
                int diaMovimiento = Integer.parseInt(fechaMovimientoStr.substring(0, 4));
                int mesMovimiento = Integer.parseInt(fechaMovimientoStr.substring(5, 7));
                int anioMovimiento = Integer.parseInt(fechaMovimientoStr.substring(8, 10));

                 Fecha fechaMovimiento = new Fecha(diaMovimiento, mesMovimiento, anioMovimiento);
                movimientos.add(
                        new Movimiento(tarjeta.getClave_tarjeta(),fechaMovimiento,tipoMovimiento,cantidad,clave));

            }
            return movimientos;
        } catch (SQLException e) {
            return null;
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
