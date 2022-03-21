package Semana_3.Trabajo_clase;

import java.util.Calendar;

public abstract class Empleado {

    // Variables

    protected int codigo;
    protected String nombre;
    protected Calendar contratacion;

    // Constructor
    public Empleado(int codigo, String nombre){
        this.codigo = codigo;
        this.nombre = nombre;
        contratacion = Calendar.getInstance();
    }

    // Getters
    public final int getCodigo() {
        return codigo;
    }

    public final String getNombre() {
        return nombre;
    }

    public final Calendar getContratacion() {
        return contratacion;
    }

    // Setter
    public final void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Metodos
    public abstract double pagar();
    public abstract double bono();

    public void quienSoy(){
        System.out.println("Soy un empleado");
    }

    // Metodo toString
    public String toString(){
        return "Código: "+codigo+"\nNombre: "+nombre+"\nContratación: "+contratacion.getTime();
    }

}
