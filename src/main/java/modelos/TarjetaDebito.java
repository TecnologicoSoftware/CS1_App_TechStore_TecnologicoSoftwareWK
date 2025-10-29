package modelos;

import interfaces.MetodoPago;

public class TarjetaDebito implements MetodoPago {

    private String numero;
    private String titular;

    public TarjetaDebito(String numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }

    @Override
    public boolean procesarPago(double monto) {
        boolean resultado = validar();
        return resultado;
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
}
