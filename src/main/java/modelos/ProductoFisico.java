package modelos;

import abstractos.Producto;
import enums.Categoria;
import java.util.Date;

public class ProductoFisico extends Producto {

    private int stock;
    private String codigoBarras;
    private String ubicacion;
    private Date fechaIngreso;
    private boolean enOferta;
    private double descuento;
    private int stockReservado;

    public ProductoFisico(String id, String nombre, double precio, Categoria categoria, String codigoBarras, String ubicacion) {
        super(id, nombre, precio, categoria);
        this.codigoBarras = codigoBarras;
        this.ubicacion = ubicacion;
        this.fechaIngreso = new Date();
        this.stock = 0;
        this.enOferta = false;
        this.descuento = 0;
    }

    public void reducirStock(int cantidad) {
        if (stock >= cantidad) {
            stock = stock - cantidad;
        }
    }

    public void aumentarStock(int cantidad) {
        stock += cantidad;
        System.out.println("Stock restaurado: " + nombre + " +" + cantidad + " unidades");
    }

    public boolean tieneStockSuficiente(int cantidad) {
        return getStockDisponible() >= cantidad;
    }

    public boolean verificarStockMinimo() {
        return stock < 5;
    }

    public double getPrecioConDescuento() {
        if (enOferta == true) {
            double descuentoCalculado = precio * descuento / 100;
            double precioFinal = precio - descuentoCalculado;
            return precioFinal;
        } else {
            return precio;
        }
    }
    
    public String getEstadoStock() {
        if (stock == 0) {
            return "AGOTADO";
        } else if (stock < 5) {
            return "STOCK BAJO";
        } else {
            return "DISPONIBLE";
        }
    }
    
    public void reservarStock(int cantidad) {
        if (stock - stockReservado >= cantidad) {
            stockReservado += cantidad;
        }
    }

    public void liberarStockReservado(int cantidad) {
        stockReservado = Math.max(0, stockReservado - cantidad);
    }

    public int getStockDisponible() {
        return stock - stockReservado;
    }
    // Getters y Setters
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public boolean isEnOferta() {
        return enOferta;
    }

    public void setEnOferta(boolean enOferta) {
        this.enOferta = enOferta;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    
    public String getUbicacion() {
        return ubicacion;
    }
    
    public Date getFechaIngreso() {
        return fechaIngreso;
    }
}
