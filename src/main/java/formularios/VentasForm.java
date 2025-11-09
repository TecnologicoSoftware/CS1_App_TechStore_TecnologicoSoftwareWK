package formularios;

import java.awt.Image;
import modelos.SistemaTechStore;
import modelos.Venta;
import modelos.ItemVenta;
import modelos.ProductoFisico;
import modelos.Cliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.ServicioDigital;

public class VentasForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentasForm.class.getName());
    private SistemaTechStore sistema;
    private DefaultTableModel modeloProductos;
    private DefaultTableModel modeloCarrito;
    private Venta ventaActual;
    private boolean clienteEnconrtado = false;
    
    public VentasForm(SistemaTechStore sistema) {
        this.sistema = sistema;
        String cajero = sistema.getUsuarioActual().getNombre();
        this.ventaActual = new Venta(cajero);
        initComponents();
        inicializarTablas();
        cargarProductos();
        actualizarTotales();
        setTitle("Módulo de Ventas");
        
        //Cargar Imagen Tech Store
        Image iconoTechStore = sistema.cargarIconoTechStore();
        this.setIconImage(iconoTechStore);
    }
    
    public void mostrarResumenVenta() {
        String mensaje = "Venta completada exitosamente\n\n" +
                         "Factura: " + ventaActual.getId() + "\n" +
                         "Total: $" + String.format("%.2f", ventaActual.calcularTotal()) + "\n" +
                         "Cajero: " + ventaActual.getCajero();

        JOptionPane.showMessageDialog(this, mensaje, "Venta Exitosa", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    private void inicializarTablas() {
        modeloProductos = new DefaultTableModel();
        modeloProductos.addColumn("ID");
        modeloProductos.addColumn("Nombre");
        modeloProductos.addColumn("Precio");
        modeloProductos.addColumn("Stock");
        modeloProductos.addColumn("Categoría");
        modeloProductos.addColumn("Ubicación");
        modeloProductos.addColumn("Código Barras");
        modeloProductos.addColumn("Estado");
        tblProductos.setModel(modeloProductos);

        modeloCarrito = new DefaultTableModel();
        modeloCarrito.addColumn("Producto");
        modeloCarrito.addColumn("Precio");
        modeloCarrito.addColumn("Cantidad");
        modeloCarrito.addColumn("Subtotal");
        tblCarrito.setModel(modeloCarrito);
    }
    
    private void cargarProductos() {
        modeloProductos.setRowCount(0);

        ArrayList<ProductoFisico> listaProductos = (ArrayList<ProductoFisico>) sistema.getInventario().getTodosProductos();
        int totalProductos = listaProductos.size();

        for (int i = 0; i < totalProductos; i++) {
            ProductoFisico productoActual = listaProductos.get(i);

            Object[] nuevaFila = new Object[8];
            nuevaFila[0] = productoActual.getId();
            nuevaFila[1] = productoActual.getNombre();
            nuevaFila[2] = productoActual.getPrecio();
            nuevaFila[3] = productoActual.getStock();
            nuevaFila[4] = productoActual.getCategoria();
            nuevaFila[5] = productoActual.getUbicacion();
            nuevaFila[6] = productoActual.getCodigoBarras();
            nuevaFila[7] = productoActual.getEstadoStock();

            modeloProductos.addRow(nuevaFila);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscarProducto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBuscarProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        txtCantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnAgregarCarrito = new javax.swing.JButton();
        btnEliminarCarrito = new javax.swing.JButton();
        txtCedulaCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnBuscarCliente = new javax.swing.JButton();
        lblNombreCliente = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        lblDescuento = new javax.swing.JLabel();
        lblIVA = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnPagar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCarrito = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        lblTotal1 = new javax.swing.JLabel();
        txtPuntosCanjear = new javax.swing.JTextField();
        btnCanjearPuntos = new javax.swing.JButton();
        lblPuntosDisponibles = new javax.swing.JLabel();
        lblDescuentoPuntos = new javax.swing.JLabel();
        lblDescuentoPuntos1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Gestión de Ventas");

        jLabel2.setText("Buscar Producto");

        btnBuscarProducto.setText("Buscar");
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblProductos);

        jLabel3.setText("Cantidad");

        btnAgregarCarrito.setText("+ Carrito");
        btnAgregarCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCarritoActionPerformed(evt);
            }
        });

        btnEliminarCarrito.setText("- Carrito");
        btnEliminarCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCarritoActionPerformed(evt);
            }
        });

        jLabel4.setText("Cedula Cliente");

        btnBuscarCliente.setText("Buscar Cliente");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        lblNombreCliente.setText("Cliente: ");

        lblSubtotal.setText("Subtotal: ");

        lblDescuento.setText("Descuento: ");

        lblIVA.setText("IVA: ");

        lblTotal.setText("Total a Pagar: ");

        btnPagar.setText("Ir a Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        tblCarrito.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblCarrito);

        jLabel5.setText("Listado de Productos");

        jLabel6.setText("Listado del Carrito");

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        lblTotal1.setText("Puntos a Canjear");

        btnCanjearPuntos.setText("Canjear Puntos");
        btnCanjearPuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanjearPuntosActionPerformed(evt);
            }
        });

        lblPuntosDisponibles.setText("Puntos Disponibles: ");

        lblDescuentoPuntos.setText("Descuento en Puntos: ");

        lblDescuentoPuntos1.setText("Puntos a Redimir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addGap(296, 296, 296)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(btnBuscarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCedulaCliente))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(txtBuscarProducto)
                                    .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAgregarCarrito)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnEliminarCarrito))
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(lblNombreCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblDescuento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(lblPuntosDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(5, 5, 5)))
                                        .addGap(13, 13, 13)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblDescuentoPuntos1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnPagar)
                                            .addComponent(lblDescuentoPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnCanjearPuntos)
                                            .addComponent(txtPuntosCanjear, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnRegresar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombreCliente)
                            .addComponent(lblSubtotal))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDescuento)
                            .addComponent(lblIVA)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarCarrito)
                            .addComponent(btnEliminarCarrito)))
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29))
                        .addComponent(btnBuscarProducto)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCedulaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnBuscarCliente))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(lblTotal1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPuntosDisponibles)
                            .addComponent(lblDescuentoPuntos1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDescuentoPuntos)
                            .addComponent(txtPuntosCanjear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCanjearPuntos)
                            .addComponent(btnPagar))
                        .addGap(45, 45, 45)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        String textoBuscar = txtBuscarProducto.getText();

        if (textoBuscar.length() == 0) {
            cargarProductos();
            return;
        }

        modeloProductos.setRowCount(0);

        ArrayList<ProductoFisico> resultados = (ArrayList<ProductoFisico>) sistema.getInventario().buscarPorNombre(textoBuscar);

        for (int i = 0; i < resultados.size(); i++) {
            ProductoFisico producto = resultados.get(i);

            String id = producto.getId();
            String nombre = producto.getNombre();
            double precio = producto.getPrecio();
            int stock = producto.getStock();
            String categoria = producto.getCategoria().toString();

            Object[] fila = {id, nombre, precio, stock, categoria};
            modeloProductos.addRow(fila);
        }
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        String cedula = txtCedulaCliente.getText();
        if (cedula.length() == 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese una cédula");
            return;
        }
        
        Cliente cliente = sistema.buscarClientePorCedula(cedula);
        
        if (cliente != null) {
            //System.out.println("Ahhhhhh");
            ventaActual.setCliente(cliente);
            lblNombreCliente.setText("Cliente: " + cliente.getNombre());
            clienteEnconrtado = true;
            
            lblPuntosDisponibles.setText("Puntos disponibles: " + cliente.getPuntosFidelidad());
            lblPuntosDisponibles.setVisible(true);
            txtPuntosCanjear.setVisible(true);
            btnCanjearPuntos.setVisible(true);
        
            actualizarTotales();
        } else {
            //System.out.println("Nooooooo");
            javax.swing.JOptionPane.showMessageDialog(this, "Cliente no encontrado");
            lblNombreCliente.setText("No registrado");
            
            lblPuntosDisponibles.setVisible(false);
            txtPuntosCanjear.setVisible(false);
            btnCanjearPuntos.setVisible(false);
            lblDescuentoPuntos.setText("");
        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnAgregarCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCarritoActionPerformed
        int filaSeleccionada = tblProductos.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto de la lista");
            return;
        }
        
        String cantidadTexto = txtCantidad.getText();
        if (cantidadTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese la cantidad deseada");
            return;
        }

        int cantidad;
        try {
            cantidad = Integer.parseInt(cantidadTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser un número válido");
            return;
        }
        
        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a cero");
            return;
        }

        String idProducto = modeloProductos.getValueAt(filaSeleccionada, 0).toString();

        ProductoFisico producto = sistema.getInventario().buscarPorId(idProducto);

        if (producto == null) {
            JOptionPane.showMessageDialog(this, "Producto no encontrado");
            return;
        }

        if (!producto.tieneStockSuficiente(cantidad)) {
            JOptionPane.showMessageDialog(this, "Cantidad insuficiente. Disponible: " + producto.getStock());
            return;
        }

        ventaActual.agregarItem(producto, cantidad);

        actualizarCarrito();
        actualizarTotales();

        JOptionPane.showMessageDialog(this, "Producto agregado: " + producto.getNombre());
        txtCantidad.setText("");
    }//GEN-LAST:event_btnAgregarCarritoActionPerformed

    private void btnEliminarCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCarritoActionPerformed
        int filaSeleccionada = tblCarrito.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un item del carrito");
            return;
        }

        ventaActual.eliminarItem(filaSeleccionada);
        actualizarCarrito();
        actualizarTotales();

        JOptionPane.showMessageDialog(this, "Producto eliminado del carrito - Stock restaurado");
    }//GEN-LAST:event_btnEliminarCarritoActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        if(clienteEnconrtado == false) {
            JOptionPane.showMessageDialog(this, "Debes de seleccionar un cliente");
            return;
        }
        
        if (ventaActual.getItems().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El carrito está vacío");
            return;
        }
        
        if (ventaActual.calcularTotal() < 1000) {
            JOptionPane.showMessageDialog(this, "El monto mínimo de compra es $1000");
            return;
        }
        
        PagoForm pagoForm = new PagoForm(sistema, this, ventaActual);
        pagoForm.setLocationRelativeTo(null);
        pagoForm.setVisible(true);
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnCanjearPuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanjearPuntosActionPerformed
        if (ventaActual.getCliente() == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente primero");
            return;
        }

        try {
            int puntos = Integer.parseInt(txtPuntosCanjear.getText());
            Cliente cliente = ventaActual.getCliente();

            if (puntos % 100 != 0) {
                JOptionPane.showMessageDialog(this, "Los puntos deben ser múltiplos de 100 (100 puntos = $10)");
                return;
            }

            if (puntos > cliente.getPuntosFidelidad()) {
                JOptionPane.showMessageDialog(this, 
                    "Puntos insuficientes. Disponibles: " + cliente.getPuntosFidelidad());
                return;
            }

            if (puntos < 100) {
                JOptionPane.showMessageDialog(this, "Mínimo 100 puntos para canjear");
                return;
            }

            double descuento = ventaActual.calcularDescuentoPorPuntos(puntos);
            if (descuento > 0) {
                lblDescuentoPuntos.setText("Descuento por puntos: $" + descuento);

                lblPuntosDisponibles.setText("Puntos disponibles: " + cliente.getPuntosFidelidad());
                txtPuntosCanjear.setText("");

                actualizarTotales();
                JOptionPane.showMessageDialog(this, 
                    "¡Canjeo exitoso! " + puntos + " puntos = $" + descuento + " de descuento");
            } else {
                JOptionPane.showMessageDialog(this, "Error al canjear puntos");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido de puntos");
        }
    }//GEN-LAST:event_btnCanjearPuntosActionPerformed

    private void actualizarCarrito() {
        modeloCarrito.setRowCount(0);
        
        ArrayList<ItemVenta> items = (ArrayList<ItemVenta>) ventaActual.getItems();
        
        for (int i = 0; i < items.size(); i++) {
            ItemVenta item = items.get(i);
            Object[] fila = {
                item.getProducto().getNombre(),
                item.getPrecioUnitario(),
                item.getCantidad(),
                item.calcularSubtotalItem()
            };
            modeloCarrito.addRow(fila);
        }
    }
    
    private void actualizarTotales() {
        double subtotal = ventaActual.calcularSubtotal();
        double descuentoCliente = ventaActual.calcularDescuentoCliente();
        double descuentoPuntos = ventaActual.getDescuentoPorPuntos();
        double iva = ventaActual.calcularIVA();
        double total = ventaActual.calcularTotal();

        lblSubtotal.setText("Subtotal: $" + String.format("%.2f", subtotal));
        lblDescuento.setText("Descuento fidelidad: $" + String.format("%.2f", descuentoCliente));

        if (descuentoPuntos > 0) {
            lblDescuentoPuntos.setText("Descuento por puntos: $" + String.format("%.2f", descuentoPuntos));
            lblDescuentoPuntos.setVisible(true);
        } else {
            lblDescuentoPuntos.setVisible(false);
        }

        lblIVA.setText("IVA: $" + String.format("%.2f", iva));
        lblTotal.setText("Total a pagar: $" + String.format("%.2f", total));
    }
    
    public void limpiarVenta() {
        String cajero = sistema.getUsuarioActual().getNombre();
        ventaActual = new Venta(cajero); // Cambiar aquí
        lblNombreCliente.setText("No registrado");
        txtCedulaCliente.setText("");
        txtCantidad.setText("");
        txtPuntosCanjear.setText("");
        lblPuntosDisponibles.setVisible(false);
        txtPuntosCanjear.setVisible(false);
        btnCanjearPuntos.setVisible(false);
        lblDescuentoPuntos.setVisible(false);
        actualizarCarrito();
        actualizarTotales();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCarrito;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnCanjearPuntos;
    private javax.swing.JButton btnEliminarCarrito;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDescuento;
    private javax.swing.JLabel lblDescuentoPuntos;
    private javax.swing.JLabel lblDescuentoPuntos1;
    private javax.swing.JLabel lblIVA;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JLabel lblPuntosDisponibles;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotal1;
    private javax.swing.JTable tblCarrito;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtBuscarProducto;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCedulaCliente;
    private javax.swing.JTextField txtPuntosCanjear;
    // End of variables declaration//GEN-END:variables
}
