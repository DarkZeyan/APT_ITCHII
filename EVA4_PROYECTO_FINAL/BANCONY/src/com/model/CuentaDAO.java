package com.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import LibreriaFecha.Fecha;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.conexion.ConexionBD;

public class CuentaDAO {

    private final Connection conexion;

    public CuentaDAO() {
        this.conexion = ConexionBD.getConexionBD();
    }

    public Cuenta agregarCuentaDAO(Cuenta cuenta) {

        try {
            String qryInsert;
            PreparedStatement ps;

            qryInsert = "INSERT INTO cuentas(clientes_c_cliente, numerocuenta, tasainteres, fecha_pago, fecha_corte, fecha_creacion) "
                    +
                    " VALUES(?,?,?,?,?,?)";

            ps = conexion.prepareStatement(qryInsert);
            ps.setInt(1, cuenta.getCliente().getC_cliente());
            ps.setString(2, cuenta.getNumerocuenta());
            ps.setDouble(3, cuenta.getTasainteres());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date fecha1 = new java.sql.Date(sdf.parse(cuenta.getFechaPago().toString()).getTime());
            java.sql.Date fecha2 = new java.sql.Date(sdf.parse(cuenta.getFechaCorte().toString()).getTime());
            java.sql.Date fecha3 = new java.sql.Date(sdf.parse(cuenta.getFechaCreacion().toString()).getTime());
            ps.setDate(4, fecha1);
            ps.setDate(5, fecha2);
            ps.setDate(6, fecha3);
            ps.executeUpdate();

            ResultSet query;
            query = conexion.prepareStatement("SELECT LAST_INSERT_ID()").executeQuery();
            if (query.next()) {
                cuenta.setC_cuenta(query.getInt(1));
            } else {
                cuenta = null;
            }

        } catch (SQLException | ParseException e) {
            // JOptionPane.showMessageDialog(null, "No se pudo llevar a cabo la creacion de la cuenta");
            JOptionPane.showMessageDialog(null, e.getMessage());
            cuenta = null;
            return cuenta;
        }
        return cuenta;
    }

    public int modificarCuentaDAO(Cuenta cuenta) {
        int numRegistrosMod = 0;
        try {
            String qryUpdate;
            PreparedStatement ps;
            qryUpdate = "UPDATE cuentas SET "
                    + "tasainteres = ?, "
                    + "fecha_pago = ?, "
                    + "fecha_corte = ?, "
                    + "WHERE clientes_c_cliente = ? ";
            ps = conexion.prepareStatement(qryUpdate);

            ps.setDouble(1, numRegistrosMod);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date fecha1 = new java.sql.Date(sdf.parse(cuenta.getFechaPago().toString()).getTime());
            java.sql.Date fecha2 = new java.sql.Date(sdf.parse(cuenta.getFechaCorte().toString()).getTime());
            ps.setDate(2, fecha1);
            ps.setDate(3, fecha2);
            ps.setInt(4, cuenta.getCliente().getC_cliente());
            numRegistrosMod = ps.executeUpdate();

        } catch (SQLException | ParseException e) {
            JOptionPane.showMessageDialog(null, "No se pudo llevar a cabo la modificacion");
            numRegistrosMod = 0;
        }
        return numRegistrosMod;
    }

