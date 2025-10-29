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
        return validar() && montoTransferido >= monto;
    }

    @Override
    public boolean validar() {
        return numeroReferencia != null && !numeroReferencia.trim().isEmpty()
                && banco != null && !banco.trim().isEmpty()
                && montoTransferido > 0;
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
