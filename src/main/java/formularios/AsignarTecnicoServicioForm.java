package formularios;

import java.awt.Image;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.SistemaTechStore;
import modelos.Tecnico;

public class AsignarTecnicoServicioForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AsignarTecnicoServicioForm.class.getName());
    private SistemaTechStore sistema;
    private InventarioForm inventarioPadre;
    private String idServicio;
    private String nombreServicio;
    
    public AsignarTecnicoServicioForm(SistemaTechStore sistema, InventarioForm inventario, String idServicio, String nombreServicio) {
        this.sistema = sistema;
        this.inventarioPadre = inventario;
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        
        initComponents();
        setLocationRelativeTo(null);
        cargarDatos();
        setTitle("Asignar Técnicos");
        
        //Cargar Imagen Tech Store
        Image iconoTechStore = sistema.cargarIconoTechStore();
        this.setIconImage(iconoTechStore);
    }

    private void cargarDatos() {
        lblServicio.setText("Servicio: " + nombreServicio);
        lblIdServicio.setText("ID: " + idServicio);
        
        cargarTecnicosDisponibles();
    }
    
    private void cargarTecnicosDisponibles() {
        comboTecnicos.removeAllItems();
        List<Tecnico> tecnicos = sistema.getTecnicosDisponibles();
        
        if (tecnicos.isEmpty()) {
            comboTecnicos.addItem("No hay técnicos disponibles");
            comboTecnicos.setEnabled(false);
            btnAsignar.setEnabled(false);
            lblInfo.setText("No hay técnicos disponibles para asignar");
        } else {
            for (Tecnico tecnico : tecnicos) {
                comboTecnicos.addItem(tecnico.getNombre() + " - " + tecnico.getEspecialidad());
            }
            comboTecnicos.setEnabled(true);
            btnAsignar.setEnabled(true);
            lblInfo.setText("Técnicos disponibles: " + tecnicos.size());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAsignar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboTecnicos = new javax.swing.JComboBox<>();
        lblServicio = new javax.swing.JLabel();
        lblIdServicio = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        btnAsignar.setText("Asignar Técnico");
        btnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualziar Listado");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Asignar Técnicos");

        jLabel2.setText("Técnicos");

        comboTecnicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblServicio.setText("Servicio: ");

        lblIdServicio.setText("ID: ");

        lblInfo.setText("Técnicos Disponibles: ");

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(35, Short.MAX_VALUE)
                        .addComponent(btnAsignar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(lblServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegresar)
                                .addGap(60, 60, 60)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboTecnicos, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnRegresar))
                .addGap(21, 21, 21)
                .addComponent(lblServicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIdServicio)
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboTecnicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblInfo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAsignar)
                    .addComponent(btnActualizar)
                    .addComponent(btnCancelar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarActionPerformed
        if (comboTecnicos.getSelectedIndex() == -1 || comboTecnicos.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un técnico");
            return;
        }
        
        List<Tecnico> tecnicos = sistema.getTecnicosDisponibles();
        if (tecnicos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay técnicos disponibles");
            return;
        }
        
        int indexTecnico = comboTecnicos.getSelectedIndex();
        Tecnico tecnicoSeleccionado = tecnicos.get(indexTecnico);
        
        boolean asignado = sistema.asignarTecnicoAServicio(idServicio, tecnicoSeleccionado.getUsuario());

        if (asignado) {
            JOptionPane.showMessageDialog(this, "Técnico asignado correctamente");
            if (inventarioPadre != null) {
                inventarioPadre.cargarServicios();
            }
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al asignar técnico");
        }
    }//GEN-LAST:event_btnAsignarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarTecnicosDisponibles();
        JOptionPane.showMessageDialog(this, "Lista de técnicos actualizada");
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAsignar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> comboTecnicos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblIdServicio;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblServicio;
    // End of variables declaration//GEN-END:variables
}
