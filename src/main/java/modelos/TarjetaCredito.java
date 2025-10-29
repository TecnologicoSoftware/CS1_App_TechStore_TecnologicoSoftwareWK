package modelos;

import interfaces.MetodoPago;

public class TarjetaCredito implements MetodoPago {

    private String numero;
    private String titular;
    private int cuotas;

    public TarjetaCredito(String numero, String titular, int cuotas) {
        this.numero = numero;
        this.titular = titular;
        this.cuotas = cuotas;
    }

    @Override
    public boolean procesarPago(double monto) {
        if (!validar()) {
            return false;
        }

        double recargoPorCuota = monto * 0.05;
        double recargoTotal = recargoPorCuota * (cuotas - 1);
        double totalConRecargo = monto + recargoTotal;

        return true;
    }

    @Override
    public boolean validar() {
        if (numero == null) {
            return false;
        }
        if (numero.length() != 16) {
            return false;
        }
        if (titular == null) {
            return false;
        }
        if (titular.length() == 0) {
            return false;
        }
        return true;
    }

    // Getters
    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public int getCuotas() {
        return cuotas;
    }
}
