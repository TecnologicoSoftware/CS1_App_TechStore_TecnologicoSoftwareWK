package modelos;

import interfaces.MetodoPago;

public class TransferenciaBancaria implements MetodoPago {

    private String numeroReferencia;
    private String banco;
    private double montoTransferido;

    public TransferenciaBancaria(String numeroReferencia, String banco, double montoTransferido) {
        this.numeroReferencia = numeroReferencia;
        this.banco = banco;
        this.montoTransferido = montoTransferido;
    }

    @Override
    public boolean procesarPago(double monto) {
        if (!validar()) {
            return false;
        }
        if (montoTransferido < monto) {
            return false;
        }
        return true;
    }


    @Override
    public boolean validar() {
        if (numeroReferencia == null || numeroReferencia.trim().isEmpty()) {
            return false;
        }
        if (banco == null || banco.trim().isEmpty()) {
            return false;
        }
        if (montoTransferido <= 0) {
            return false;
        }
        return true;
    }


    // Getters
    public String getNumeroReferencia() {
        return numeroReferencia;
    }

    public String getBanco() {
        return banco;
    }

    public double getMontoTransferido() {
        return montoTransferido;
    }
}
