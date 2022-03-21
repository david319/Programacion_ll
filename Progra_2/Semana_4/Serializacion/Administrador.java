package Semana_4.Serializacion;

class Administrador extends Empleado {
    private double incentivo;

    public Administrador(String name, double sueldo, int year, int mes, int dia) {
        super(name, sueldo, year, mes, dia);
        incentivo = 0;
    }

    public double getSueldo() {
        double sueldoBase = super.getSueldo();
        return sueldoBase + incentivo;
    }

    public void setIncentivo(double incentivo) {
        this.incentivo = incentivo;
    }

    public String toString() {
        return super.toString() + " Incentivo = " + incentivo;
    }
}
