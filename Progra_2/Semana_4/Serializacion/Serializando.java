package Semana_4.Serializacion;

import java.io.*;

public class Serializando {

    public static void main(String[] args) {
        Administrador jefe = new Administrador("William", 30550, 2016, 1, 25);
        jefe.setIncentivo(4550);
        Empleado[] personal = new Empleado[3];
        personal[0] = jefe;
        personal[1] = new Empleado("Kevin", 1850, 2017, 0, 3);
        personal[2] = new Empleado("Walter", 25350, 2018, 2, 10);

        try {
            // Creamos el objeto de escritura
            ObjectOutputStream escribirFichero = new ObjectOutputStream(new FilterOutputStream
                    (new java.io.FileOutputStream("Empleados.txt")));
            escribirFichero.writeObject(personal); // Escribimos el objeto en el fichero
            escribirFichero.close(); // Cerramos el fichero

            // Se obtiene el objeto de lectura
            ObjectInputStream leerFichero = new ObjectInputStream(new java.io.FileInputStream("Empleados.txt"));
            Empleado[] empleados = (Empleado[]) leerFichero.readObject(); // Leemos el objeto
            leerFichero.close(); // Cerramos el fichero

            for (Empleado empleado : empleados) { // Recorremos el array
                System.out.println(empleado); // Imprimimos el objeto
            }
        } catch (Exception e) { // Capturamos la excepción en caso de que no se pueda leer o escribir

        }
    }
}

