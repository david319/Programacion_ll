package Semana_5;

import java.util.Calendar;

public final class CuentaAhorro extends CuentaBancaria {

    // Atributos
    private static Calendar lastUpdate;
    private static boolean active;

    public CuentaAhorro(int numCuenta, String nombreC) {
        super(numCuenta, nombreC);
        this.saldo = saldo;
        lastUpdate = Calendar.getInstance();
        active = true;
    }

    public void deposito(double deposito){
        if(active){
            saldo += deposito;
        } else {
            active = true;
            double gastosAct = deposito * 0.1;
            saldo += deposito - gastosAct;
        }
        lastUpdate = Calendar.getInstance();
    }

    public boolean retiro(double retiro){
        if (!active) {
            active = true;
        }
        if(saldo >= retiro){
            saldo -= retiro;
            lastUpdate = Calendar.getInstance();
            return true;
        }
        return false;
    }

    public final void desactivar(){
        if (lastUpdate.after(Calendar.MONTH+6)){
            active = false;
        }
    }

    public String toString(){
        if (!active) {
            return super.toString() + "\nACTIVA";
        } else {
            return super.toString() + "\nDESACTIVADA";
        }
    }

}
