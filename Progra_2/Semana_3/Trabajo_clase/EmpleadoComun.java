package Semana_3.Trabajo_clase;

public class EmpleadoComun extends Empleado implements Empleable {

    // Atributos
    protected double salario;

    public EmpleadoComun(int codigo, String nombre, double salario) {
        super(codigo,nombre);
        this.salario = salario;
    }

    public double pagar() {
        return salario - deduct();
    }

    public double bono() {
        return 0;
    }

    public double deduct() {
        return salario * TASA_Deduccion;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean validForIncrease(){
        return true;
    }

    public void increaseIncome(){
        if (validForIncrease()) {
            salario += salario * 0.1;
        }
    }

    public String toString() {
        return super.toString() + "\nSalario: " + salario + "\n";
    }

    @Override
    public void quienSoy() {
        System.out.println("Soy un empleado común con salario");
    }

}
