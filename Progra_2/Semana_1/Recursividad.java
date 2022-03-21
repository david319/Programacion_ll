package Semana_1;

public class Recursividad {

     public static void foo(int i) {
          if (i < 10)
               foo(i+1);
          System.out.println("Recursion Foo con i: " + i);
     }

     // Metodo de recursividad Up
     public static int suma(int n) {
          if (n >= 1) {
               return suma(n - 1) + n;
          }
          return 0;
     }

     // Metodo de recursividad Down
     public static int down(int n, int sum){
          if(n >= 1){
               return down(n - 1, sum + n);
          }
          return sum;
     }

     // Revertir una cadena con recursividad
     public static String revertir(String cadena){
          if(cadena.length() > 0){ // Si la cadena tiene al menos un carácter
               return revertir(cadena.substring(1)) + cadena.charAt(0); // Se retorna la cadena sin el primer carácter y se concatena el primer carácter
          }
          return cadena; // Si la cadena no tiene caracteres se retorna la cadena vacía
     }

     public static void main(String[] args) {
          //foo(0);
          //System.out.println(suma(4));
          //System.out.println(down(4,0));
          System.out.println(revertir("hola"));
     }

}
