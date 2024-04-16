package interfaz;

import interfaces.ILicenciasDAO;
import daos.LicenciasDAO;
import daos.PersonasDAO;
import entidadesJPA.Licencia;
import entidadesJPA.Persona;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Clase que representa una interfaz gráfica para consultar personas y solicitar placas para una persona específica.
 * Esta clase permite buscar personas por su RFC y visualizar los detalles de la persona encontrada.
 * Además, permite avanzar al formulario de solicitud de placas para la persona seleccionada, siempre y cuando tenga una licencia activa.
 * Si la persona no tiene una licencia activa, se redirige al formulario principal.
 * @author Adriana
 */
public class formConsultarPersonaPlaca extends javax.swing.JFrame {
    private final PersonasDAO persona = new PersonasDAO();
    private final ILicenciasDAO licencia = new LicenciasDAO();
    formPrincipal principal = new formPrincipal();

    /**
     * Constructor de la clase formConsultarPersonaPlaca.
     * Inicializa la interfaz gráfica y sus componentes.
     */
    public formConsultarPersonaPlaca() {
        initComponents();
    }
      
    /**
     * Método para buscar una persona en la base de datos utilizando su RFC.
     * Si se encuentra una persona con el RFC proporcionado, se muestra su información en un cuadro de diálogo.
     * Además, habilita el botón "Siguiente" y deshabilita la edición del campo de texto del RFC.
     * @param evt El evento de acción que desencadena este método.
     */
    private void buscarRFC(java.awt.event.ActionEvent evt) {
        String rfc = txtRFC.getText();

        if (rfc.length() != 13) {
            JOptionPane.showMessageDialog(this, "El RFC debe tener 13 caracteres.", "Longitud incorrecta", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            if (!rfc.isEmpty()) {
                Persona personaEncontrada = persona.buscarPersonasRFC(rfc);

                if (personaEncontrada != null) {
                    JOptionPane.showMessageDialog(this, personaEncontrada.toString(),
                            "Persona encontrada.", JOptionPane.INFORMATION_MESSAGE);
                    btnSiguiente.setEnabled(true);
                    txtRFC.setEditable(false);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un RFC.", "Campo vacío",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "El RFC proporcionado no se ha encontrado en la"
                    + " base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
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
        jLabel3 = new javax.swing.JLabel();
        txtRFC = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Módulo de placas - Consultar persona");
        setPreferredSize(null);
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
        jPanel2.setAlignmentX(0.0F);
        jPanel2.setAlignmentY(0.0F);

        jLabel2.setFont(new java.awt.Font("Candara", 1, 30)); // NOI18N
        jLabel2.setText("Consultar persona:");

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(40);
        panelRound1.setRoundBottomRight(40);
        panelRound1.setRoundTopLeft(40);
        panelRound1.setRoundTopRight(40);

        jLabel3.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel3.setText("RFC:");

        txtRFC.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        txtRFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRFCActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Candara", 1, 22)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnBuscar)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        btnSiguiente.setFont(new java.awt.Font("Candara", 1, 22)); // NOI18N
        btnSiguiente.setText("Siguiente");
        btnSiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSiguiente.setEnabled(false);
        btnSiguiente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Candara", 1, 22)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(btnSiguiente)
                        .addGap(152, 152, 152)
                        .addComponent(btnCancelar)))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSiguiente)
                    .addComponent(btnCancelar))
                .addGap(70, 70, 70))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 700, 430));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método para manejar el evento de clic en el botón "Siguiente".
     * Verifica si la persona tiene una licencia activa. Si es así, abre el formulario de solicitud de placas.
     * Si no tiene una licencia activa, muestra un mensaje de error y redirige al formulario principal.
     * @param evt El evento de acción que desencadena este método.
     */
    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        String rfc = txtRFC.getText();
        Persona personaEncontrada = persona.buscarPersonasRFC(rfc);
        
        if (rfc.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, ingrese un RFC.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            if (personaEncontrada != null) {
                boolean licenciaActiva = false;
                
                List<Licencia> licencias = licencia.obtenerLicencias(personaEncontrada);
                for (Licencia licencia : licencias) {
                    if (licencia.getEstado().equals("Activo")) {
                        licenciaActiva = true;
                        break;
                    }
                }

                if (licenciaActiva) {
                    formSolicitarPlacas placas = new formSolicitarPlacas(rfc);
                    placas.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this,
                            "La persona ingresada no cuenta con una licencia activa.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                     principal.setVisible(true);
                     dispose();   
                }
            } 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Ha ocurrido un error al verificar la licencia.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    /**
     * Método para manejar el evento de clic en el botón "Cancelar".
     * Cierra este formulario y abre el formulario principal.
     * @param evt El evento de acción que desencadena este método.
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        principal.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtRFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRFCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRFCActionPerformed

    /**
     * Método para manejar el evento de clic en el botón "Buscar".
     * Llama al método buscarRFC para realizar la búsqueda de una persona utilizando el RFC ingresado.
     * @param evt El evento de acción que desencadena este método.
     */
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarRFC(evt);
    }//GEN-LAST:event_btnBuscarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private presentacion.PanelRound panelRound1;
    private javax.swing.JTextField txtRFC;
    // End of variables declaration//GEN-END:variables
}
