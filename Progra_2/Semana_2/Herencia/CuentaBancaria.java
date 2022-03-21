package Semana_2.Herencia;

import java.util.Calendar;

public class CuentaBancaria {

    // Variables
    protected int numero;
    protected String cliente;
    protected double saldo;
    protected double tasa;
    protected Calendar creacion;

    // Constructor
    public CuentaBancaria(int numero, String cliente, double tasa){
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 500;
        this.tasa = tasa;
        this.creacion = Calendar.getInstance();
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return tasa;
    }

    public void setSaldo(double tasa) {
        this.tasa = tasa;
    }

    public double getTasa() {
        return tasa;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public Calendar getCreacion() {
        return creacion;
    }

    public void setCreacion(Calendar creacion) {
        this.creacion = creacion;
    }

    public boolean retirar(double monto){
        if(saldo > monto){
            saldo -= monto;
            return true;
        }
        return false;
    }

    public void depositar(double monto){
        if (monto > 0){
            saldo += monto;
        } else {
            System.out.println("Error, monto invalido!");
        }
    }

    public String toString(){
        return "Numero: " + numero + "\nCliente: " + cliente + " Saldo: " + saldo + " Tasa: " + tasa;
    }



}
