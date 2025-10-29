package modelos;

public class Cliente {

    private String id;
    private String nombre;
    private String cedula;
    private String telefono;
    private int puntosFidelidad;
    private int totalCompras;

    public Cliente(String id, String nombre, String cedula, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.puntosFidelidad = 0;
        this.totalCompras = 0;
    }

    public double calcularDescuentoFidelidad() {
        if (totalCompras >= 6) {
            return 10.0;
        } else if (totalCompras >= 3) {
            return 5.0;
        }
        return 0.0;
    }

    public void acumularPuntos(double montoCompra) {
        int puntos = (int) (montoCompra / 10);
        puntosFidelidad = puntosFidelidad + puntos;
    }

    public boolean canjearPuntos(int puntos) {
        if (puntosFidelidad >= puntos && puntos >= 100) {
            puntosFidelidad -= puntos;
            return true;
        }
        return false;
    }
    
    public boolean canjearPuntosPorDescuento(int puntosACanjear) {
        if (puntosFidelidad >= puntosACanjear && puntosACanjear >= 100) {
            puntosFidelidad -= puntosACanjear;
            return true;
        }
        return false;
    }

    public void aumentarCompras() {
        totalCompras++;
    }

    public double getDescuentoPorPuntos() {
        int puntosCanjeables = (puntosFidelidad / 100) * 100;
        return (puntosCanjeables / 100) * 10.0; // 100 puntos = $10
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getPuntosFidelidad() {
        return puntosFidelidad;
    }

    public int getTotalCompras() {
        return totalCompras;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
