package Semana_1;

import static Semana_1.funcionesRecursivas.*;

import java.util.Scanner;

public class testFuncionesRecursivas {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("""
                                        
                    Menu interactivo
                    Opciones:
                    1. print
                    2. printMismo
                    3. sumaUp
                    4. sumaDown
                    5. potenciaUp
                    6. potenciaDown
                    7. esPalíndromo
                    8. Pirámide
                    9. Secuencia de Fibonacci
                    10. Salir
                    Seleccione una opción:""");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la cantidad de veces a sumar: ");
                    int numero = leer.nextInt();
                    print(numero);
                    break;
                case 2:
                    System.out.println("Ingrese un numero: ");
                    int numero2 = leer.nextInt();
                    System.out.println("Ingrese la cantidad de veces a imprimir el numero: ");
                    int numero3 = leer.nextInt();
                    printMismo(numero2, numero3);
                    break;
                case 3:
                    System.out.println("Ingrese un numero: ");
                    int numero4 = leer.nextInt();
                    System.out.println("El resultado es: " + sumaUp(numero4));
                    break;
                case 4:
                    System.out.println("Ingrese un numero: ");
                    int numero5 = leer.nextInt();
                    System.out.println("El resultado es: " + sumaDown(numero5));
                    break;
                case 5:
                    System.out.println("Ingrese un numero: ");
                    int numero6 = leer.nextInt();
                    System.out.println("Ingrese la potencia: ");
                    int potencia = leer.nextInt();
                    System.out.println("El resultado es: " + potenciaUp(numero6, potencia));
                    break;
                case 6:
                    System.out.println("Ingrese un numero: ");
                    int numero7 = leer.nextInt();
                    System.out.println("Ingrese la potencia: ");
                    int potencia2 = leer.nextInt();
                    System.out.println("El resultado es: " + potenciaDown(numero7, potencia2));
                    break;
                case 7:
                    System.out.println("Es palíndromo: " + esPalindromo());
                    break;
                case 8:
                    piramide();
                    break;
                case 9:
                    fibonacci();
                    break;
                case 10:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        } while (opcion != 10);
    }
}
