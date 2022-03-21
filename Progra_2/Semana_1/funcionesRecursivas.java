package Semana_1;

import java.util.Scanner;

public class funcionesRecursivas {

    private static final Scanner leer = new Scanner(System.in);

    public static void print(int n) { // n es el número de elementos de la serie
        if (n > 1)
            print(n - 1);
        System.out.print(n + " ");
    }

    public static void printMismo(int n, int repetir) {

        if (repetir > 0) {
            System.out.print(n + " ");
            printMismo(n, repetir - 1);
        }
    }

    public static int sumaUp(int n) {
        if (n >= 1) {
            System.out.println(n);
            return sumaUp(n - 1) + n;
        }
        return 0;
    }

    public static int sumaDown(int n) {
        return sumaDown(n, 0);
    }

    private static int sumaDown(int n, int acumulador) {
        if (n >= 1) {
            System.out.println(n);
            return sumaDown(n - 1, acumulador + n);
        }
        return acumulador;
    }

    public static int potenciaUp(int base, int exp) {
        if (exp > 0) {
            System.out.println(base);
            return potenciaUp(base, exp - 1) * base;
        }
        return 1;
    }

    public static int potenciaDown(int base, int exp) {
        return potenciaDown(base, exp, 1);
    }

    private static int potenciaDown(int base, int exp, int acumulador) {
        if (exp > 0) {
            System.out.println(base);
            return potenciaDown(base, exp - 1, acumulador * base);
        }
        return acumulador;
    }

    public static boolean esPalindromo() {
        System.out.println("Introduzca una palabra y se verificara si es palíndromo: ");
        String cadena = leer.nextLine();
        return esPalindromo(cadena, 0, cadena.length() - 1);
    }

    private static boolean esPalindromo(String cadena, int inicio, int fin) {
        if (inicio < fin) {
            if (cadena.charAt(inicio) == cadena.charAt(fin)) {
                esPalindromo(cadena, inicio + 1, fin - inicio);
                return true;
            }
            return false;
        }
        return true;
    }

    public static void piramide() {
        System.out.println("Introduzca la cantidad de veces que desea que se repita el asterisco (*):");
        int n = leer.nextInt();
        piramide(n, "*");
    }

    private static void piramide(int n, String acumulador) {  // n es el número de elementos de la serie
        if (n >= 1) {
            System.out.println(acumulador);
            piramide(--n, acumulador + "*");
        }
    }

    // Fibonacci con recursividad
    public static void fibonacci() {
        System.out.println("""
                Introduzca el número de elementos de la serie
                (el numero debe ser mayor o igual a 1):""");
        int n = leer.nextInt();

        for (int i = 0; i < n; i++) { // n es el número de elementos de la serie
            int numeroFibonacci = fibonacci(i); // i es el número de elementos de la serie
            System.out.print(numeroFibonacci + " "); // imprime el número de la serie
        }
    }

    private static int fibonacci(int n) { // n es el número de elementos de la serie
        if (n > 1) {
            return fibonacci(n - 1) + fibonacci(n - 2); //
        } else if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        } else {
            System.out.println("Error, el número debe ser mayor o igual a 1");
        }
        return 0;
    }
}
