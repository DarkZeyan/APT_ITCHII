/*
JORGE EDUARDO ESCOBAR BUGARINI - ISC - 21550317
 */
package com.controller;

import com.model.LogicaCliente;
import com.model.LogicaCuenta;
import com.model.LogicaMovimiento;
import com.model.LogicaTarjeta;
import com.views.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class Screen extends javax.swing.JFrame {

    /**
     * Creates new form Screen
     */
    private JPanel dashboard;

    public JPanel getDashboard() {
        return dashboard;
    }

    public void setDashboard(JPanel dashboard) {
        this.dashboard = dashboard;
    }

    public Screen() {
        dashboard = new JPanel();
        dashboard.setSize(970, 548);
        initComponents();
        setIconImage(new ImageIcon("src/com/img/Bancony.png").getImage());
        setLocationRelativeTo(null);
        setTitle("Bancony");
        this.add(dashboard);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 970, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 548, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Screen screen = new Screen();
                JPanel dashboard = screen.getDashboard();

                ClientesActivos clientesActivos = new ClientesActivos();
                ClientesInactivos clientesInactivos = new ClientesInactivos();
                CuentasCliente cuentasCliente = new CuentasCliente();
                Login login = new Login();
                Movimientos movimientos = new Movimientos();
                Principal principal = new Principal();
                RegistrarCliente registrarCliente = new RegistrarCliente();
                RegistrarCuenta registrarCuenta = new RegistrarCuenta();
                RegistrarTarjeta registrarTarjeta = new RegistrarTarjeta();
                TablaTarjetas tablaTarjetas = new TablaTarjetas();
                LogicaCliente logicaCliente = new LogicaCliente();
                LogicaTarjeta logicaTarjeta = new LogicaTarjeta();
                LogicaMovimiento logicaMovimiento = new LogicaMovimiento();
                LogicaCuenta logicaCuenta = new LogicaCuenta();
                
                Controller controller = new Controller(clientesActivos, clientesInactivos, cuentasCliente, login, movimientos, principal, registrarCliente, registrarTarjeta, tablaTarjetas, screen, logicaCliente, logicaTarjeta, logicaMovimiento, logicaCuenta, registrarCuenta);

                clientesActivos.setController(controller);
                clientesInactivos.setController(controller);
                cuentasCliente.setController(controller);
                login.setController(controller);
                movimientos.setController(controller);
                principal.setController(controller);
                registrarCliente.setController(controller);
                registrarCuenta.setController(controller);
                registrarTarjeta.setController(controller);
                tablaTarjetas.setController(controller);
                logicaCliente.setController(controller);
                logicaCuenta.setController(controller);
                logicaMovimiento.setController(controller);
                logicaTarjeta.setController(controller);
                dashboard.setLayout(null);
                controller.mostrarLogin();

                screen.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
