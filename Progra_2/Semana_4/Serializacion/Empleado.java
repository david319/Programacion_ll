package Semana_4.Serializacion;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

// Clase Empleado que implementa Serializable
// Serializable es una interfaz que obliga a que una clase sea serializable
// Y si no se implementa Serializable no se puede serializar
class Empleado implements Serializable {
    String name;
    double sueldo;
    Date fechaContrato;

    public Empleado(String name, double sueldo, int year, int mes, int dia) {
        this.name = name;
        this.sueldo = sueldo;
        Calendar contrato = Calendar.getInstance();
        contrato.set(year, mes, dia);
        fechaContrato = contrato.getTime();
    }

    public double getSueldo() {
        return sueldo;
    }

    public String toString() {
        return "Nombre = " + name + " ,sueldo = " + sueldo + " , fecha de contrato: " + fechaContrato;
    }

}
