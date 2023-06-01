/*
 * 
 * 
 */

/**
 *
 * @author Jorge Eduardo Escobar Bugarini -  ISC  - 21550317
 */

import LibreriaFecha.*;
import LibreriaFecha.excepciones.DiaInvalido;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;


public class GeneradorFecha extends javax.swing.JPanel implements java.beans.Customizer{

    /**
     * Creates new form GeneradorFecha
     */
    
    private Fecha fechaGenerada;
    private Object bean;
    public Fecha getFechaGenerada() {
        return fechaGenerada;
    }

    public void setFechaGenerada(Fecha fechaGenerada) {
        this.fechaGenerada = fechaGenerada;
    }
    
    public GeneradorFecha() {
        initComponents();
    }
    
    private String tipoFecha;

    public String getTipoFecha() {
        return tipoFecha;
    }

    public void setTipoFecha(String tipoFecha) {
        this.tipoFecha = tipoFecha;
        lblTipoFecha.setText(tipoFecha);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDia = new javax.swing.JLabel();
        lblMes = new javax.swing.JLabel();
        lblAño = new javax.swing.JLabel();
        txtDia = new javax.swing.JTextField();
        txtAño = new javax.swing.JTextField();
        txtMes = new javax.swing.JTextField();
        lblFechaDe = new javax.swing.JLabel();
        lblTipoFecha = new javax.swing.JLabel();
        capturarBtn = new javax.swing.JButton();

        lblDia.setText("Dia");

        lblMes.setText("Mes");

        lblAño.setText("Año");

        lblFechaDe.setText("Fecha de");

        capturarBtn.setText("Capturar fecha");
        capturarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capturarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDia, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAño)
                            .addComponent(lblMes)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblFechaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipoFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMes, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(txtDia)
                            .addComponent(txtAño))
                        .addGap(0, 34, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(capturarBtn)
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblFechaDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTipoFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDia)
                    .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMes)
                    .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAño)
                    .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(capturarBtn)
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void capturarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capturarBtnActionPerformed
        try{
            int dia,mes,año;
            dia = Integer.parseInt(txtDia.getText());
            mes = Integer.parseInt(txtMes.getText());
            año =  Integer.parseInt(txtAño.getText());

            Fecha f = new Fecha(dia,mes,año);
            setFechaGenerada(f);
            JOptionPane.showMessageDialog(null,"Fecha de " +getTipoFecha().toLowerCase()+" capturada exitosamente","Exito",JOptionPane.PLAIN_MESSAGE);

        }catch (DiaInvalido | HeadlessException | NumberFormatException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_capturarBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton capturarBtn;
    private javax.swing.JLabel lblAño;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblFechaDe;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblTipoFecha;
    private javax.swing.JTextField txtAño;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtMes;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setObject(Object bean) {
        this.bean = bean;
    }
}
