package Semana_2.Herencia;

import java.util.Calendar;

public class CuentaAhorro extends CuentaBancaria{

    // Variables propias
    private Calendar ultimaModif;
    public static final double TASA_AHORRO = 0.03;

    public CuentaAhorro(int numero, String cliente){
        super(numero, cliente, TASA_AHORRO);
        ultimaModif = Calendar.getInstance();
    }

    public Calendar getUltimaModif(){
        return ultimaModif;
    }

    public boolean estado(){
        Calendar hoy = Calendar.getInstance();
        hoy.add(Calendar.MONTH, -6);
        return hoy.before(ultimaModif);
    }

    public String toString() {
        return super.toString() + "\nEstado: " + estado();
    }

    public boolean retirar(double monto){
        if (estado()){
            return super.retirar(monto);
        } else {
            return false;
        }
    }

    public void depositar(double monto){
        if (!estado()){
            monto -= monto * 0.1;
        } else {
            super.depositar(monto);
        }
    }

}
