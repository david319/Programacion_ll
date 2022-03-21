package Semana_1;
import javax.swing.*;

public class TestInterfazGrafica {

    // Sumar dos números con interfaz grafica
    public static void sumar() {
        int num1, num2, resultado;
        num1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero"));
        num2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero"));
        resultado = num1 + num2;
        JOptionPane.showMessageDialog(null, "El resultado de la suma es: " + resultado);
    }

    public static void main(String[] args) {
        sumar();
    }

}
