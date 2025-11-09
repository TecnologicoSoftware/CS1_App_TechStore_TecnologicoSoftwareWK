package formularios;

import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.ItemVenta;
import modelos.ProductoFisico;
import modelos.ServicioDigital;
import modelos.SistemaTechStore;
import modelos.Venta;

public class ReportesForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ReportesForm.class.getName());
    private SistemaTechStore sistema;
    private DefaultTableModel modeloTabla;

    public ReportesForm(SistemaTechStore sistema) {
        this.sistema = sistema;
        initComponents();
        inicializarTabla();
        llenarTiposReporte();
        setTitle("Módulo de Reportes");
        
        //Cargar Imagen Tech Store
        Image iconoTechStore = sistema.cargarIconoTechStore();
        this.setIconImage(iconoTechStore);
    }
    
    private void inicializarTabla() {
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Fecha");
        modeloTabla.addColumn("ID Venta");
        modeloTabla.addColumn("Cliente");
        modeloTabla.addColumn("Total");
        modeloTabla.addColumn("Estado");
        tblReportes.setModel(modeloTabla);
    }
    
    private void llenarTiposReporte() {
        comboTipoReporte.removeAllItems();
        comboTipoReporte.addItem("Ventas del día por cajero");
        comboTipoReporte.addItem("Productos más vendidos");
        comboTipoReporte.addItem("Total de ventas por período");
        comboTipoReporte.addItem("Productos con stock bajo");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnGenerar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReportes = new javax.swing.JTable();
        lblTotal = new javax.swing.JLabel();
        dateDesde = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dateHasta = new com.toedter.calendar.JDateChooser();
        comboTipoReporte = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Reportes");

        btnGenerar.setText("Generar Reporte");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        tblReportes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblReportes);

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotal.setText("Total Ventas: ");

        jLabel1.setText("Fecha de Inicio");

        jLabel3.setText("Fecha de Fin");

        comboTipoReporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Tipo Reporte");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(329, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGenerar)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboTipoReporte, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(306, 306, 306))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addGap(402, 402, 402)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnRegresar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboTipoReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btnGenerar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(lblTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        String tipoReporte = (String) comboTipoReporte.getSelectedItem();
        
        switch (tipoReporte) {
            case "Ventas del día por cajero":
                generarReporteVentasDiaCajero();
                break;
            case "Productos más vendidos":
                generarReporteProductosMasVendidos();
                break;
            case "Total de ventas por período":
                generarReporteVentasPeriodo();
                break;
            case "Productos con stock bajo":
                generarReporteProductosStockBajo();
                break;
        }
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed
    
    private void generarReporteVentasDiaCajero() {
        modeloTabla.setRowCount(0);

        String[] columnas = {"Cajero", "Ventas", "Total"};
        modeloTabla.setColumnIdentifiers(columnas);

        ArrayList<Venta> ventas = (ArrayList<Venta>) sistema.getVentas();
        Date hoy = new Date();

        int totalVentasDia = 0;
        double totalGeneralDia = 0;

        for (Venta venta : ventas) {
            if (esMismoDia(venta.getFecha(), hoy)) {
                String cajero = venta.getCajero();
                double totalVenta = venta.calcularTotal();

                boolean cajeroEncontrado = false;
                for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                    if (modeloTabla.getValueAt(i, 0).equals(cajero)) {
                        int ventasActuales = (int) modeloTabla.getValueAt(i, 1);
                        double totalActual = Double.parseDouble(modeloTabla.getValueAt(i, 2).toString().replace("$", ""));

                        modeloTabla.setValueAt(ventasActuales + 1, i, 1);
                        modeloTabla.setValueAt(String.format("$%.2f", totalActual + totalVenta), i, 2);

                        cajeroEncontrado = true;
                        break;
                    }
                }

                if (!cajeroEncontrado) {
                    Object[] fila = {
                        cajero,
                        1,
                        String.format("$%.2f", totalVenta)
                    };
                    modeloTabla.addRow(fila);
                }

                totalVentasDia++;
                totalGeneralDia += totalVenta;
            }
        }

        lblTotal.setText("Ventas hoy: " + totalVentasDia + " - Total: $" + totalGeneralDia);
    }
    
    private void generarReporteProductosMasVendidos() {
        modeloTabla.setRowCount(0);

        String[] columnas = {"Producto", "Vendidos", "Total"};
        modeloTabla.setColumnIdentifiers(columnas);

        ArrayList<Venta> ventas = (ArrayList<Venta>) sistema.getVentas();
        int totalProductosDiferentes = 0;
        int totalUnidadesVendidas = 0;
        double totalGeneral = 0;

        for (Venta venta : ventas) {
            for (ItemVenta item : venta.getItems()) {
                String producto = item.getProducto().getNombre();
                int cantidad = item.getCantidad();
                double subtotal = item.calcularSubtotal();

                boolean productoEncontrado = false;
                for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                    if (modeloTabla.getValueAt(i, 0).equals(producto)) {
                        // Actualizar producto existente
                        int vendidosActuales = (int) modeloTabla.getValueAt(i, 1);
                        double totalActual = Double.parseDouble(modeloTabla.getValueAt(i, 2).toString().replace("$", ""));

                        modeloTabla.setValueAt(vendidosActuales + cantidad, i, 1);
                        modeloTabla.setValueAt(String.format("$%.2f", totalActual + subtotal), i, 2);

                        productoEncontrado = true;
                        break;
                    }
                }

                if (!productoEncontrado) {
                    Object[] fila = {
                        producto,
                        cantidad,
                        String.format("$%.2f", subtotal)
                    };
                    modeloTabla.addRow(fila);
                    totalProductosDiferentes++;
                }

                totalUnidadesVendidas += cantidad;
                totalGeneral += subtotal;
            }
        }

        lblTotal.setText("Productos: " + totalProductosDiferentes + " - Unidades: " + totalUnidadesVendidas + " - Total: $" + totalGeneral);
    }
    
    private void generarReporteVentasPeriodo() {
        modeloTabla.setRowCount(0);

        String[] columnas = {"Fecha", "Venta", "Cliente", "Total"};
        modeloTabla.setColumnIdentifiers(columnas);

        ArrayList<Venta> ventas = (ArrayList<Venta>) sistema.getVentas();
        double totalGeneral = 0;
        int totalVentas = 0;

        for (Venta venta : ventas) {
            double total = venta.calcularTotal();

            Object[] fila = {
                new SimpleDateFormat("dd/MM/yyyy").format(venta.getFecha()),
                venta.getId(),
                venta.getCliente() != null ? venta.getCliente().getNombre() : "Consumidor Final",
                String.format("$%.2f", total)
            };
            modeloTabla.addRow(fila);

            totalGeneral += total;
            totalVentas++;
        }

        lblTotal.setText("Total ventas: " + totalVentas + " - Monto: $" + totalGeneral);
    }
    
    private void generarReporteProductosStockBajo() {
        modeloTabla.setRowCount(0);

        String[] columnas = {"Producto", "Stock", "Estado"};
        modeloTabla.setColumnIdentifiers(columnas);

        ArrayList<ProductoFisico> productos = (ArrayList<ProductoFisico>) sistema.getInventario().getTodosProductos();

        int productosBajoStock = 0;
        int productosAgotados = 0;

        for (ProductoFisico producto : productos) {
            int stock = producto.getStock();

            if (stock < 5) {
                String estado = (stock == 0) ? "AGOTADO" : "BAJO";

                Object[] fila = {
                    producto.getNombre(),
                    stock,
                    estado
                };
                modeloTabla.addRow(fila);

                if (stock == 0) {
                    productosAgotados++;
                } else {
                    productosBajoStock++;
                }
            }
        }

        lblTotal.setText("Stock bajo: " + productosBajoStock + " - Agotados: " + productosAgotados);
    }
    
    private boolean esMismoDia(Date fecha1, Date fecha2) {
        // Método simplificado para comparar fechas
        return fecha1.getDate() == fecha2.getDate() && 
               fecha1.getMonth() == fecha2.getMonth() && 
               fecha1.getYear() == fecha2.getYear();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> comboTipoReporte;
    private com.toedter.calendar.JDateChooser dateDesde;
    private com.toedter.calendar.JDateChooser dateHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblReportes;
    // End of variables declaration//GEN-END:variables
}
