package formularios;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelos.SistemaTechStore;

public class MenuPrincipalForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuPrincipalForm.class.getName());
    private SistemaTechStore sistema;
    
    
    public MenuPrincipalForm(SistemaTechStore sistema) {
        this.sistema = sistema;
        initComponents();
        cargarImagenes();
        setTitle("Menú de Opciones");
        
        //Cargar Imagen Tech Store
        Image iconoTechStore = sistema.cargarIconoTechStore();
        this.setIconImage(iconoTechStore);
    }
    
    public void cargarImagenes() {
        //Icono de Ventas
        try {
            ImageIcon icono = new ImageIcon("src/main/java/imagenes/ventas.png");

            Image image = icono.getImage();
            Image newimg = image.getScaledInstance(lblImageVentas1.getWidth(), lblImageVentas1.getHeight(), Image.SCALE_SMOOTH);
            icono = new ImageIcon(newimg);

            lblImageVentas1.setIcon(icono);
            System.out.println("Imagen cargada exitosamente");
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }
        
        //Icono de Inventario
        try {
            ImageIcon icono = new ImageIcon("src/main/java/imagenes/inventario.png");

            Image image = icono.getImage();
            Image newimg = image.getScaledInstance(lblImageVentas1.getWidth(), lblImageVentas1.getHeight(), Image.SCALE_SMOOTH);
            icono = new ImageIcon(newimg);

            lblImageInventario1.setIcon(icono);
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }
        
        //Icono de Clientes
        try {
            ImageIcon icono = new ImageIcon("src/main/java/imagenes/clientes.png");

            Image image = icono.getImage();
            Image newimg = image.getScaledInstance(lblImageVentas1.getWidth(), lblImageVentas1.getHeight(), Image.SCALE_SMOOTH);
            icono = new ImageIcon(newimg);

            lblImageClientes1.setIcon(icono);
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }
        
        //Icono de Tecnicos
        try {
            ImageIcon icono = new ImageIcon("src/main/java/imagenes/tecnicos.png");

            Image image = icono.getImage();
            Image newimg = image.getScaledInstance(lblImagenTecnicos.getWidth(), lblImagenTecnicos.getHeight(), Image.SCALE_SMOOTH);
            icono = new ImageIcon(newimg);

            lblImagenTecnicos.setIcon(icono);
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }
        
        //Icono de Reportes
        try {
            ImageIcon icono = new ImageIcon("src/main/java/imagenes/reportes.png");

            Image image = icono.getImage();
            Image newimg = image.getScaledInstance(lblImageVentas1.getWidth(), lblImageVentas1.getHeight(), Image.SCALE_SMOOTH);
            icono = new ImageIcon(newimg);

            lblImageReportes.setIcon(icono);
            System.out.println("Imagen cargada exitosamente");

        } catch (Exception e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnVentas = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblImageReportes = new javax.swing.JLabel();
        lblImageVentas1 = new javax.swing.JLabel();
        lblImageInventario1 = new javax.swing.JLabel();
        lblImageClientes1 = new javax.swing.JLabel();
        btnTecnicos = new javax.swing.JButton();
        lblImagenTecnicos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Menú Principal");

        btnVentas.setText("Ir a Ventas");
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        btnInventario.setText("Ir a Inventario");
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });

        btnCliente.setText("Ir a Clientes");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        btnReportes.setText("Ir a Reportes");
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        btnSalir.setText("Cerrer Sesión");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblImageReportes.setMaximumSize(new java.awt.Dimension(512, 512));

        lblImageVentas1.setMaximumSize(new java.awt.Dimension(512, 512));
        lblImageVentas1.setPreferredSize(new java.awt.Dimension(50, 50));

        lblImageInventario1.setMaximumSize(new java.awt.Dimension(512, 512));

        lblImageClientes1.setMaximumSize(new java.awt.Dimension(512, 512));

        btnTecnicos.setText("Ir a Técnicos");
        btnTecnicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTecnicosActionPerformed(evt);
            }
        });

        lblImagenTecnicos.setMaximumSize(new java.awt.Dimension(512, 512));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVentas)
                    .addComponent(lblImageVentas1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(btnInventario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                        .addComponent(lblImageInventario1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblImageClientes1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSalir)
                .addGap(134, 134, 134)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTecnicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblImagenTecnicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(112, 112, 112)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblImageReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(121, 121, 121))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblImageClientes1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCliente))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(btnSalir))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblImageVentas1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblImageInventario1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVentas)
                            .addComponent(btnInventario))))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblImagenTecnicos, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTecnicos))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblImageReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReportes)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        VentasForm ventasForm = new VentasForm(sistema);
        JOptionPane.showMessageDialog(this, "Abriendo el módulo de ventas");
        ventasForm.setLocationRelativeTo(null);
        ventasForm.setVisible(true);
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        InventarioForm inventarioForm = new InventarioForm(sistema);
        JOptionPane.showMessageDialog(this, "Abriendo el módulo de inventario");
        inventarioForm.setLocationRelativeTo(null);
        inventarioForm.setVisible(true);
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        ClientesForm clientesForm = new ClientesForm(sistema);
        JOptionPane.showMessageDialog(this, "Abriendo el módulo de clientes");
        clientesForm.setLocationRelativeTo(null);
        clientesForm.setVisible(true);
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        ReportesForm reportesForm = new ReportesForm(sistema);
        JOptionPane.showMessageDialog(this, "Abriendo el módulo de reportes");
        reportesForm.setLocationRelativeTo(null);
        reportesForm.setVisible(true);
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        SistemaTechStore sistema = new SistemaTechStore();
        sistema.logout();
        this.dispose();
        JOptionPane.showMessageDialog(this, "Sesión cerrada exitosamente.");
        
        LoginForm logionForm = new LoginForm(sistema);
        logionForm.setVisible(true);
        logionForm.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnTecnicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTecnicosActionPerformed
        GestionarTecnicosForm tecnicosForm = new GestionarTecnicosForm(sistema);
        JOptionPane.showMessageDialog(this, "Abriendo el módulo de gestión de técnicos");
        tecnicosForm.setLocationRelativeTo(null);
        tecnicosForm.setVisible(true);
    }//GEN-LAST:event_btnTecnicosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTecnicos;
    private javax.swing.JButton btnVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblImageClientes1;
    private javax.swing.JLabel lblImageInventario1;
    private javax.swing.JLabel lblImageReportes;
    private javax.swing.JLabel lblImageVentas1;
    private javax.swing.JLabel lblImagenTecnicos;
    // End of variables declaration//GEN-END:variables
}
