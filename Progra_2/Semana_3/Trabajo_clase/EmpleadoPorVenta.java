package Semana_3.Trabajo_clase;

import java.util.Calendar;

public class EmpleadoPorVenta extends EmpleadoComun {

    private final double[] ventas;
    private double tasa;

    // Constructor
    public EmpleadoPorVenta(int code, String name, double saldo){
        super(code,name,saldo);
        ventas = new double[12];
        tasa = 0.01;
    }

    private int mesActual(){
        Calendar fecha = Calendar.getInstance();
        return fecha.get(Calendar.MONTH);
    }

    public void agregarVenta(double ventas){
        this.ventas[mesActual()] += ventas;
    }

    public double comision(){
        return ventas[mesActual()] * tasa;
    }

    public String toString(){
        return super.toString() + "\nComisión: " + comision();
    }

    public void increaseIncome(){
        if(tasa < 0.2){
            tasa += 0.01;
        }
    }

    public void quienSoy(){
        System.out.println("Soy un empleado de ventas por comisión");
    }

}
