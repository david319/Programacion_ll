package Semana_5;

public abstract class CuentaBancaria {

    // Atributos
    protected int numCuenta;
    protected String nombreC;
    protected double saldo;

    // Constructor
    public CuentaBancaria(int numCuenta, String nombreC) {
        this.numCuenta = numCuenta;
        this.nombreC = nombreC;
        this.saldo = 500;
    }

    public void deposito(double deposito) {
        saldo += deposito;
    }

    public double getNumCuenta() {
        return numCuenta;
    }

    public abstract boolean retiro(double retiro);

    public String toString(){
        return "Numero de cuenta: " + numCuenta + "\nNombre del cliente: " + nombreC + "\nSaldo: " + saldo;
    }

    public double getSaldo() {
        return saldo;
    }
}
