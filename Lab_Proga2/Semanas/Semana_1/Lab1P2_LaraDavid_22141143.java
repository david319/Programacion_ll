package Semana_1;
import java.util.Scanner;

public class Lab1P2_LaraDavid_22141143 {

    static double[][] Matrices;
    public static double [][] matriz(int row,int col){
        System.out.println("\n*******Matriz de números aleatorios*******");
        Matrices= new double [row][col];
        for(int i=0;i<row;i++){
            for(int x=0;x<col;x++) {
                Matrices[i][x]=Math.random()*101;
                System.out.print("["+Matrices[i][x]+"]");
            }
            System.out.println();
        }
        return Matrices;
    }

    public static void PrintResultados(double[][] raices, int Epsilon){
        System.out.print("\n*******Raíces cuadradas de los números aleatorios*******");
        for(double[] casilla :raices){
            System.out.println("");
            for(double numero:casilla){
                System.out.print("["+ binarySearch(numero,Epsilon)+ "]");

            }
        }
    }

    public int leer (int min , int max){
        return min;
    }

    public static double binarySearch(double f, int Epsilon){
        return busquedaBinaria(f,0,f,0,Epsilon);
    }

    private static double busquedaBinaria(double x,double min ,double max,double med, int Epsilon){
        double med2=(max+min)/2;
        if(Math.pow(med2,2)<=x+(Math.pow(10,-Epsilon))&&Math.pow(med2,2)>=x-(Math.pow(10,-Epsilon))){
            return med2;
        }else{
            if(Math.pow(med2,2)>x){
                return busquedaBinaria(x,min,med2,med2,-Epsilon);

            }else if(Math.pow(med2,2)<x){
                return busquedaBinaria(x,med2,max,med2,-Epsilon);
            }
        }
        return med;
    }

    public static void main(String[] args){
        Scanner leer= new Scanner(System.in);

        System.out.print("Introduzca el numero de filas: ");
        int f=leer.nextInt();

        System.out.print("Introduzca el numero de columnas: ");
        int c= leer.nextInt();

        System.out.print("Introduzca el Epsilon: ");
        int epsilon= leer.nextInt();

        PrintResultados(matriz(f,c),epsilon);
    }
}

