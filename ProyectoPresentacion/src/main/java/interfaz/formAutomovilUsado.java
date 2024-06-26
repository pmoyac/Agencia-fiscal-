package interfaz;

import daos.AutomovilesDAO;
import interfaces.IAutomovilDAO;
import interfaces.IPersonasDAO;
import interfaces.IPlacasDAO;
import daos.PersonasDAO;
import daos.PlacasDAO;
import dto.RegistroPlacasBO;
import entidadesJPA.Automovil;
import entidadesJPA.Placa;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import negocio.IRegistroPlacasBO;

/**
 * Clase que representa un formulario para solicitar placas de automóviles usados.
 * Este formulario permite buscar y registrar placas para automóviles usados.
 * @author Adriana
 */
public class formAutomovilUsado extends javax.swing.JFrame {

    private final IAutomovilDAO autoDAO;
    String rfc;
    private final IRegistroPlacasBO registroPlacasBO;
    private final IPersonasDAO personaDAO;
    private final IPlacasDAO placasDAO;
    Placa placanueva;
    formPrincipal principal = new formPrincipal();
    
    /**
     * Constructor de la clase formAutomovilUsado.
     * Inicializa el formulario y las interfaces de acceso a datos.
     * @param rfc El RFC de la persona asociada al formulario.
     */
    public formAutomovilUsado(String rfc) {
        initComponents();
        this.placanueva = new Placa();
        this.autoDAO = new AutomovilesDAO();
        this.personaDAO = new PersonasDAO();
        this.placasDAO = new PlacasDAO();
        this.rfc = rfc;
        this.registroPlacasBO = new RegistroPlacasBO();
    }

