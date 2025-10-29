package modelos;

import abstractos.Producto;

public class ItemVenta {
    private Producto producto;
    private int cantidad;

    public ItemVenta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public double calcularSubtotal() {
        if (producto instanceof ProductoFisico) {
            ProductoFisico p = (ProductoFisico) producto;
            return p.getPrecioConDescuento() * cantidad;
        } else {
            return producto.getPrecio() * cantidad;
        }
    }

    public double getPrecioUnitario() {
        if (producto instanceof ProductoFisico) {
            ProductoFisico p = (ProductoFisico) producto;
            return p.getPrecioConDescuento();
        } else {
            return producto.getPrecio();
        }
    }

    public double calcularSubtotalItem() {
        return calcularSubtotal();
    }

    // Getters
    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }
}
