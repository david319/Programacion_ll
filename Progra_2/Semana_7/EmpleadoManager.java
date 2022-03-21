package Semana_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Date;

public class EmpleadoManager {

    private static RandomAccessFile rCods;
    private static RandomAccessFile eEmps;

    public EmpleadoManager() throws IOException {
        // Asegurar que exista un folder
        File f = new File("Company");
        File eDir = new File("Company/Empleados");
        f.mkdir();
        eDir.mkdir();
        // Instanciar los archivos binarios RAFs dentro del folder Company
        rCods = new RandomAccessFile("Company/codigo.emp", "rw");
        eEmps = new RandomAccessFile("Company/empleado.emp", "rw");
        // Inicializar el archivo de códigos
        initCodes();
    }

    private void initCodes() throws IOException {
        if (rCods.length() == 0) {
            rCods.writeInt(1);
        } else {
            rCods.seek(0);
            rCods.writeInt(rCods.readInt() + 1);
        }
    }

    private static int getNextCode() throws IOException {
        rCods.seek(0);
        int code = rCods.readInt();
        rCods.seek(0);
        rCods.writeInt(code + 1);
        return code;
    }

    // Estructura Archivo
    // int Código
    // String Nombre
    // double Salario
    // Fecha contratación
    // Fecha despido
    public static void addEmpleado(String name, double salary) throws IOException {
        if (eEmps.length() == 0) {
            int code = getNextCode();
            eEmps.writeInt(getNextCode());
            eEmps.writeUTF(name);
            eEmps.writeDouble(salary);
            eEmps.writeLong(Calendar.getInstance().getTimeInMillis());
            eEmps.writeLong(0);
            createEmployeeFolder(code);
        } else {
            eEmps.seek(eEmps.length());
            int code = getNextCode();
            eEmps.writeInt(code);
            eEmps.writeUTF(name);
            eEmps.writeDouble(salary);
            eEmps.writeLong(Calendar.getInstance().getTimeInMillis());
            eEmps.writeLong(0);
            createEmployeeFolder(code);
        }
    }

    // Crear su archivo individual
    private static String employeeFolder(int code) {
        return "Company/Empleados/" + code;
    }

    private static void createEmployeeFolder(int code) throws IOException {
        File eDir = new File(employeeFolder(code));
        eDir.mkdir();
        // Crear los archivos de ventas del empleado
        createYearSalesFor(code);
    }

    // Crear los archivos de datos del empleado
    private static RandomAccessFile salesFile(int code) throws FileNotFoundException {
        String dirPadre = employeeFolder(code);
        int yearActual = Calendar.getInstance().get(Calendar.YEAR);
        return new RandomAccessFile(dirPadre + "/ventas" + yearActual + ".dat", "rw");
    }

    // Estructura Archivo
    // double Ventas
    // boolean estado
    private static void createYearSalesFor(int code) throws IOException {
        RandomAccessFile rYear = salesFile(code);
        if (rYear.length() == 0) {
            for (int i = 0; i < 12; i++) {
                rYear.writeDouble(0);
                rYear.writeBoolean(false);
            }
        }
    }

    // Lista de empleados
    public static void listEmployee() throws IOException {
        eEmps.seek(0);
        while (eEmps.getFilePointer() < eEmps.length()) {
            int code = eEmps.readInt();
            String name = eEmps.readUTF();
            double salary = eEmps.readDouble();
            Date date = new Date(eEmps.readLong());
            if (eEmps.readLong() == 0) {
                System.out.println("Code: " + code + " Name: " + name + " Salary: " + salary + " Lps." +
                        " Date of contract: " + date);
            }
        }
    }

    private static boolean isEmployeeActive(int code) throws IOException { // Verificar si el empleado está activo
        eEmps.seek(0); // Posicionarse en el inicio del archivo
        while (eEmps.getFilePointer() < eEmps.length()) { // Mientras no llegue al final del archivo
            int c = eEmps.readInt(); // Leer el código
            long pos = eEmps.getFilePointer(); // Posición actual
            eEmps.readUTF(); // Leer el nombre
            eEmps.skipBytes(16); // Saltar los 16 bytes de salario y fecha de contratación
            if (eEmps.readLong() == 0 && c == code) { // Si el empleado está activo
                eEmps.seek(pos); // Posicionarse en la posición del empleado
                return true; // Retornar verdadero
            }
        }
        return false; // Retornar falso
    }

    public static boolean fireEmployee(int code) throws IOException {
        if (isEmployeeActive(code)) { // Si el empleado está activo
            String name = eEmps.readUTF(); // Leer el nombre
            eEmps.skipBytes(16); // Saltar los 16 bytes de salario y fecha de contratación
            eEmps.writeLong(new Date().getTime()); // Escribir la fecha de despido
            System.out.println("The employee " + name + " has been fired."); // Mensaje de despedido
            return true; // Retornar verdadero
        }
        return false; // Retornar falso
    }

    // Añadir ventas al empleado dependiendo del mes y año actual
    public static void addSales(int code, double ventas) throws IOException {
        if (isEmployeeActive(code)) { // Si el empleado está activo
            RandomAccessFile rYear = salesFile(code); // Crear el archivo de ventas del empleado
            rYear.seek(0); // Posicionarse en el inicio del archivo
            int month = Calendar.getInstance().get(Calendar.MONTH) * 9; // Obtener el mes actual
            rYear.seek(month); // Posicionarse en el mes actual
            double sales = rYear.readDouble() + ventas; // Leer las ventas del mes actual
            rYear.seek(month); // Posicionarse en el mes actual
            rYear.writeDouble(sales); // Escribir las ventas del mes actual
        }
    }

