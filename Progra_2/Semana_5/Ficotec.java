package Semana_5;

import java.util.Scanner;

import static Semana_5.Banco.*;

public class Ficotec {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        int opcion;

        System.out.println("Ficotec");
        do {
            System.out.println("""
                    1. Agregar Cuenta
                    2. Desactivar Cuenta
                    3. Aplicar Intereses
                    4. Transferir
                    Seleccione una opción:""");
            opcion = leer.nextInt();

            if (opcion == 1) {
                System.out.println("Ingrese el nombre del cliente:");
                String nombre = leer.next();
                System.out.println("Ingrese el número de cuenta:");
                int numero = leer.nextInt();
                System.out.println("Ingrese el tipo de cuenta:");
                String tipo = leer.next().toUpperCase();
                add(numero, nombre, TipoCuenta.valueOf(tipo));
            } else if (opcion == 2) {
                evalDeactivations();
            } else if (opcion == 3) {
                applyInterests();
            } else if (opcion == 4) {
                System.out.println("Ingrese el número de cuenta de origen:");
                int numeroOrigen = leer.nextInt();
                System.out.println("Ingrese el número de cuenta de destino:");
                int numeroDestino = leer.nextInt();
                System.out.println("Ingrese la cantidad a transferir:");
                double cantidad = leer.nextDouble();
                transfer(numeroOrigen, numeroDestino, cantidad);
            } else if (opcion == 5) {
                System.exit(0);
            }
        } while (opcion != 5);
    }
}
