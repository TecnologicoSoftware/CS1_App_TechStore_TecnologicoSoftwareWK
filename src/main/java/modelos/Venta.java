package modelos;

import abstractos.Producto;
import enums.EstadoVenta;
import interfaces.MetodoPago;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class Venta {

    private String id;
    private Date fecha;
    private Cliente cliente;
    private EstadoVenta estado;
    private List<ItemVenta> items;
    private MetodoPago metodoPago;
    private int puntosCanjeados;
    private String cajero;
    private String codigoLicencia;

    public Venta(String cajero) {
        this.id = "FACT-" + ((int)(Math.random() * 9000) + 1000);
        this.fecha = new Date();
        this.estado = EstadoVenta.EN_PROCESO;
        this.items = new ArrayList<>();
        this.cajero = cajero;
        this.codigoLicencia = "LIC-" + ((int)(Math.random() * 9000) + 1000);
    }
    
    private String generarCodigoLicencia() {
        return "LIC" + (int)(Math.random() * 1000);
    }

    public void agregarItem(Producto producto, int cantidad) {
        if (producto instanceof ProductoFisico) {
            ProductoFisico p = (ProductoFisico) producto;
            if (!p.tieneStockSuficiente(cantidad)) {
                return;
            }
            // REDUCIR stock inmediatamente
            p.reducirStock(cantidad);
        }
        ItemVenta item = new ItemVenta(producto, cantidad);
        items.add(item);
    }
    
    public void imprimirFactura() {
        System.out.println("=== FACTURA TECHSTORE ===");
        System.out.println("Factura: " + id);
        System.out.println("Fecha: " + new Date());
        System.out.println("Cajero: " + cajero);
        System.out.println("Cliente: " + (cliente != null ? cliente.getNombre() : "Consumidor Final"));
        System.out.println("-------------------------");

        // Productos
        for (ItemVenta item : items) {
            System.out.println(item.getProducto().getNombre() + " - $" + item.getPrecioUnitario() + " x" + item.getCantidad());
        }

        System.out.println("-------------------------");
        System.out.println("Subtotal: $" + calcularSubtotal());
        System.out.println("Descuento: $" + (calcularDescuentoCliente() + getDescuentoPorPuntos()));
        System.out.println("IVA: $" + calcularIVA());
        System.out.println("TOTAL: $" + calcularTotal());

        // Licencias para servicios
        for (ItemVenta item : items) {
            if (item.getProducto() instanceof ServicioDigital) {
                System.out.println("Licencia " + item.getProducto().getNombre() + ": " + codigoLicencia);
            }
        }

        System.out.println("=========================");
    }

    public void agregarMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public boolean procesarPago() {
        double total = calcularTotal();

        if (total < 1000) return false;
        if (metodoPago == null) return false;
        if (!metodoPago.validar()) return false;
        if (!metodoPago.procesarPago(total)) return false;
        
        if (!asignarTecnicosAServicios()) {
            return false;
        }

        if (cliente != null) {
            cliente.aumentarCompras();
            cliente.acumularPuntos(total);
        }

        estado = EstadoVenta.PAGADA;
        
        imprimirFactura();
        
        return true;
    }
    
    public String getCajero() {
        return cajero;
    }
    
    public String getCodigoLicencia() {
        return codigoLicencia;
    }
    
    private boolean asignarTecnicosAServicios() {
        for (ItemVenta item : items) {
            if (item.getProducto() instanceof ServicioDigital) {
                ServicioDigital servicio = (ServicioDigital) item.getProducto();

                if (!servicio.asignarTecnicoDisponible(new ArrayList<>())) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private List<Tecnico> obtenerTecnicosDisponibles() {
        return new ArrayList<>();
    }

    public void eliminarItem(int index) {
        if (index >= 0 && index < items.size()) {
            ItemVenta item = items.get(index);

            if (item.getProducto() instanceof ProductoFisico) {
                ProductoFisico p = (ProductoFisico) item.getProducto();
                p.aumentarStock(item.getCantidad());
            }

            items.remove(index);
        }
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        for (int i = 0; i < items.size(); i++) {
            subtotal += items.get(i).calcularSubtotal();
        }
        return subtotal;
    }

    public double calcularDescuentoCliente() {
        double descuento = 0;
        if (cliente != null) {
            descuento += cliente.calcularDescuentoFidelidad();
        }
        return descuento;
    }
    
    public double calcularDescuentoPorPuntos(int puntosACanjear) {
        if (cliente != null && cliente.canjearPuntosPorDescuento(puntosACanjear)) {
            this.puntosCanjeados = puntosACanjear;
            return (puntosACanjear / 100) * 10.0; // 100 puntos = $10
        }
        return 0;
    }

    public double getDescuentoPorPuntos() {
        return (puntosCanjeados / 100) * 10.0;
    }

    public double calcularIVA() {
        double subtotal = calcularSubtotal();
        double descuentoCliente = calcularDescuentoCliente();
        double descuentoPuntos = getDescuentoPorPuntos();
        double baseImponible = subtotal - descuentoCliente - descuentoPuntos;
        return baseImponible * 0.19;
    }

    public double calcularTotal() {
        double subtotal = calcularSubtotal();
        double descuentoCliente = calcularDescuentoCliente();
        double descuentoPuntos = getDescuentoPorPuntos();
        double baseImponible = subtotal - descuentoCliente - descuentoPuntos;
        double iva = baseImponible * 0.19;
        return baseImponible + iva;
    }

    public boolean procesarVenta() {
        return procesarPago();
    }
    
    public void marcarComoEntregada() {
        if (estado == EstadoVenta.PAGADA) {
            estado = EstadoVenta.ENTREGADA;
        }
    }

    public boolean puedeSerEntregada() {
        return estado == EstadoVenta.PAGADA;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EstadoVenta getEstado() {
        return estado;
    }

    public List<ItemVenta> getItems() {
        return items;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
}
