package Semana_6;

import java.io.IOException;
import java.util.Scanner;

public class testFile_LaraDavid_22141143 {

    static MiFile_LaraDavid_22141143 nf = new MiFile_LaraDavid_22141143(); // Creo un objeto de tipo MiFile
    static Scanner leer = new Scanner(System.in).useDelimiter("\n"); // Creo un objeto de tipo Scanner

    public static void main(String[] args) {
        int opcion;

        do { // Mientras la opción sea distinta de 11
            System.out.println("""
                    ********************Menu********************
                    1. Set el archivo/directorio
                    2. Ver información del archivo/directorio
                    3. Crear archivo
                    4. Crear directorio
                    5. dirCMD
                    6. Tree
                    7. Escribir en archivo
                      8. Escribir en archivo con BufferedWriter
                    9. Leer archivo
                      10 Lee archivo con BufferedReader
                    11. Salir
                    Seleccione una opción:""");
            opcion = leer.nextInt(); // Pido la opción

            try { // Inicio del try
                switch (opcion) { // Switch para las opciones del menu
                    case 1 -> set(); // Setear el archivo/directorio
                    case 2 -> nf.vistaInfo(); // Ver información del archivo/directorio
                    case 3 -> nf.createFile(); // Crear archivo
                    case 4 -> nf.createDirectory(); // Crear directorio
                    case 5 -> nf.dirCMD(); // Ver directorio Actual
                    case 6 -> nf.tree(); // Ver el árbol del directorio
                    case 7 -> { // Escribir en archivo
                        System.out.println("Append: ");
                        nf.escribir(leer.next().equalsIgnoreCase("si")); // Si es true, append
                    }
                    case 8 -> nf.escribirBuffer(); // Escribir en archivo con BufferedWriter
                    case 9 -> nf.leer(); // Leer archivo con FileReader
                    case 10 -> nf.leerBuffer(); // Leer archivo con BufferedReader
                    case 11 -> System.out.println("Saliendo..."); // Salir
                }
            } catch (IOException e) { // Se captura la excepción
                System.out.println("Error: " + e.getMessage()); // Muestro el error
            }
        } while (opcion != 11); // Condición de salida del programa
    }

    private static void set() { // Método para setear el archivo/directorio
        System.out.println("Dirección del archivo/directorio: "); // Pido la dirección
        nf.setFile(leer.next()); // Seteo la dirección
    }

}
