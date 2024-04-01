/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author adria
 */
public class formSolicitarPlacas extends javax.swing.JFrame {

    /**
     * Creates new form formSolicitarPlacas
     */
    public formSolicitarPlacas() {
        initComponents();
        
        tablaCostosPlacas.getTableHeader().setFont(new Font("Candara", Font.BOLD, 20));
        tablaCostosPlacas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        ajustarAlturaFilas(tablaCostosPlacas);
    }

    private void ajustarAlturaFilas(JTable table) {
        for (int row = 0; row < table.getRowCount(); row++) {
            int rowHeight = table.getRowHeight();

            for (int column = 0; column < table.getColumnCount(); column++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
            }

            table.setRowHeight(row, rowHeight);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelRound1 = new presentacion.PanelRound();
        btnNuevo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnUsado = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCostosPlacas = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Solicitar placas");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(196, 68, 89));

        jLabel1.setFont(new java.awt.Font("Candara", 1, 55)); // NOI18N
        jLabel1.setText("Módulo de placas");
        jLabel1.setToolTipText("");
        jLabel1.setAlignmentY(0.0F);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(266, 266, 266))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 70));

        jPanel2.setBackground(new java.awt.Color(210, 106, 123));

        jLabel2.setFont(new java.awt.Font("Candara", 1, 30)); // NOI18N
        jLabel2.setText("Solicitar placas");

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(40);
        panelRound1.setRoundBottomRight(40);
        panelRound1.setRoundTopLeft(40);
        panelRound1.setRoundTopRight(40);

        btnNuevo.setFont(new java.awt.Font("Candara", 1, 22)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Candara", 0, 26)); // NOI18N
        jLabel3.setText("Seleccione un tipo de automóvil:");

        btnUsado.setFont(new java.awt.Font("Candara", 1, 22)); // NOI18N
        btnUsado.setText("Usado");
        btnUsado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsadoActionPerformed(evt);
            }
        });

        tablaCostosPlacas.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        tablaCostosPlacas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Placas auto nuevo", "$1500"},
                {"Placas auto usado", "$1000"}
            },
            new String [] {
                "Trámite", "Costo"
            }
        ));
        jScrollPane1.setViewportView(tablaCostosPlacas);

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(btnNuevo)
                        .addGap(115, 115, 115)
                        .addComponent(btnUsado))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(0, 48, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUsado)
                    .addComponent(btnNuevo))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        btnCancelar.setFont(new java.awt.Font("Candara", 1, 22)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancelar)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(jLabel2))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(82, 82, 82)
                            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnCancelar)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 700, 430));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        formConsultarPersonaPlaca consultarPersona = new formConsultarPersonaPlaca();
        consultarPersona.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        formAutomovilNuevo autoNuevo = new formAutomovilNuevo();
        autoNuevo.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnUsadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsadoActionPerformed
        formAutomovilUsado autoUsado = new formAutomovilUsado();
        autoUsado.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnUsadoActionPerformed

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
            java.util.logging.Logger.getLogger(formSolicitarPlacas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formSolicitarPlacas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formSolicitarPlacas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formSolicitarPlacas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formSolicitarPlacas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnUsado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private presentacion.PanelRound panelRound1;
    private javax.swing.JTable tablaCostosPlacas;
    // End of variables declaration//GEN-END:variables
}
