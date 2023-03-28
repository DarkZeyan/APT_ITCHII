
import LibreriaFecha.Fecha;
import LibreriaFecha.excepciones.DiaInvalido;
import LibreriaPersona.Persona;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge Eduardo Escobar Bugarini - ISC 21550317
 */
public class Ventana extends javax.swing.JFrame {
    
    Persona p;

    public Ventana() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlePnl = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        AppPnl = new javax.swing.JPanel();
        nombreLbl = new javax.swing.JLabel();
        paternoLbl = new javax.swing.JLabel();
        maternoLbl = new javax.swing.JLabel();
        sexoLbl = new javax.swing.JLabel();
        edoLbl = new javax.swing.JLabel();
        celLbl = new javax.swing.JLabel();
        fechaLbl = new javax.swing.JLabel();
        diaLbl = new javax.swing.JLabel();
        mesLbl = new javax.swing.JLabel();
        añoLbl = new javax.swing.JLabel();
        nombreTxt = new javax.swing.JTextField();
        paternoTxt = new javax.swing.JTextField();
        maternoTxt = new javax.swing.JTextField();
        sexoTxt = new javax.swing.JTextField();
        edoTxt = new javax.swing.JTextField();
        celularTxt = new javax.swing.JTextField();
        diaTxt = new javax.swing.JTextField();
        mesTxt = new javax.swing.JTextField();
        añoTxt = new javax.swing.JTextField();
        curpLbl = new javax.swing.JLabel();
        curpTxt = new javax.swing.JTextField();
        btnRegistrarPersona = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        infoTxtArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 153, 255));

        titlePnl.setBackground(new java.awt.Color(51, 204, 255));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Registrar persona");

        javax.swing.GroupLayout titlePnlLayout = new javax.swing.GroupLayout(titlePnl);
        titlePnl.setLayout(titlePnlLayout);
        titlePnlLayout.setHorizontalGroup(
            titlePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePnlLayout.createSequentialGroup()
                .addContainerGap(222, Short.MAX_VALUE)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(193, 193, 193))
        );
        titlePnlLayout.setVerticalGroup(
            titlePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        getContentPane().add(titlePnl, java.awt.BorderLayout.PAGE_START);

        AppPnl.setBackground(new java.awt.Color(0, 204, 255));

        nombreLbl.setForeground(new java.awt.Color(255, 255, 255));
        nombreLbl.setText("Nombre");

        paternoLbl.setForeground(new java.awt.Color(255, 255, 255));
        paternoLbl.setText("Apellido Paterno");

        maternoLbl.setForeground(new java.awt.Color(255, 255, 255));
        maternoLbl.setText("Apellido Materno");

        sexoLbl.setForeground(new java.awt.Color(255, 255, 255));
        sexoLbl.setText("Sexo");

        edoLbl.setForeground(new java.awt.Color(255, 255, 255));
        edoLbl.setText("Entidad Federativa");

        celLbl.setForeground(new java.awt.Color(255, 255, 255));
        celLbl.setText("Celular");

        fechaLbl.setForeground(new java.awt.Color(255, 255, 255));
        fechaLbl.setText("Fecha de Nacimiento");

        diaLbl.setForeground(new java.awt.Color(255, 255, 255));
        diaLbl.setText("Dia");

        mesLbl.setForeground(new java.awt.Color(255, 255, 255));
        mesLbl.setText("Mes");

        añoLbl.setForeground(new java.awt.Color(255, 255, 255));
        añoLbl.setText("Año");

        maternoTxt.setToolTipText("");

        curpLbl.setForeground(new java.awt.Color(255, 255, 255));
        curpLbl.setText("CURP");

        btnRegistrarPersona.setBackground(new java.awt.Color(51, 102, 255));
        btnRegistrarPersona.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegistrarPersona.setText("Registrar persona");
        btnRegistrarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPersonaActionPerformed(evt);
            }
        });

        infoTxtArea.setColumns(20);
        infoTxtArea.setRows(5);
        jScrollPane1.setViewportView(infoTxtArea);

        javax.swing.GroupLayout AppPnlLayout = new javax.swing.GroupLayout(AppPnl);
        AppPnl.setLayout(AppPnlLayout);
        AppPnlLayout.setHorizontalGroup(
            AppPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AppPnlLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(AppPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(paternoLbl, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AppPnlLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(sexoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AppPnlLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(maternoLbl))
                    .addComponent(edoLbl, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AppPnlLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(celLbl)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AppPnlLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(nombreLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(AppPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(celularTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(sexoTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nombreTxt)
                    .addComponent(paternoTxt)
                    .addComponent(maternoTxt)
                    .addComponent(edoTxt, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(AppPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AppPnlLayout.createSequentialGroup()
                        .addGroup(AppPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(añoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mesLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(diaLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(AppPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(diaTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(mesTxt)
                            .addComponent(añoTxt))
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AppPnlLayout.createSequentialGroup()
                        .addComponent(curpLbl)
                        .addGap(18, 18, 18)
                        .addComponent(curpTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AppPnlLayout.createSequentialGroup()
                        .addComponent(fechaLbl)
                        .addGap(117, 117, 117))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AppPnlLayout.createSequentialGroup()
                        .addComponent(btnRegistrarPersona)
                        .addGap(65, 65, 65))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AppPnlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );
        AppPnlLayout.setVerticalGroup(
            AppPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AppPnlLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(AppPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLbl)
                    .addComponent(fechaLbl)
                    .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(AppPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AppPnlLayout.createSequentialGroup()
                        .addGroup(AppPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(paternoLbl)
                            .addComponent(paternoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(AppPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maternoLbl)
                            .addComponent(maternoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(AppPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sexoLbl)
                            .addComponent(sexoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(AppPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edoLbl)
                            .addComponent(edoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(AppPnlLayout.createSequentialGroup()
                        .addGroup(AppPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(diaLbl)
                            .addComponent(diaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(AppPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mesLbl)
                            .addComponent(mesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(AppPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(añoLbl)
                            .addComponent(añoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(AppPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(curpLbl)
                            .addComponent(curpTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(AppPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AppPnlLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(AppPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(celLbl)
                            .addComponent(celularTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(AppPnlLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnRegistrarPersona)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        getContentPane().add(AppPnl, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPersonaActionPerformed
        try{
            String nombre = nombreTxt.getText().toUpperCase();
            String paterno=paternoTxt.getText().toUpperCase();
            String materno=maternoTxt.getText().toUpperCase();
            String celular=celularTxt.getText().toUpperCase();
            String curp=curpTxt.getText().toUpperCase();
            String edo=edoTxt.getText().toUpperCase();
            char sexo=sexoTxt.getText().toUpperCase().charAt(0);
            int dia = Integer.parseInt(diaTxt.getText());
            int mes = Integer.parseInt(mesTxt.getText());
            int año = Integer.parseInt(añoTxt.getText());
            try{
                Fecha f = new Fecha(dia,mes,año);
                p = new Persona(curp,paterno,materno,nombre,celular,f,edo,sexo);
                JOptionPane.showMessageDialog(this,"Persona registrada con exito");
                String txt =  "Nombre: "+p.getNombre()+"\nCURP: "+p.getCurp();
                infoTxtArea.setText(txt);
            }catch(DiaInvalido e){
                 JOptionPane.showMessageDialog(this,e.getMessage());
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_btnRegistrarPersonaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AppPnl;
    private javax.swing.JLabel añoLbl;
    private javax.swing.JTextField añoTxt;
    private javax.swing.JButton btnRegistrarPersona;
    private javax.swing.JLabel celLbl;
    private javax.swing.JTextField celularTxt;
    private javax.swing.JLabel curpLbl;
    private javax.swing.JTextField curpTxt;
    private javax.swing.JLabel diaLbl;
    private javax.swing.JTextField diaTxt;
    private javax.swing.JLabel edoLbl;
    private javax.swing.JTextField edoTxt;
    private javax.swing.JLabel fechaLbl;
    private javax.swing.JTextArea infoTxtArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel maternoLbl;
    private javax.swing.JTextField maternoTxt;
    private javax.swing.JLabel mesLbl;
    private javax.swing.JTextField mesTxt;
    private javax.swing.JLabel nombreLbl;
    private javax.swing.JTextField nombreTxt;
    private javax.swing.JLabel paternoLbl;
    private javax.swing.JTextField paternoTxt;
    private javax.swing.JLabel sexoLbl;
    private javax.swing.JTextField sexoTxt;
    private javax.swing.JPanel titlePnl;
    // End of variables declaration//GEN-END:variables
}
