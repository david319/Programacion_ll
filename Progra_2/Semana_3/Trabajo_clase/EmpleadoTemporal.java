package Semana_3.Trabajo_clase;

import java.util.Calendar;

public class EmpleadoTemporal extends EmpleadoComun {

    private Calendar finContrato;

    public EmpleadoTemporal(int codigo, String nombre) {
        super(codigo, nombre,10000);
        this.finContrato = Calendar.getInstance();
    }

    public double pagar(){
        Calendar hoy = Calendar.getInstance();
        if(hoy.before(finContrato)){
            return super.pagar();
        }
        return 0;
    }

    public Calendar getFinContratos(){
        return finContrato;
    }

    public void setFinContratos(int year, int month, int day){
        Calendar fin = Calendar.getInstance();
        Calendar hoy = Calendar.getInstance();
        fin.set(year, month, day);
        if(fin.after(hoy)){
            this.finContrato.set(year, month, day);
        }
    }

    public String toString(){
        return super.toString() + " Fin de contrato: " + finContrato.getTime();
    }

    public void quienSoy(){
        System.out.println("Soy un empleado temporal");
    }

    public boolean validForIncrease(){
        return false;
    }

}
