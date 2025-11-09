package formularios;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.SistemaTechStore;
import modelos.Tecnico;

public class GestionarTecnicosForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GestionarTecnicosForm.class.getName());
    private SistemaTechStore sistema;
    private DefaultTableModel modeloTecnicos;
    
    public GestionarTecnicosForm(SistemaTechStore sistema) {
        this.sistema = sistema;
        initComponents();
        setLocationRelativeTo(null);
        inicializarTabla();
        cargarTecnicos();
        setTitle("Módulo de Técnicos");
        
        //Cargar Imagen Tech Store
        Image iconoTechStore = sistema.cargarIconoTechStore();
        this.setIconImage(iconoTechStore);
    }
    
    private void inicializarTabla() {
        modeloTecnicos = new DefaultTableModel();
        modeloTecnicos.addColumn("ID");
        modeloTecnicos.addColumn("Nombre");
        modeloTecnicos.addColumn("Especialidad");
        modeloTecnicos.addColumn("Disponible");
        modeloTecnicos.addColumn("Servicios Asignados");
        tblTecnicos.setModel(modeloTecnicos);
    }
    
    private void cargarTecnicos() {
        modeloTecnicos.setRowCount(0);
        ArrayList<Tecnico> tecnicos = (ArrayList<Tecnico>) sistema.getTecnicos();
        
        for (Tecnico tecnico : tecnicos) {
            modeloTecnicos.addRow(new Object[]{
                tecnico.getUsuario(),
                tecnico.getNombre(),
                tecnico.getEspecialidad(),
                tecnico.isDisponible() ? "Sí" : "No",
                tecnico.getServiciosAsignados()
            });
        }
    }
    
    private void limpiarCampos() {
        txtNombre.setText("");
//        txtUsuario.setText("");
        txtPassword.setText("");
        txtEspecialidad.setText("");
        txtServicioAsignar.setText("");
        txtServicioLiberar.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTecnicos = new javax.swing.JTable();
        btnAgregarTecnico = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEspecialidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtServicioAsignar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtServicioLiberar = new javax.swing.JTextField();
        btnAsignarServicio = new javax.swing.JButton();
        btnLiberarTecnico = new javax.swing.JButton();
        btnRegregsar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Gestionar Técnicos");

        tblTecnicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblTecnicos);

        btnAgregarTecnico.setText("Agregar Técnico");
        btnAgregarTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTecnicoActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre");

        jLabel4.setText("Contraseña");

        jLabel5.setText("Especialidad");

        jLabel6.setText("ID Servicio Asignar");

        jLabel7.setText("ID Servicio Liberar");

        btnAsignarServicio.setText("Asignar Servicio");
        btnAsignarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarServicioActionPerformed(evt);
            }
        });

        btnLiberarTecnico.setText("Liberar Tecnico");
        btnLiberarTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLiberarTecnicoActionPerformed(evt);
            }
        });

        btnRegregsar.setText("Regresar");
        btnRegregsar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegregsarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegregsar)
                                .addGap(208, 208, 208)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(106, 106, 106)
                                        .addComponent(btnAgregarTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAsignarServicio)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtServicioAsignar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnLiberarTecnico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtServicioLiberar)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addComponent(btnRegregsar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addComponent(btnAgregarTecnico))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtServicioAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(btnAsignarServicio))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(63, 63, 63)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtServicioLiberar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(btnLiberarTecnico))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTecnicoActionPerformed
        String nombre = txtNombre.getText().trim();
//        String usuario = txtUsuario.getText().trim();
        String password = txtPassword.getText().trim();
        String especialidad = txtEspecialidad.getText().trim();
        
        if (nombre == "") {
            JOptionPane.showMessageDialog(this, "Ingrese el nombre del técnico");
            txtNombre.requestFocus();
            return;
        }
        
//        if (usuario == "") {
//            JOptionPane.showMessageDialog(this, "Ingrese el usuario del técnico");
//            txtUsuario.requestFocus();
//            return;
//        }
        
        if (password == "") {
            JOptionPane.showMessageDialog(this, "Ingrese la contraseña del técnico");
            txtPassword.requestFocus();
            return;
        }
        
        if (especialidad == "") {
            JOptionPane.showMessageDialog(this, "Ingrese la especialidad del técnico");
            txtEspecialidad.requestFocus();
            return;
        }
        
        // Verificar si el usuario ya existe
//        if (sistema.buscarTecnicoPorId(usuario) != null) {
//            JOptionPane.showMessageDialog(this, "El usuario ya existe");
//            txtUsuario.requestFocus();
//            return;
//        }
        
        String idTecnico = sistema.generarIdTecnico();
        Tecnico tecnico = new Tecnico(idTecnico, password, nombre, especialidad);
        sistema.agregarTecnico(tecnico);
        
        JOptionPane.showMessageDialog(this, "Técnico agregado correctamente");
        cargarTecnicos();
        limpiarCampos();
    }//GEN-LAST:event_btnAgregarTecnicoActionPerformed

    private void btnAsignarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarServicioActionPerformed
        int filaSeleccionada = tblTecnicos.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un técnico de la tabla");
            return;
        }
        
        String idServicio = txtServicioAsignar.getText().trim();
        if (idServicio == "") {
            JOptionPane.showMessageDialog(this, "Ingrese el ID del servicio a asignar");
            txtServicioAsignar.requestFocus();
            return;
        }
        
        String idTecnico = modeloTecnicos.getValueAt(filaSeleccionada, 0).toString();
        String nombreTecnico = modeloTecnicos.getValueAt(filaSeleccionada, 1).toString();
        
        boolean asignado = sistema.asignarTecnicoAServicio(idServicio, idTecnico);
        if (asignado) {
            JOptionPane.showMessageDialog(this, "Servicio " + idServicio + " asignado a " + nombreTecnico + " correctamente");
            cargarTecnicos();
            txtServicioAsignar.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Error al asignar servicio.");
        }
    }//GEN-LAST:event_btnAsignarServicioActionPerformed

    private void btnLiberarTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLiberarTecnicoActionPerformed
        int filaSeleccionada = tblTecnicos.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un técnico de la tabla");
            return;
        }
        
        String idServicio = txtServicioLiberar.getText().trim();
        if (idServicio.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el ID del servicio a liberar");
            txtServicioLiberar.requestFocus();
            return;
        }
        
        String idTecnico = modeloTecnicos.getValueAt(filaSeleccionada, 0).toString();
        String nombreTecnico = modeloTecnicos.getValueAt(filaSeleccionada, 1).toString();
        
        boolean liberado = sistema.liberarTecnicoDeServicio(idServicio);
        if (liberado) {
            JOptionPane.showMessageDialog(this, 
                "Técnico " + nombreTecnico + " liberado del servicio " + idServicio + " correctamente");
            cargarTecnicos();
            txtServicioLiberar.setText("");
        } else {
            JOptionPane.showMessageDialog(this, 
                "Error al liberar técnico. Verifique que el servicio exista.");
        }
    }//GEN-LAST:event_btnLiberarTecnicoActionPerformed

    private void btnRegregsarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegregsarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegregsarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarTecnico;
    private javax.swing.JButton btnAsignarServicio;
    private javax.swing.JButton btnLiberarTecnico;
    private javax.swing.JButton btnRegregsar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTecnicos;
    private javax.swing.JTextField txtEspecialidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtServicioAsignar;
    private javax.swing.JTextField txtServicioLiberar;
    // End of variables declaration//GEN-END:variables
}
