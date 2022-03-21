package Semana_7;

import java.io.IOException;
import java.util.Scanner;

import static Semana_7.EmpleadoManager.*;

public class Empleado {

    public static void main(String[] args) throws IOException {
        Scanner leer = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("Menu de opciones");
            System.out.println("""
                    1. Iniciar EmpleadoManager
                    2. Agregar Empleado
                    3. Agregar ventas al empleado
                    4. despedir empleado
                    5. listar empleados
                    7. Pagar a empleado
                    8. Verificar si se ha pagado
                    9. Salir
                    Seleccione una opción:""");
            opcion = leer.nextInt();

            try {
                switch (opcion) {
                    case 1:
                        System.out.println("Iniciando EmpleadoManager");
                        new EmpleadoManager();
                        break;
                    case 2:
                        System.out.println("Agregar Empleado");
                        System.out.println("Ingrese el nombre del empleado:");
                        String nombre = leer.next();
                        System.out.println("Ingrese el salario del empleado:");
                        double salario = leer.nextDouble();
                        addEmpleado(nombre, salario);
                        break;
                    case 3:
                        System.out.println("Agregar ventas al empleado");
                        System.out.println("Ingrese el código del empleado:");
                        int codigo = leer.nextInt();
                        System.out.println("Ingrese el monto de ventas del empleado:");
                        double ventas = leer.nextDouble();
                        EmpleadoManager.addSales(codigo, ventas);
                        break;
                    case 4:
                        System.out.println("Despedir empleado");
                        System.out.println("Ingrese el código del empleado:");
                        codigo = leer.nextInt();
                        if (fireEmployee(codigo)) {
                            System.out.println("Empleado despedido correctamente");
                        } else {
                            System.out.println("No se pudo despedir al empleado");
                        }
                        break;
                    case 5:
                        System.out.println("Listar empleados");
                        listEmployee();
                        break;
                    case 6:
                        System.out.println("Impresión de recibo de pago");
                        System.out.println("Ingrese el código del empleado:");
                        codigo = leer.nextInt();
                        receipts(codigo);
                        break;
                    case 7:
                        System.out.println("Verificar si se ha pagado al empleado");
                        System.out.println("Ingrese el código del empleado:");
                        codigo = leer.nextInt();
                        if (isPaid(codigo)) {
                            System.out.println("Se ha pagado al empleado");
                        } else {
                            System.out.println("No se ha pagado al empleado");
                        }
                        break;
                    case 8:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no valida");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 6);
    }

}