    /**
     * Método para buscar el número de placa ingresado en el formulario.
     * Valida el formato del número de placa y muestra los detalles del automóvil si se encuentra.
     */
    private void buscarNoPlaca() {
        String noPlacas = this.txtNoPlacas.getText();
        try {
            if (!noPlacas.isEmpty()) {
                Pattern patron = Pattern.compile("[A-Z]{3}-[0-9]{3}");
                Matcher matcher = patron.matcher(noPlacas);
                if (!matcher.matches()) {
                    JOptionPane.showMessageDialog(this, "Ingrese en el siguiente formato: ABC-123.", "Formato incorrecto", JOptionPane.WARNING_MESSAGE);
                } else {
                    Placa placa = placasDAO.buscarPlaca(noPlacas);
                    if (placa != null) {
                        llenarCamposPlaca(placa);
                        placanueva = placa;
                        if (!placa.getEstado().equals("Inactivo")) {
                            btnAceptar.setEnabled(true);
                        } else {
                            btnAceptar.setEnabled(false);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "El No. de placa proporcionado no ha sido encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un numero de placas.", "Campo vacío",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al buscar la placa: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método para agregar una nueva placa al sistema.
     * Muestra un mensaje de éxito después de registrar la nueva placa.
     * @param placa La placa a agregar.
     */
    public void agregarPlaca(Placa placa) {
        try {
            if (placasDAO.validarVigencia(placa)) {
                int opcion = JOptionPane.showConfirmDialog(this,
                        "Ya cuenta con una placa activa. ¿Desea tramitar una nueva placa?",
                        "Confirmación", JOptionPane.YES_NO_OPTION);

                if (opcion == JOptionPane.NO_OPTION) {
                    principal.setVisible(true);
                    dispose();
                    return;
                }
            }

            Placa placaNueva = new Placa();
            placaNueva.setCosto(1000.00);
            placaNueva.setFecha_recepcion(Calendar.getInstance());
            placaNueva.setFecha(Calendar.getInstance());
            placaNueva.setEstado("Activa");
            placaNueva.setAutomovil(placa.getAutomovil());
            placaNueva.setTipo("Placa");
            placaNueva.setPersona(placa.getPersona());
           // placasDAO.modificarVigencia(placa);
            String numeroPlacaGenerado = registroPlacasBO.registrarPlacaBO(placaNueva, this.rfc);

            JOptionPane.showMessageDialog(this, "Nueva placa: " + numeroPlacaGenerado,
                    "Trámite de placa exitoso", JOptionPane.INFORMATION_MESSAGE);
            principal.setVisible(true);
            dispose();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al agregar la placa: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Método para llenar los campos del formulario con los detalles del automóvil asociado a una placa.
     * @param placa La placa cuyo automóvil se utilizará para llenar los campos.
     */
    private void llenarCamposPlaca(Placa placa) {
        Automovil automovil = placa.getAutomovil();
        if (automovil != null) {
            txtNoSerie.setText(automovil.getId());
            txtMarca.setText(automovil.getMarca());
            txtLinea.setText(automovil.getLinea());
            txtColor.setText(automovil.getColor());
            txtModelo.setText(automovil.getModelo());
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
        txtNoPlacas = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        panelRound2 = new presentacion.PanelRound();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNoSerie = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtLinea = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Automóvil usado - Solicitar placas");
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
                .addGap(464, 464, 464))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 70));

        jPanel2.setBackground(new java.awt.Color(210, 106, 123));

        jLabel2.setFont(new java.awt.Font("Candara", 1, 30)); // NOI18N
        jLabel2.setText("Solicitar placas");

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(40);
        panelRound1.setRoundBottomRight(40);
        panelRound1.setRoundTopLeft(40);
        panelRound1.setRoundTopRight(40);

        jLabel3.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel3.setText("No. de placas:");

        txtNoPlacas.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Candara", 1, 22)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        panelRound2.setBackground(new java.awt.Color(243, 243, 243));

        jLabel4.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel4.setText("No. de serie:");

        jLabel5.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel5.setText("Marca:");

        jLabel6.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel6.setText("Línea:");

        jLabel7.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel7.setText("Color:");

        jLabel8.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel8.setText("Modelo:");

        txtNoSerie.setBackground(new java.awt.Color(243, 243, 243));
        txtNoSerie.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        txtNoSerie.setBorder(null);
        txtNoSerie.setFocusable(false);

        txtMarca.setBackground(new java.awt.Color(243, 243, 243));
        txtMarca.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        txtMarca.setBorder(null);
        txtMarca.setEnabled(false);
        txtMarca.setFocusable(false);
        txtMarca.setSelectionColor(new java.awt.Color(0, 0, 0));

        txtLinea.setBackground(new java.awt.Color(243, 243, 243));
        txtLinea.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        txtLinea.setBorder(null);
        txtLinea.setEnabled(false);
        txtLinea.setFocusable(false);
        txtLinea.setSelectionColor(new java.awt.Color(0, 0, 0));

        txtColor.setBackground(new java.awt.Color(243, 243, 243));
        txtColor.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        txtColor.setBorder(null);
        txtColor.setEnabled(false);
        txtColor.setFocusable(false);
        txtColor.setSelectionColor(new java.awt.Color(0, 0, 0));

        txtModelo.setBackground(new java.awt.Color(243, 243, 243));
        txtModelo.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        txtModelo.setBorder(null);
        txtModelo.setEnabled(false);
        txtModelo.setFocusable(false);
        txtModelo.setSelectionColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtNoSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(62, 62, 62)
                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(50, 50, 50)
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNoSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNoPlacas, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnBuscar)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNoPlacas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnBuscar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        btnCancelar.setFont(new java.awt.Font("Candara", 1, 22)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setFont(new java.awt.Font("Candara", 1, 22)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.setEnabled(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(158, 158, 158))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 730, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //Regresa al formulario de solicitar placas
        formSolicitarPlacas solicitarP = new formSolicitarPlacas(rfc);
        solicitarP.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        //Agrega placa nueva
        agregarPlaca(placanueva);
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //Busca la placa ingresada por el usuario
        buscarNoPlaca();
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private presentacion.PanelRound panelRound1;
    private presentacion.PanelRound panelRound2;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNoPlacas;
    private javax.swing.JTextField txtNoSerie;
    // End of variables declaration//GEN-END:variables
}
