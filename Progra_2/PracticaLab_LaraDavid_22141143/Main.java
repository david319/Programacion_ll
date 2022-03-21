package PracticaLab_LaraDavid_22141143;

import java.util.Scanner;

import static PracticaLab_LaraDavid_22141143.Comment.print;

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        int menu;
        do {
            System.out.println("""
                    ----Redes Sociales----
                    1. Agregar cuenta
                    2. Agregar post
                    3. Agregar amigo
                    4. Agregar comentario
                    5. Perfil de usuario
                    6. Salir
                    Seleccione una opción:""");
            menu = leer.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("---Agregar cuenta ---");

                    System.out.print("Ingrese nombre Usuario: ");
                    String user = leer.next();

                    System.out.print("Ingrese Tipo de Cuenta:");
                    String tipo = leer.next().toUpperCase();

                    UberSocial.agregarCuenta(user, tipo);
                    break;
                case 2:
                    System.out.println("---Agregar post ---");

                    System.out.print("Ingrese nombre Usuario: ");
                    String user1 = leer.next();

                    System.out.print("Ingrese Su Post: ");
                    String post = leer.next();

                    UberSocial.agregarPost(user1, post);
                    break;
                case 3:
                    System.out.println("---Agregar amigo ---");

                    System.out.print("Ingrese nombre Usuario: ");
                    String user11 = leer.next();

                    System.out.print("Ingrese Usuario 1: ");
                    String user12 = leer.next();

                    UberSocial.agregarAmigo(user11, user12);
                    break;
                case 4:
                    System.out.println("---Agregar comentario ---");

                    System.out.print("Ingrese nombre Usuario: ");
                    String user111 = leer.next();

                    System.out.print("Ingrese Su PostID: ");
                    int postID = leer.nextInt();

                    System.out.print("Ingrese Autor: ");
                    String autor = leer.next();

                    System.out.print("Ingrese Comentario: ");
                    String comment = leer.next();

                    UberSocial.agregarComment(user111, postID, autor, comment);
                    break;
                case 5:
                    System.out.println("---Perfil del Usuario ---");

                    System.out.print("Ingrese nombre Usuario: ");
                    String userLog = leer.next();

                    UberSocial.profileForm(userLog);
                    print();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no valida");
            }
        } while (menu != 6);
    }
}
