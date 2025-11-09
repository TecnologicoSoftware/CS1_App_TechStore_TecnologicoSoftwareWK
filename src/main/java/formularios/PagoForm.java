package formularios;

import java.awt.Image;
import modelos.SistemaTechStore;
import modelos.Venta;
import modelos.Efectivo;
import modelos.TarjetaCredito;
import modelos.TarjetaDebito;
import javax.swing.JOptionPane;
import modelos.TransferenciaBancaria;

public class PagoForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PagoForm.class.getName());
    private SistemaTechStore sistema;
    private VentasForm ventasFormPadre;
    private Venta ventaActual;
    
    public PagoForm(SistemaTechStore sistema, VentasForm ventasForm, Venta venta) {
        this.sistema = sistema;
        this.ventasFormPadre = ventasForm;
        this.ventaActual = venta;
        
        initComponents();
        setLocationRelativeTo(null);
        configurarMetodosPago();
        mostrarTotal();
        ocultarPaneles();
        setTitle("Pasarela de Pagos");
        
        //Cargar Imagen Tech Store
        Image iconoTechStore = sistema.cargarIconoTechStore();
        this.setIconImage(iconoTechStore);
    }
    
    private void configurarMetodosPago() {
        comboMetodoPago.removeAllItems();
        comboMetodoPago.addItem("EFECTIVO");
        comboMetodoPago.addItem("TARJETA CRÉDITO");
        comboMetodoPago.addItem("TARJETA DÉBITO");
        comboMetodoPago.addItem("TRANSFERENCIA BANCARIA");
    }
    
    private void mostrarTotal() {
        double total = ventaActual.calcularTotal();
        lblTotal.setText("Total a pagar: $" + String.format("%.2f", total));
    }
    
    private void ocultarPaneles() {
        pnlEfectivo.setVisible(false);
        pnlTarjeta.setVisible(false);
        pnlTransferencia.setVisible(false);
        lblCambio.setText("");
    }
    
    private void calcularCambio() {
        try {
            double montoRecibido = Double.parseDouble(txtMontoRecibido.getText());
            double total = ventaActual.calcularTotal();
            double cambio = montoRecibido - total;
            
            if (cambio >= 0) {
                lblCambio.setText("Cambio: $" + String.format("%.2f", cambio));
            } else {
                lblCambio.setText("Faltan: $" + String.format("%.2f", Math.abs(cambio)));
            }
        } catch (NumberFormatException e) {
            lblCambio.setText("");
        }
    }
    
    private void procesarEfectivo(double total) {
        try {
            double montoRecibido = Double.parseDouble(txtMontoRecibido.getText());
            
            if (montoRecibido < total) {
                JOptionPane.showMessageDialog(this, "El monto recibido es menor al total");
                return;
            }
            
            Efectivo efectivo = new Efectivo(montoRecibido);
            ventaActual.agregarMetodoPago(efectivo);
            
            if (ventaActual.procesarPago()) {
                JOptionPane.showMessageDialog(this, "Pago realizado con éxito\nCambio: $" + String.format("%.2f", (montoRecibido - total)));
                finalizarVenta();
            } else {
                JOptionPane.showMessageDialog(this, "Error al procesar el pago");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un monto válido");
        }
    }
    
    private void procesarTarjetaCredito(double total) {
        String numero = txtNumeroTarjeta.getText();
        String titular = txtTitular.getText();
        String cuotasTexto = txtCuotas.getText();
        
        if (numero.length() == 0 || titular.length() == 0 || cuotasTexto.length() == 0) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos de la tarjeta");
            return;
        }
        
        if (numero.length() != 16) {
            JOptionPane.showMessageDialog(this, "El número de tarjeta debe tener 16 dígitos");
            return;
        }
        
        try {
            int cuotas = Integer.parseInt(cuotasTexto);
            TarjetaCredito tarjeta = new TarjetaCredito(numero, titular, cuotas);
            ventaActual.agregarMetodoPago(tarjeta);
            
            if (ventaActual.procesarPago()) {
                JOptionPane.showMessageDialog(this, "Pago con tarjeta de crédito realizado con éxito");
                finalizarVenta();
            } else {
                JOptionPane.showMessageDialog(this, "Error al procesar el pago con tarjeta");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido de cuotas");
        }
    }
    
    private void procesarTarjetaDebito(double total) {
        String numero = txtNumeroTarjeta.getText();
        String titular = txtTitular.getText();
        
        if (numero.length() == 0 || titular.length() == 0) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos de la tarjeta");
            return;
        }
        
        if (numero.length() != 16) {
            JOptionPane.showMessageDialog(this, "El número de tarjeta debe tener 16 dígitos");
            return;
        }
        
        TarjetaDebito tarjeta = new TarjetaDebito(numero, titular);
        ventaActual.agregarMetodoPago(tarjeta);
        
        if (ventaActual.procesarPago()) {
            JOptionPane.showMessageDialog(this, "Pago con tarjeta de débito realizado con éxito");
            finalizarVenta();
        } else {
            JOptionPane.showMessageDialog(this, "Error al procesar el pago con tarjeta");
        }
    }
    
    private void finalizarVenta() {
        sistema.registrarVenta(ventaActual);
        ventasFormPadre.mostrarResumenVenta();
        ventasFormPadre.limpiarVenta();
        this.dispose();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        comboMetodoPago = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        lblCambio = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        pnlEfectivo = new javax.swing.JPanel();
        txtMontoRecibido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pnlTarjeta = new javax.swing.JPanel();
        txtNumeroTarjeta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTitular = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCuotas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pnlTransferencia = new javax.swing.JPanel();
        txtNumeroReferencia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtBanco = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMontoTransferido = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Transacción de Pago");

        comboMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboMetodoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMetodoPagoActionPerformed(evt);
            }
        });

        jLabel2.setText("Método de Pago");

        lblCambio.setText("Cambio: ");

        btnConfirmar.setText("Confirmar Pago");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblTotal.setText("Total a Pagar: ");

        jLabel3.setText("Efectivo Recibido");

        javax.swing.GroupLayout pnlEfectivoLayout = new javax.swing.GroupLayout(pnlEfectivo);
        pnlEfectivo.setLayout(pnlEfectivoLayout);
        pnlEfectivoLayout.setHorizontalGroup(
            pnlEfectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEfectivoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEfectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMontoRecibido))
                .addGap(14, 14, 14))
        );
        pnlEfectivoLayout.setVerticalGroup(
            pnlEfectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEfectivoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMontoRecibido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel4.setText("Número de Tarjeta");

        jLabel5.setText("Nombre del Titutal");

        jLabel6.setText("Cuotas");

        javax.swing.GroupLayout pnlTarjetaLayout = new javax.swing.GroupLayout(pnlTarjeta);
        pnlTarjeta.setLayout(pnlTarjetaLayout);
        pnlTarjetaLayout.setHorizontalGroup(
            pnlTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTarjetaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNumeroTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTitular)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCuotas, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlTarjetaLayout.setVerticalGroup(
            pnlTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTarjetaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTarjetaLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTarjetaLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTarjetaLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNumeroTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jLabel7.setText("Número de Referencia");

        jLabel8.setText("Banco");

        jLabel9.setText("Monto");

        javax.swing.GroupLayout pnlTransferenciaLayout = new javax.swing.GroupLayout(pnlTransferencia);
        pnlTransferencia.setLayout(pnlTransferenciaLayout);
        pnlTransferenciaLayout.setHorizontalGroup(
            pnlTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTransferenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNumeroReferencia))
                .addGap(18, 18, 18)
                .addGroup(pnlTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBanco)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMontoTransferido)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTransferenciaLayout.setVerticalGroup(
            pnlTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTransferenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlTransferenciaLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMontoTransferido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlTransferenciaLayout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlTransferenciaLayout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtNumeroReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConfirmar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblCambio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotal))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pnlEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlTransferencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(lblTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCambio)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnCancelar))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboMetodoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMetodoPagoActionPerformed
        if (comboMetodoPago.getSelectedItem() == null) {
            return;
        }

        String metodo = (String) comboMetodoPago.getSelectedItem();
        ocultarPaneles();

        if (metodo.equals("EFECTIVO")) {
            pnlEfectivo.setVisible(true);
            txtMontoRecibido.setText("");
            lblCambio.setText("");
        } else if (metodo.equals("TARJETA CRÉDITO") || metodo.equals("TARJETA DÉBITO")) {
            pnlTarjeta.setVisible(true);
            txtNumeroTarjeta.setText("");
            txtTitular.setText("");
            txtCuotas.setText("");

            // Ocultar cuotas para débito
            if (metodo.equals("TARJETA DÉBITO")) {
                txtCuotas.setVisible(false);
            } else {
                txtCuotas.setVisible(true);
            }
        }else if (metodo.equals("TRANSFERENCIA BANCARIA")) {
            pnlTransferencia.setVisible(true);
            txtNumeroReferencia.setText("");
            txtBanco.setText("");
            txtMontoTransferido.setText("");
        }
    }//GEN-LAST:event_comboMetodoPagoActionPerformed

    private void procesarTransferencia(double total) {
        String referencia = txtNumeroReferencia.getText();
        String banco = txtBanco.getText();
        String montoTexto = txtMontoTransferido.getText();

        if (referencia.isEmpty() || banco.isEmpty() || montoTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos de la transferencia");
            return;
        }

        try {
            double montoTransferido = Double.parseDouble(montoTexto);
            if (montoTransferido < total) {
                JOptionPane.showMessageDialog(this, "El monto transferido es menor al total");
                return;
            }

            TransferenciaBancaria transferencia = new TransferenciaBancaria(referencia, banco, montoTransferido);
            ventaActual.agregarMetodoPago(transferencia);

            if (ventaActual.procesarPago()) {
                JOptionPane.showMessageDialog(this, "Pago por transferencia realizado con éxito");
                finalizarVenta();
            } else {
                JOptionPane.showMessageDialog(this, "Error al procesar la transferencia");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un monto válido");
        }
    }
    
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        String metodo = (String) comboMetodoPago.getSelectedItem();
        double total = ventaActual.calcularTotal();
        
        if (metodo.equals("EFECTIVO")) {
            procesarEfectivo(total);
        } else if (metodo.equals("TARJETA CRÉDITO")) {
            procesarTarjetaCredito(total);
        } else if (metodo.equals("TARJETA DÉBITO")) {
            procesarTarjetaDebito(total);
        } else if (metodo.equals("TRANSFERENCIA BANCARIA")) {
            procesarTransferencia(total);
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox<String> comboMetodoPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblCambio;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlEfectivo;
    private javax.swing.JPanel pnlTarjeta;
    private javax.swing.JPanel pnlTransferencia;
    private javax.swing.JTextField txtBanco;
    private javax.swing.JTextField txtCuotas;
    private javax.swing.JTextField txtMontoRecibido;
    private javax.swing.JTextField txtMontoTransferido;
    private javax.swing.JTextField txtNumeroReferencia;
    private javax.swing.JTextField txtNumeroTarjeta;
    private javax.swing.JTextField txtTitular;
    // End of variables declaration//GEN-END:variables
}
