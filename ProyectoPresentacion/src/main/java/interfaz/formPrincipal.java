package interfaz;

import daos.PersonasDAO;

/**
 * Clase que representa la interfaz principal de la aplicación "Agencia Fiscal JV".
 * Permite acceder a diferentes módulos de la aplicación, como licencias, placas, consultas y reportes.
 * También proporciona la funcionalidad de inserción de 20 personas en la base de datos.
 * @author Adriana
 */
public class formPrincipal extends javax.swing.JFrame {

    private final PersonasDAO persona = new PersonasDAO();

    /**
     * Constructor de la clase formPrincipal.
     * Inicializa la interfaz gráfica principal de la aplicación.
     */
    public formPrincipal() {
        initComponents();
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
        btnSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        panelRound1 = new presentacion.PanelRound();
        btnModuloLicencias = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnModuloPlacas = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnModuloConsultas = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnModuloReportes = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnInsersionPersonas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agencia Fiscal JV");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(196, 68, 89));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Candara", 1, 55)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agencia Fiscal JV");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 500, 64));

        btnSalir.setBackground(new java.awt.Color(196, 68, 89));
        btnSalir.setIcon(new javax.swing.ImageIcon("C:\\Users\\adria\\OneDrive\\Documentos\\GitHub\\Agencia-fiscal-\\ProyectoPresentacion\\src\\main\\java\\imagenes\\salir.png")); // NOI18N
        btnSalir.setBorderPainted(false);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setPreferredSize(new java.awt.Dimension(40, 40));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 40, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 70));

        jPanel2.setBackground(new java.awt.Color(210, 106, 123));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(40);
        panelRound1.setRoundBottomRight(40);
        panelRound1.setRoundTopLeft(40);
        panelRound1.setRoundTopRight(40);

        btnModuloLicencias.setIcon(new javax.swing.ImageIcon("C:\\Users\\adria\\OneDrive\\Documentos\\GitHub\\Agencia-fiscal-\\ProyectoPresentacion\\src\\main\\java\\imagenes\\licencia.png")); // NOI18N
        btnModuloLicencias.setBorderPainted(false);
        btnModuloLicencias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModuloLicencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModuloLicenciasActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel2.setText("Módulo de licencias");

        btnModuloPlacas.setIcon(new javax.swing.ImageIcon("C:\\Users\\adria\\OneDrive\\Documentos\\GitHub\\Agencia-fiscal-\\ProyectoPresentacion\\src\\main\\java\\imagenes\\placas.png")); // NOI18N
        btnModuloPlacas.setBorderPainted(false);
        btnModuloPlacas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModuloPlacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModuloPlacasActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel3.setText("Módulo de placas");

        btnModuloConsultas.setIcon(new javax.swing.ImageIcon("C:\\Users\\adria\\OneDrive\\Documentos\\GitHub\\Agencia-fiscal-\\ProyectoPresentacion\\src\\main\\java\\imagenes\\consultas.png")); // NOI18N
        btnModuloConsultas.setBorderPainted(false);
        btnModuloConsultas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModuloConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModuloConsultasActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel4.setText("Módulo de consultas");

        btnModuloReportes.setIcon(new javax.swing.ImageIcon("C:\\Users\\adria\\OneDrive\\Documentos\\GitHub\\Agencia-fiscal-\\ProyectoPresentacion\\src\\main\\java\\imagenes\\reportes.png")); // NOI18N
        btnModuloReportes.setBorderPainted(false);
        btnModuloReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModuloReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModuloReportesActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel5.setText("Módulo de reportes");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(btnModuloLicencias, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModuloPlacas, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(btnModuloConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addComponent(btnModuloReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(47, 47, 47))))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnModuloPlacas, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModuloLicencias, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModuloConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnModuloReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 500, 290));

        btnInsersionPersonas.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        btnInsersionPersonas.setText("Insersión de personas");
        btnInsersionPersonas.setBorderPainted(false);
        btnInsersionPersonas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsersionPersonas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInsersionPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsersionPersonasActionPerformed(evt);
            }
        });
        btnInsersionPersonas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnInsersionPersonasKeyPressed(evt);
            }
        });
        jPanel2.add(btnInsersionPersonas, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 700, 430));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método para manejar el evento de clic en el botón "Módulo de consultas".
     * Abre el formulario para consultar personas.
     * @param evt El evento de acción que desencadena este método.
     */
    private void btnModuloConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModuloConsultasActionPerformed
        formConsultaPersonas consultas = new formConsultaPersonas();
        consultas.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnModuloConsultasActionPerformed

    /**
     * Método para manejar el evento de clic en el botón "Módulo de licencias".
     * Abre el formulario para ir al módulo de licencias.
     * @param evt El evento de acción que desencadena este método.
     */
    private void btnModuloLicenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModuloLicenciasActionPerformed
        formConsultarPersonaLicencia consultarL = new formConsultarPersonaLicencia();
        consultarL.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnModuloLicenciasActionPerformed

    /**
     * Método para manejar el evento de clic en el botón "Módulo de reportes".
     * Abre el formulario para ir al módulo de reportes.
     * @param evt El evento de acción que desencadena este método.
     */
    private void btnModuloReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModuloReportesActionPerformed
        formConsultarPersonaReporte personaRep = new formConsultarPersonaReporte();
        personaRep.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnModuloReportesActionPerformed

    private void btnInsersionPersonasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnInsersionPersonasKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInsersionPersonasKeyPressed
   
    /**
     * Método para manejar el evento de clic en el botón "Módulo de placas".
     * Abre el formulario para ir al módulo de placas.
     * @param evt El evento de acción que desencadena este método.
     */
    private void btnModuloPlacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModuloPlacasActionPerformed
        formConsultarPersonaPlaca consultarP = new formConsultarPersonaPlaca();
        consultarP.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnModuloPlacasActionPerformed

    /**
     * Método para manejar el evento de clic en el botón "Inserción de personas".
     * Inserta personas en la base de datos.
     * @param evt El evento de acción que desencadena este método.
     */
    private void btnInsersionPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsersionPersonasActionPerformed
        persona.insertarPersonas();
    }//GEN-LAST:event_btnInsersionPersonasActionPerformed

    /**
     * Método para manejar el evento de clic en el botón "Salir". Cierra la
     * aplicación al llamar al método System.exit(0).
     * @param evt El evento de acción que desencadena este método.
     */
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsersionPersonas;
    private javax.swing.JButton btnModuloConsultas;
    private javax.swing.JButton btnModuloLicencias;
    private javax.swing.JButton btnModuloPlacas;
    private javax.swing.JButton btnModuloReportes;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private presentacion.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
