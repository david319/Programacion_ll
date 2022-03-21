package Semana_4;

import java.util.Locale;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        Genero gen = Genero.MASCULINO;
        System.out.println(gen);

        String genero = leer.next().toUpperCase();
        Genero gen2 = Genero.valueOf(genero);
        System.out.println(gen2);

        for (Genero g : Genero.values()) {
            System.out.println(g);
        }

        System.out.println(Genero.MASCULINO.ordinal());
        System.out.println(Genero.FEMENINO.ordinal());

    }
}
