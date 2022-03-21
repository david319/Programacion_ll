package Semana_5;

public final class CuentaPlazoFijo extends CuentaBancaria {

    // Atributos
    private double intereses;
    static final double TASA = 0.01;

    // Constructor
    public CuentaPlazoFijo(int numCuenta, String nombreC, double intereses) {
        super(numCuenta, nombreC);
        this.intereses = 0;

    }

    @Override
    public boolean retiro(double retiro) {
        if (retiro <= intereses) {
            intereses -= retiro;
            return true;
        }
        return false;
    }
}
