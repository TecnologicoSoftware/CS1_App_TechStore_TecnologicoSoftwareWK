package formularios;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Cliente;
import modelos.SistemaTechStore;
import modelos.Venta;

public class ClientesForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ClientesForm.class.getName());
    private SistemaTechStore sistema;
    private DefaultTableModel modeloTabla;

    
    public ClientesForm(SistemaTechStore sistema) {
        this.sistema = sistema;
        initComponents();
        
        inicializarTabla();
        cargarClientes();
        setTitle("Módulo de Clientes");
        
        //Cargar Imagen Tech Store
        Image iconoTechStore = sistema.cargarIconoTechStore();
        this.setIconImage(iconoTechStore);
    }
    
    private void inicializarTabla() {
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Cédula");
        modeloTabla.addColumn("Teléfono");
        modeloTabla.addColumn("Compras");
        modeloTabla.addColumn("Puntos");
        tblClientes.setModel(modeloTabla);
    }
    
    public void cargarClientes() {
        modeloTabla.setRowCount(0);
        
        ArrayList<Cliente> clientes = (ArrayList<Cliente>) sistema.getClientes();
        
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            Object[] fila = {
                cliente.getId(),
                cliente.getNombre(),
                cliente.getCedula(),
                cliente.getTelefono(),
                cliente.getTotalCompras(),
                cliente.getPuntosFidelidad()
            };
            modeloTabla.addRow(fila);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnRegistrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Gestionar Clientes");

        jLabel3.setText("Nombre");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblClientes);

        btnRegistrar.setText("Nuevo Cliente");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar Cliente");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnHistorial.setText("Ver Historial");
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegresar)
                                .addGap(131, 131, 131)
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegistrar)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHistorial)
                        .addGap(67, 67, 67))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnRegresar))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnHistorial))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String textoBuscar = txtBuscar.getText();

        if (textoBuscar == "") {
            cargarClientes();
            return;
        }

        modeloTabla.setRowCount(0);

        ArrayList<Cliente> todosClientes = (ArrayList<Cliente>) sistema.getClientes();

        for (int i = 0; i < todosClientes.size(); i++) {
            Cliente cliente = todosClientes.get(i);
            
            boolean coincideNombre = cliente.getNombre().toLowerCase().contains(textoBuscar.toLowerCase());
            boolean coincideCedula = cliente.getCedula().contains(textoBuscar);

            if (coincideNombre || coincideCedula) {
                modeloTabla.addRow(new Object[] {
                    cliente.getId(),
                    cliente.getNombre(),
                    cliente.getCedula(),
                    cliente.getTelefono(),
                    cliente.getTotalCompras(),
                    cliente.getPuntosFidelidad()
                });
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        RegistrarClienteForm registrarForm = new RegistrarClienteForm(sistema, this);
        registrarForm.setVisible(true);
        registrarForm.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int filaSeleccionada = tblClientes.getSelectedRow();
        if (filaSeleccionada == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione un cliente para editar");
            return;
        }
        
        String idCliente = modeloTabla.getValueAt(filaSeleccionada, 0).toString();
        String nombre = modeloTabla.getValueAt(filaSeleccionada, 1).toString();
        String cedula = modeloTabla.getValueAt(filaSeleccionada, 2).toString();
        String telefono = modeloTabla.getValueAt(filaSeleccionada, 3).toString();
        
        EditarClienteForm editarForm = new EditarClienteForm(sistema, this, idCliente, nombre, cedula, telefono);
        editarForm.setVisible(true);
        editarForm.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        int filaSeleccionada = tblClientes.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente para ver historial");
            return;
        }

        String idCliente = modeloTabla.getValueAt(filaSeleccionada, 0).toString();
        String nombreCliente = modeloTabla.getValueAt(filaSeleccionada, 1).toString();

        List<Venta> ventasCliente = new ArrayList<>();
        for (Venta venta : sistema.getVentas()) {
            if (venta.getCliente() != null && venta.getCliente().getId() == idCliente) {
                ventasCliente.add(venta);
            }
        }

        if (ventasCliente == null) {
            JOptionPane.showMessageDialog(this, 
                "El cliente " + nombreCliente + " no tiene compras registradas.");
            return;
        }

        String mensaje = "Historial de " + nombreCliente + "\n\n";

        for (int i = 0; i < ventasCliente.size(); i++) {
            var venta = ventasCliente.get(i);
            mensaje += "Venta: " + (i + 1) + ": \n" + 
                        "Factura: " + venta.getId() + "\n" +
                        "Total: $" + venta.calcularTotal() + "\n" + 
                        "Fecha: " + venta.getFecha() + "\n\n";
            
        }

        JOptionPane.showMessageDialog(this, mensaje, "Historial de Compras", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnHistorialActionPerformed
    
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
