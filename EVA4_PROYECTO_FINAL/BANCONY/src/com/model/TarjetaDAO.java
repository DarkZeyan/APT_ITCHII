package com.model;

import com.conexion.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import LibreriaFecha.Fecha;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class TarjetaDAO {

    private final Connection conexion;

    public TarjetaDAO() {
        conexion = ConexionBD.getConexionBD();
    }

    public Tarjeta agregarTarjetaDAO(Tarjeta tarjeta) {
        try {
            String qryInsert;
            PreparedStatement ps;
            qryInsert = "INSERT INTO tarjetas(cuentas_c_cuenta, numerotarjeta, " +
                    "limite_credito, anualidad, fecha_anualidad) " +
                    "VALUES(?,?,?,?,?)";

            ps = conexion.prepareStatement(qryInsert);
            ps.setInt(1, tarjeta.getCuenta().getC_cuenta());
            ps.setString(2, tarjeta.getNumero_tarjeta());
            ps.setDouble(3, tarjeta.getLimite_credito());
            ps.setDouble(4, tarjeta.getAnualidad());
            ps.setString(5, tarjeta.getFecha_anualidad().toString());
            ps.execute();
            ResultSet query;
            query = conexion.prepareStatement("SELECT LAST_INSERT_ID()").executeQuery();
            if (query.next()) {
                tarjeta.setClave_tarjeta((query.getInt(1)));
            } else {
                tarjeta = null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo añadir la tarjeta");
            tarjeta = null;
            return tarjeta;
        }
        return tarjeta;
    }

    public Tarjeta consultarTarjetaDAO(int clave_tarjeta) {
        String qrySelect;

        qrySelect = "SELECT * from tarjetas WHERE clave_tarjeta =?";
        PreparedStatement ps;
        ResultSet query;
        try {
            ps = conexion.prepareStatement(qrySelect);
            ps.setInt(1, clave_tarjeta);
            query = ps.executeQuery();

            if (query.next()) {
                int c_cuenta = query.getInt("cuentas_c_cuenta");
                double anualidad = query.getDouble("anualidad");
                double limite_credito = query.getDouble("limite_credito");
                String numeroTarjeta = query.getString("numerotarjeta");
                String fechaAnualidadStr = query.getString("fecha_anualidad");
                int anioAnualidad = Integer.parseInt(fechaAnualidadStr.substring(0, 4));
                int mesAnualidad = Integer.parseInt(fechaAnualidadStr.substring(5, 7));
                int diaAnualidad = Integer.parseInt(fechaAnualidadStr.substring(8, 10));

                Fecha fechaAnualidad = new Fecha(diaAnualidad, mesAnualidad, anioAnualidad);

                return new Tarjeta(clave_tarjeta, numeroTarjeta, fechaAnualidad, anualidad, limite_credito);

            }

        } catch (SQLException e) {
            return null;
        } catch (Exception e) {

        }
        return null;
    }

    public int eliminarTarjetaDAO(Tarjeta tarjeta) {
        int numRegistrosEliminados = 0;
        try {

            String qryDelete = "DELETE FROM tarjetas WHERE c_cuenta = ? AND clave_tarjeta = ?";
            PreparedStatement ps;
            ps = conexion.prepareStatement(qryDelete);
            ps.setInt(1, tarjeta.getCuenta().getC_cuenta());
            ps.setInt(2, tarjeta.getClave_tarjeta());
            numRegistrosEliminados = ps.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar la tarjeta");

        } catch (Exception e) {
            // TODO: handle exception
        }
        return numRegistrosEliminados;
    }

    private List<Tarjeta> getListaTarjetasCliente(Cuenta cuenta) {
        List<Tarjeta> tarjetas = new ArrayList<>();

        String qrySelect = "SELECT * FROM tarjetas WHERE cuentas_c_cuenta=" + cuenta.getC_cuenta()
                + " ORDER BY clave_tarjeta";

        PreparedStatement ps;
        ResultSet query;
        try {
            ps = conexion.prepareStatement(qrySelect);
            query = ps.executeQuery();

            while (query.next()) {
                int clave_tarjeta = query.getInt("clave_tarjeta");
                double anualidad = query.getDouble("anualidad");
                double limite_credito = query.getDouble("limite_credito");
                String numeroTarjeta = query.getString("numerotarjeta");
                String fechaAnualidadStr = query.getString("fecha_anualidad");
                int anioAnualidad = Integer.parseInt(fechaAnualidadStr.substring(0, 4));
                int mesAnualidad = Integer.parseInt(fechaAnualidadStr.substring(5, 7));
                int diaAnualidad = Integer.parseInt(fechaAnualidadStr.substring(8, 10));
                Fecha fechaAnualidad = new Fecha(diaAnualidad, mesAnualidad, anioAnualidad);
                tarjetas.add(
                        new Tarjeta(clave_tarjeta,numeroTarjeta,fechaAnualidad,anualidad,limite_credito));

            }
            return tarjetas;
        } catch (SQLException e) {
            return null;
        } catch (Exception e) {

        }
        return null;
    }

    public List<Tarjeta> getTarjetasCuenta(Cuenta c){
        List<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas = getListaTarjetasCliente(c);
        return tarjetas;
    }
}
