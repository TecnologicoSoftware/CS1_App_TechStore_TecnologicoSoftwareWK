package abstractos;

import enums.Categoria;

public abstract class Producto {

    protected String id;
    protected String nombre;
    protected double precio;
    protected Categoria categoria;
    
    public Producto(String id, String nombre, double precio, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public boolean validarPrecio() {
        if (precio < 0.01) {
            return false;
        }
        if (precio > 99999.99) {
            return false;
        }
        return true;
    }

    public boolean validarNombre() {
        if (nombre == null) {
            return false;
        }
        if (nombre.length() == 0) {
            return false;
        }
        return true;
    }

    // Getters simples
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