    private Cliente consultarClienteDAO(int c_cliente) {
        String qrySelect;
        qrySelect = "SELECT * from cuentas WHERE clientes_c_cliente = ?";
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
                String celular = query.getString("celular");
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

    public Cuenta consultarCuentaDAO(int c_cuenta) {
        String qrySelect;

        qrySelect = "SELECT * from cuentas WHERE c_cuenta = ?";
        PreparedStatement ps;
        ResultSet query;
        try {
            ps = conexion.prepareStatement(qrySelect);
            ps.setInt(1, c_cuenta);
            query = ps.executeQuery();

            if (query.next()) {
                int c_cliente = query.getInt("clientes_c_cliente");
                double tasainteres = query.getDouble("tasainteres");
                String numerocuenta = query.getString("numerocuenta");
                String fechaCreacionStr = query.getString("fecha_creacion");
                String fechaCorteStr = query.getString("fecha_corte");
                String fechaPagoStr = query.getString("fecha_pago");

                int anioCreacion = Integer.parseInt(fechaCreacionStr.substring(0, 4));
                int mesCreacion = Integer.parseInt(fechaCreacionStr.substring(5, 7));
                int diaCreacion = Integer.parseInt(fechaCreacionStr.substring(8, 10));
                int anioCorte = Integer.parseInt(fechaCorteStr.substring(0, 4));
                int mesCorte = Integer.parseInt(fechaCorteStr.substring(5, 7));
                int diaCorte = Integer.parseInt(fechaCorteStr.substring(8, 10));
                int anioPago = Integer.parseInt(fechaPagoStr.substring(0, 4));
                int mesPago = Integer.parseInt(fechaPagoStr.substring(5, 7));
                int diaPago = Integer.parseInt(fechaPagoStr.substring(8, 10));

                Fecha fechaCorte = new Fecha(diaCorte, mesCorte, anioCorte);
                Fecha fechaCreacion = new Fecha(diaCreacion, mesCreacion, anioCreacion);
                Fecha fechaPago = new Fecha(diaPago, mesPago, anioPago);

                Cliente cliente = consultarClienteDAO(c_cliente);
                return new Cuenta(cliente, c_cuenta, numerocuenta, tasainteres, fechaPago, fechaCorte, fechaCreacion);

            }

        } catch (SQLException e) {
            return null;
        } catch (Exception e) {

        }
        return null;
    }

    private List<Cuenta> getListaCuentasCliente(Cliente cliente) {
        List<Cuenta> cuentas = new ArrayList<>();

        String qrySelect = "SELECT * FROM cuentas WHERE clientes_c_cliente=" + cliente.getC_cliente()
                + " ORDER BY c_cuenta";

        PreparedStatement ps;
        ResultSet query;
        try {
            ps = conexion.prepareStatement(qrySelect);
            query = ps.executeQuery();

            while (query.next()) {
                int c_cuenta = query.getInt("c_cuenta");
                double tasainteres = query.getDouble("tasainteres");
                String numerocuenta = query.getString("numerocuenta");
                String fechaCreacionStr = query.getString("fecha_creacion");
                String fechaCorteStr = query.getString("fecha_corte");
                String fechaPagoStr = query.getString("fecha_pago");

                int anioCreacion = Integer.parseInt(fechaCreacionStr.substring(0, 4));
                int mesCreacion = Integer.parseInt(fechaCreacionStr.substring(5, 7));
                int diaCreacion = Integer.parseInt(fechaCreacionStr.substring(8, 10));
                int anioCorte = Integer.parseInt(fechaCorteStr.substring(0, 4));
                int mesCorte = Integer.parseInt(fechaCorteStr.substring(5, 7));
                int diaCorte = Integer.parseInt(fechaCorteStr.substring(8, 10));
                int anioPago = Integer.parseInt(fechaPagoStr.substring(0, 4));
                int mesPago = Integer.parseInt(fechaPagoStr.substring(5, 7));
                int diaPago = Integer.parseInt(fechaPagoStr.substring(8, 10));

                Fecha fechaCorte = new Fecha(diaCorte, mesCorte, anioCorte);
                Fecha fechaCreacion = new Fecha(diaCreacion, mesCreacion, anioCreacion);
                Fecha fechaPago = new Fecha(diaPago, mesPago, anioPago);

                cuentas.add(
                        new Cuenta(cliente, c_cuenta, numerocuenta, tasainteres, fechaPago, fechaCorte, fechaCreacion));

            }
            return cuentas;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo traer las cuentas del cliente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo traer las cuentas del cliente");
        }
        return null;
    }

    public List<Cuenta> getListaCuentasClienteDAO(Cliente cliente) {
        List<Cuenta> cuentas = new ArrayList<>();
        cuentas = getListaCuentasCliente(cliente);
        return cuentas;
    }

    public int eliminarCuentaDAO(Cuenta cuenta) {
        int numRegistrosEliminados = 0;
        try {

            String qryDelete = "DELETE FROM cuentas WHERE c_cuenta = ? AND c_cliente = ?";
            PreparedStatement ps;
            ps = conexion.prepareStatement(qryDelete);
            ps.setInt(1, cuenta.getC_cuenta());
            ps.setInt(2, cuenta.getCliente().getC_cliente());
            numRegistrosEliminados = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO: handle exception

        } catch (Exception e) {
            // TODO: handle exception
        }
        return numRegistrosEliminados;
    }

}
