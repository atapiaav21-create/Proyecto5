package model;

public class Wallet {

    private double saldo;

    public Wallet() {
        this.saldo = 100000;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            return true;
        }
        return false;
    }

    public boolean retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }
}