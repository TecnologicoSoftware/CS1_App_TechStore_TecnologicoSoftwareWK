package modelos;

import interfaces.MetodoPago;

public class Efectivo implements MetodoPago {

    private double montoRecibido;

    public Efectivo(double montoRecibido) {
        this.montoRecibido = montoRecibido;
    }

    @Override
    public boolean procesarPago(double monto) {
        if (montoRecibido >= monto) {
            return true;
        }
        return false;
    }

    @Override
    public boolean validar() {
        if (montoRecibido > 0) {
            return true;
        }
        return false;
    }

    public double calcularCambio(double total) {
        double cambio = montoRecibido - total;
        return cambio;
    }

    public double getMontoRecibido() {
        return montoRecibido;
    }
}
