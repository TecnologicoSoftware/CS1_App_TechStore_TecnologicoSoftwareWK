package modelos;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<ProductoFisico> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(ProductoFisico producto) {
        if (producto.validarNombre() && producto.validarPrecio()) {
            if (existeCodigoBarras(producto.getCodigoBarras())) {
                throw new IllegalArgumentException("El código de barras ya existe");
            }
            productos.add(producto);
        }
    }

    public boolean editarProducto(String id, String nuevoNombre, double nuevoPrecio, int nuevoStock) {
        for (int i = 0; i < productos.size(); i++) {
            ProductoFisico p = productos.get(i);
            if (p.getId().equals(id)) {
                p.setNombre(nuevoNombre);
                p.setPrecio(nuevoPrecio);
                p.setStock(nuevoStock);
                return true;
            }
        }
        return false;
    }

    public List<ProductoFisico> buscarPorNombre(String nombre) {
        List<ProductoFisico> resultado = new ArrayList<>();
        for (int i = 0; i < productos.size(); i++) {
            ProductoFisico p = productos.get(i);
            if (p.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public List<ProductoFisico> getProductosStockBajo() {
        List<ProductoFisico> resultado = new ArrayList<>();
        for (int i = 0; i < productos.size(); i++) {
            ProductoFisico p = productos.get(i);
            if (p.verificarStockMinimo()) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public List<ProductoFisico> getTodosProductos() {
        return new ArrayList<>(productos);
    }

    public boolean eliminarProducto(String id) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId().equals(id)) {
                productos.remove(i);
                return true;
            }
        }
        return false;
    }

    public ProductoFisico buscarPorCodigo(String codigoBarras) {
        for (int i = 0; i < productos.size(); i++) {
            ProductoFisico p = productos.get(i);
            if (p.getCodigoBarras().equals(codigoBarras)) {
                return p;
            }
        }
        return null;
    }

    public ProductoFisico buscarPorId(String id) {
        for (int i = 0; i < productos.size(); i++) {
            ProductoFisico p = productos.get(i);
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
    
    public boolean existeCodigoBarras(String codigoBarras) {
        for (ProductoFisico producto : productos) {
            if (producto.getCodigoBarras().equals(codigoBarras)) {
                return true;
            }
        }
        return false;
    }
}