    // Pagar al empleado
    public static boolean isPaid(int code) throws IOException {
        if (isEmployeeActive(code)) { // Si el empleado está activo
            salesFile(code).seek(0); // Posicionarse en el inicio del archivo
            int month = Calendar.getInstance().get(Calendar.MONTH) * 9; // Obtener el mes actual
            salesFile(code).seek(month); // Posicionarse en el mes actual
            salesFile(code).readDouble(); // Leer las ventas del mes actual
            // Si el empleado ya pagó el mes actual
            return salesFile(code).readBoolean(); // Retornar verdadero
        }
        return false; // Retornar falso
    }

    // Recibos de pago del empleado
    public static void receipts(int code) throws IOException {
        if (isEmployeeActive(code)) { // Si el empleado está activo
            long datePay = Calendar.getInstance().getTimeInMillis(); // Obtener la fecha actual
            int yearActual = Calendar.getInstance().get(Calendar.YEAR); // Obtener el año actual
            int monthActual = Calendar.getInstance().get(Calendar.MONTH); // Obtener el mes actual
            salesFile(code).seek(0); // Posicionarse en el inicio del archivo
            int month = Calendar.getInstance().get(Calendar.MONTH) * 9; // Obtener el mes actual
            salesFile(code).seek(month); // Posicionarse en el mes actual
            double sales = salesFile(code).readDouble(); // Leer las ventas del mes actual
            if (sales >= 0) { // Si el empleado tiene ventas
                salesFile(code).seek(month); // Posicionarse en el mes actual
                salesFile(code).readDouble(); // Leer las ventas del mes actual
                salesFile(code).writeBoolean(true); // Escribir que el empleado ya pagó
                eEmps.seek(0); // Posicionarse en el inicio del archivo
                while (eEmps.getFilePointer() < eEmps.length()) { // Mientras no llegue al final del archivo
                    eEmps.readInt(); // Leer el código
                    long pos = eEmps.getFilePointer(); // Posición actual
                    eEmps.readUTF(); // Leer el nombre
                    double salary = eEmps.readDouble(); // Leer el salario
                    eEmps.skipBytes(8); // Saltar los 8 bytes de fecha de contratación
                    eEmps.seek(pos); // Posicionarse en la posición del empleado
                    double commission = sales * 0.10; // Calcular la comisión
                    double deduced = sales * 0.035; // Calcular el descuento
                    eEmps.writeDouble(salary + commission); // Escribir el salario actualizado
                    System.out.printf("""
                            Fecha de pago: %d
                            Saldo: %f.02
                            Deducción: %f.02
                            Año: %d
                            Mes: %d""", datePay, salary, deduced, yearActual, monthActual); // Mensaje de pago
                }
            }
        }
    }

    private RandomAccessFile billsFileFor(int code) throws IOException {
        String dirPadre = employeeFolder(code); // Obtener la ruta del directorio padre
        String path = dirPadre + "/bills.emp"; // Obtener la ruta del archivo
        return new RandomAccessFile(path, "rw"); // Retornar el archivo
    }

    public boolean isEmployeePaid(int code) throws IOException {
        RandomAccessFile sale = billsFileFor(code); // Obtener el archivo de ventas
        int pos = Calendar.getInstance().get(Calendar.MONTH) * 9; // Obtener la posición del mes actual
        sale.seek(pos); // Posicionarse en el mes actual
        sale.skipBytes(8); // Saltar los 8 bytes de la fecha
        return sale.readBoolean(); // Retornar si se le pagó el mes actual
    }

    public void payEmployee(int code) throws IOException {
        double salary = 0; // Salario
        if (isEmployeeActive(code) && !isEmployeePaid(code)) { // Si el empleado está activo y no se le pagó el mes actual
            RandomAccessFile sale = salesFile(code); // Obtener el archivo de ventas
            int year = Calendar.getInstance().get(Calendar.YEAR); // Obtener el año actual
            int month = Calendar.getInstance().get(Calendar.MONTH); // Obtener el mes actual
            int pos = month * 9; // Obtener la posición del mes actual
            sale.seek(pos); // Posicionarse en el mes actual
            String name = eEmps.readUTF(); // Leer el nombre
            salary = eEmps.readDouble(); // Leer el salario
            double ventas = sale.readDouble(); // Leer las ventas del mes actual
            double salaryWithCommission = salary + (ventas * 0.10); // Calcular el salario con la comisión
            double deduced = salary * 0.035; // Calcular el descuento
            double total = salaryWithCommission - deduced; // Calcular el total

            RandomAccessFile bills = billsFileFor(code); // Obtener el archivo de facturas
            bills.seek(bills.length()); // Posicionarse en el mes actual
            bills.writeLong(Calendar.getInstance().getTimeInMillis()); // Escribir la fecha de pago
            bills.writeDouble(salaryWithCommission); // Escribir el total
            bills.writeDouble(deduced); // Escribir el descuento
            bills.writeInt(year); // Escribir el año
            bills.writeInt(month); // Escribir el mes

            sale.writeBoolean(true); // Escribir que el empleado ya pagó el mes actual
            System.out.println("Empleado " + name + " se le pago Lps. " + total + " al mes de " + month + " del año " + year); // Mensaje de pago
        } else {
            System.out.println("No se le puede pagar al empleado"); // Mensaje de error
        }
    }

}

