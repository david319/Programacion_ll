package Semana_3.Trabajo_clase;

public final class EmpleadoPorHora extends Empleado{

    private int horas;

    // Constructor
    public EmpleadoPorHora(int codigo, String name, int horas){
        super(codigo, name);
        this.horas = horas;
    }

    public void setHoras(int horas){
        this.horas = horas;
    }

    public int getHoras(){
        return horas;
    }

    public double pagar(){
        double monto = horas*150;
        horas =0;
        return monto;
    }

    public double bono(){
        if(horas > 400){
            return 1000;
        } else {
            return 0;
        }
    }

    public void quienSoy(){
        System.out.println("Soy un empleado por hora");
    }
}
