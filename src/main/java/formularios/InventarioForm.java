package formularios;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.ProductoFisico;
import modelos.ServicioDigital;
import modelos.SistemaTechStore;


public class InventarioForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(InventarioForm.class.getName());
    private SistemaTechStore sistema;
    private DefaultTableModel modeloProductos;
    private DefaultTableModel modeloServicios;
    
    public InventarioForm(SistemaTechStore sistema) {
        this.sistema = sistema;
        this.setLocationRelativeTo(null);
        
        initComponents();
        inicializarTabla();
        cargarProductos();
        cargarServicios();
        setTitle("Módulo de Inventario");
        
        //Cargar Imagen Tech Store
        Image iconoTechStore = sistema.cargarIconoTechStore();
        this.setIconImage(iconoTechStore);
    }
    
    private void inicializarTabla() {
        modeloProductos = new DefaultTableModel();
        modeloProductos.addColumn("ID");
        modeloProductos.addColumn("Fecha Ingreso");
        modeloProductos.addColumn("Nombre");
        modeloProductos.addColumn("Precio");
        modeloProductos.addColumn("Cantidad");
        modeloProductos.addColumn("Categoría");
        modeloProductos.addColumn("Ubicación");
        modeloProductos.addColumn("Código Barras");
        modeloProductos.addColumn("Estado");
        tblProductos.setModel(modeloProductos);
        
        modeloServicios = new DefaultTableModel();
        modeloServicios.addColumn("ID");
        modeloServicios.addColumn("Nombre");
        modeloServicios.addColumn("Precio");
        modeloServicios.addColumn("Duración (min)");
        modeloServicios.addColumn("Descripción");
        modeloServicios.addColumn("Técnico Asignado");
        tblServicios.setModel(modeloServicios);
    }
    
    public void cargarServicios() {
        modeloServicios.setRowCount(0);

        for (int i = 0; i < sistema.getServicios().size(); i++) {
            ServicioDigital servicio = sistema.getServicios().get(i);

            String tecnico = "Sin asignar";
            if (servicio.getTecnicoAsignado() != null) {
                tecnico = servicio.getTecnicoAsignado().getNombre();
            }

            modeloServicios.addRow(new Object[]{
                servicio.getId(),
                servicio.getNombre(),
                servicio.getPrecio(),
                servicio.getDuracionMinutos(),
                servicio.getDescripcion(),
                tecnico
            });
        }
    }
    
    public void cargarProductos() {
        modeloProductos.setRowCount(0);

        List<ProductoFisico> productos = sistema.getInventario().getTodosProductos();

        for (int i = 0; i < productos.size(); i++) {
            ProductoFisico p = productos.get(i);

            modeloProductos.addRow(new Object[]{
                p.getId(),
                p.getFechaIngreso(),
                p.getNombre(), 
                p.getPrecio(),
                p.getStock(),
                p.getCategoria(),
                p.getUbicacion(),
                p.getCodigoBarras(),
                p.getEstadoStock()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtBuscarProducto = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblServicios = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnStockBajo = new javax.swing.JButton();
        btnRegregsar = new javax.swing.JButton();
        btnAgregarServicio = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnEliminarServicio = new javax.swing.JButton();
        btnEditarServicio = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtBuscarServicios = new javax.swing.JTextField();
        btnBuscarServicios = new javax.swing.JButton();
        btnAsignarTecnico = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Inventario en Bodega");

        jLabel3.setText("Buscar Producto");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblServicios.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        tblServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Precio", "Stock", "Categoría", "Codigo Barras"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblServicios);

        jLabel4.setText("Listado de Productos Físiscos");

        btnAgregar.setText("Agregar Producto F");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnStockBajo.setText("Stock Bajo");
        btnStockBajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStockBajoActionPerformed(evt);
            }
        });

        btnRegregsar.setText("Regresar");
        btnRegregsar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegregsarActionPerformed(evt);
            }
        });

        btnAgregarServicio.setText("Agregar Servicio");
        btnAgregarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarServicioActionPerformed(evt);
            }
        });

        tblProductos.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Precio", "Stock", "Categoría", "Codigo Barras"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblProductos);

        jLabel5.setText("Listado de Servicios");

        btnEliminarServicio.setText("Eliminar");
        btnEliminarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarServicioActionPerformed(evt);
            }
        });

        btnEditarServicio.setText("Editar");
        btnEditarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarServicioActionPerformed(evt);
            }
        });

        jLabel6.setText("Buscar Servicios");

        btnBuscarServicios.setText("Buscar");
        btnBuscarServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarServiciosActionPerformed(evt);
            }
        });

        btnAsignarTecnico.setText("Asignar Tecnico");
        btnAsignarTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarTecnicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegregsar)
                        .addGap(490, 490, 490)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(358, 358, 358)
                                        .addComponent(btnEliminar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnStockBajo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(421, 421, 421)
                                        .addComponent(btnAgregar)))
                                .addGap(6, 6, 6))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 855, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtBuscarServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarServicios)
                                .addGap(148, 148, 148)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAgregarServicio)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnEliminarServicio)
                                        .addGap(21, 21, 21)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAsignarTecnico)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnEditarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10))))
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegregsar)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarServicio)
                            .addComponent(btnAsignarTecnico))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditarServicio)
                            .addComponent(btnEliminarServicio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtBuscarServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscarServicios)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEliminar)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnStockBajo)
                                        .addComponent(btnEditar))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscar))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String textoBuscar = txtBuscarProducto.getText();
        
        if (textoBuscar.length() == 0) {
            cargarProductos();
            return;
        }
        
        modeloProductos.setRowCount(0);
        
        List<ProductoFisico> productos = sistema.getInventario().buscarPorNombre(textoBuscar);
        
        for (int i = 0; i < productos.size(); i++) {
            ProductoFisico producto = productos.get(i);
            Object[] fila = {
                producto.getId(),
                producto.getFechaIngreso(),
                producto.getNombre(), 
                producto.getPrecio(),
                producto.getStock(),
                producto.getCategoria(),
                producto.getUbicacion(),
                producto.getCodigoBarras(),
                producto.getEstadoStock()
            };
            modeloProductos.addRow(fila);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        AgregarProductoForm agregarProducto = new AgregarProductoForm(sistema, this);
        agregarProducto.setVisible(true);
        agregarProducto.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int filaSeleccionada = tblProductos.getSelectedRow();
        if (filaSeleccionada == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione un producto para editar");
            return;
        }

        String id = modeloProductos.getValueAt(filaSeleccionada, 0).toString();
        String nombre = modeloProductos.getValueAt(filaSeleccionada, 2).toString();
        double precio = Double.parseDouble(modeloProductos.getValueAt(filaSeleccionada, 3).toString());
        int stock = Integer.parseInt(modeloProductos.getValueAt(filaSeleccionada, 4).toString());

        EditarProductoForm editarForm = new EditarProductoForm(sistema, this, id, nombre, precio, stock);
        editarForm.setVisible(true);
        editarForm.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int filaSeleccionada = tblProductos.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para eliminar");
            return;
        }
        
        String idProducto = modeloProductos.getValueAt(filaSeleccionada, 0).toString();
        boolean eliminado = sistema.getInventario().eliminarProducto(idProducto);
        
        if (eliminado) {
            JOptionPane.showMessageDialog(this, "Producto eliminado");
            cargarProductos();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar producto");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnStockBajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStockBajoActionPerformed
        modeloProductos.setRowCount(0);
        
        List<ProductoFisico> productos = sistema.getInventario().getProductosStockBajo();
        
        for (int i = 0; i < productos.size(); i++) {
            ProductoFisico producto = productos.get(i);
            Object[] fila = {
                producto.getId(),
                producto.getFechaIngreso(),
                producto.getNombre(), 
                producto.getPrecio(),
                producto.getStock(),
                producto.getCategoria(),
                producto.getUbicacion(),
                producto.getCodigoBarras(),
                producto.getEstadoStock()
            };
            modeloProductos.addRow(fila);
        }
        
        if (productos.size() == 0) {
            JOptionPane.showMessageDialog(this, "No hay productos con stock bajo");
        }
    }//GEN-LAST:event_btnStockBajoActionPerformed

    private void btnRegregsarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegregsarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegregsarActionPerformed

    private void btnAgregarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarServicioActionPerformed
        AgregarServicioForm agregarServicio = new AgregarServicioForm(sistema, this);
        agregarServicio.setVisible(true);
        agregarServicio.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAgregarServicioActionPerformed

    private void btnEliminarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarServicioActionPerformed
        int filaSeleccionada = tblServicios.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un servicio para eliminar");
            return;
        }

        String idServicio = modeloServicios.getValueAt(filaSeleccionada, 0).toString();
        boolean eliminado = sistema.eliminarServicio(idServicio);

        if (eliminado) {
            JOptionPane.showMessageDialog(this, "Servicio eliminado");
            cargarServicios();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar servicio");
        }
    }//GEN-LAST:event_btnEliminarServicioActionPerformed

    
    private void btnEditarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarServicioActionPerformed
        int filaSeleccionada = tblServicios.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un SERVICIO para editar");
            return;
        }

        String id = modeloServicios.getValueAt(filaSeleccionada, 0).toString();
        String nombre = modeloServicios.getValueAt(filaSeleccionada, 1).toString();
        double precio = Double.parseDouble(modeloServicios.getValueAt(filaSeleccionada, 2).toString());
        int duracion = Integer.parseInt(modeloServicios.getValueAt(filaSeleccionada, 3).toString());
        String descripcion = modeloServicios.getValueAt(filaSeleccionada, 4).toString();

        EditarServicioForm editarForm = new EditarServicioForm(sistema, this, id, nombre, precio, descripcion, duracion);
        editarForm.setVisible(true);
        editarForm.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnEditarServicioActionPerformed

    private void btnBuscarServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarServiciosActionPerformed
        String textoBuscar = txtBuscarServicios.getText().toLowerCase();
    
        if (textoBuscar.isEmpty()) {
            cargarServicios();
            return;
        }

        modeloServicios.setRowCount(0);

        for (int i = 0; i < sistema.getServicios().size(); i++) {
            ServicioDigital servicio = sistema.getServicios().get(i);

            if (servicio.getNombre().toLowerCase().contains(textoBuscar) ||
                servicio.getDescripcion().toLowerCase().contains(textoBuscar)) {

                String tecnico = "Sin asignar";
                if (servicio.getTecnicoAsignado() != null) {
                    tecnico = servicio.getTecnicoAsignado().getNombre();
                }

                modeloServicios.addRow(new Object[]{
                    servicio.getId(),
                    servicio.getNombre(),
                    servicio.getPrecio(),
                    servicio.getDuracionMinutos(),
                    servicio.getDescripcion(),
                    tecnico
                });
            }
        }
    }//GEN-LAST:event_btnBuscarServiciosActionPerformed

    private void btnAsignarTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarTecnicoActionPerformed
        int filaSeleccionada = tblServicios.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un servicio de la tabla");
            return;
        }

        String idServicio = modeloServicios.getValueAt(filaSeleccionada, 0).toString();
        String nombreServicio = modeloServicios.getValueAt(filaSeleccionada, 1).toString();

        AsignarTecnicoServicioForm asignarForm = new AsignarTecnicoServicioForm(sistema, this, idServicio, nombreServicio);
        asignarForm.setVisible(true);
        asignarForm.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAsignarTecnicoActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarServicio;
    private javax.swing.JButton btnAsignarTecnico;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarServicios;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEditarServicio;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarServicio;
    private javax.swing.JButton btnRegregsar;
    private javax.swing.JButton btnStockBajo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTable tblServicios;
    private javax.swing.JTextField txtBuscarProducto;
    private javax.swing.JTextField txtBuscarServicios;
    // End of variables declaration//GEN-END:variables
}
