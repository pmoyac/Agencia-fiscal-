package interfaz;

import interfaces.ILicenciasDAO;
import interfaces.IPlacasDAO;
import daos.LicenciasDAO;
import daos.PlacasDAO;
import entidadesJPA.Licencia;
import entidadesJPA.Persona;
import entidadesJPA.Placa;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que representa una interfaz gráfica para mostrar el historial de licencias y placas de un persona.
 * Permite visualizar la información de las licencias y placas asociadas a una persona seleccionada.
 * @author Adriana
 */
public class formHistorial extends javax.swing.JFrame {
    private final Persona personaSeleccionada;
    private final ILicenciasDAO licenciaDAO = new LicenciasDAO();
    private final IPlacasDAO placaDAO = new PlacasDAO();

    /**
     * Constructor de la clase formHistorial.
     * Inicializa la interfaz gráfica y muestra el historial de licencias y placas asociadas a la persona seleccionada.
     * @param persona La persona seleccionada para mostrar su historial.
     */
    public formHistorial(Persona persona) {
        initComponents();
        this.personaSeleccionada = persona;
        
        if (personaSeleccionada != null) {
            txtPersona.setText(personaSeleccionada.getNombres() + " " 
                    + personaSeleccionada.getApellido_paterno() + " " 
                    + personaSeleccionada.getApellido_materno());
        }      
        insertarLicencias();
        insertarPlacas();
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
        txtPersona = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLicencias = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPlacas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Módulo de consultas - Historial");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(196, 68, 89));

        jLabel1.setFont(new java.awt.Font("Candara", 1, 55)); // NOI18N
        jLabel1.setText("Módulo de consultas");
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
                .addGap(299, 299, 299))
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

        jLabel2.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel2.setText("Historial de");

        txtPersona.setBackground(new java.awt.Color(210, 106, 123));
        txtPersona.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        txtPersona.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPersona.setBorder(null);
        txtPersona.setEnabled(false);
        txtPersona.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtPersona.setSelectionColor(new java.awt.Color(0, 0, 0));
        txtPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPersonaActionPerformed(evt);
            }
        });

        tablaLicencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Costo", "Estado", "Fecha", "Vigencia"
            }
        ));
        jScrollPane1.setViewportView(tablaLicencias);

        tablaPlacas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No. placa", "Costo", "Estado","No. serie auto"
            }
        ));
        jScrollPane2.setViewportView(tablaPlacas);

        jLabel3.setFont(new java.awt.Font("Candara", 1, 20)); // NOI18N
        jLabel3.setText("Licencias");

        jLabel4.setFont(new java.awt.Font("Candara", 1, 20)); // NOI18N
        jLabel4.setText("Placas");

        btnRegresar.setFont(new java.awt.Font("Candara", 1, 22)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPersona)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegresar)
                .addGap(17, 17, 17))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 120, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                        .addComponent(jScrollPane2)))
                .addGap(120, 120, 120))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegresar))
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 700, 430));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método para insertar las licencias asociadas a la persona seleccionada en la tabla de licencias.
     */
    public void insertarLicencias() {
        DefaultTableModel model = (DefaultTableModel) tablaLicencias.getModel();
        model.setRowCount(0); 

        List<Licencia> licencias = licenciaDAO.obtenerLicencias(personaSeleccionada);

        if (licencias != null && !licencias.isEmpty()) {
            for (Licencia licencia : licencias) {
                model.addRow(new Object[]{
                    licencia.getCosto(),
                    licencia.getEstado(),
                    licencia.getFecha(),
                    licencia.getVigencia()
                });
            }
        }
    }
    
    /**
     * Método para insertar las placas asociadas a la persona seleccionada en la tabla de placas.
     */
    public void insertarPlacas() {
        DefaultTableModel model = (DefaultTableModel) tablaPlacas.getModel();
        model.setRowCount(0);

        List<Placa> placas = placaDAO.obtenerPlacas(personaSeleccionada);

        if (placas != null && !placas.isEmpty()) {
            for (Placa placa : placas) {
                model.addRow(new Object[]{
                    placa.getNo_placa(),
                    placa.getCosto(),
                    placa.getEstado(),
                    placa.getNoSerieAuto()
                });
            }
        }
    }
    
    /**
     * Método para manejar el evento de clic en el botón "Regresar".
     * Cierra este formulario y abre el formulario de consulta de personas.
     * @param evt El evento de acción que desencadena este método.
     */
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        formConsultaPersonas consultaP = new formConsultaPersonas();
        consultaP.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPersonaActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaLicencias;
    private javax.swing.JTable tablaPlacas;
    private javax.swing.JTextField txtPersona;
    // End of variables declaration//GEN-END:variables
}
