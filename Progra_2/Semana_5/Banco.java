package Semana_5;

import java.util.ArrayList;

import static Semana_5.CuentaPlazoFijo.TASA;

public class Banco {
    // Atributos
    private static String cuenta1;
    private static String cuenta2;
    private static int indice = 0;
    private static int users = 0;

    private TipoCuenta tipo;
    public static ArrayList<CuentaBancaria> cuentas = new ArrayList<>();

    public static String search(int numeroCuenta) {
        if (users > 0) {
            if (cuentas.get(indice).getNumCuenta() == numeroCuenta) {
                System.out.println(cuentas.get(indice).toString());
            } else if (cuentas.get(indice).getNumCuenta() != numeroCuenta) {
                indice++;
                search(numeroCuenta);
                return null;
            }
        }
        return null;
    }

    public static void add(int numeroCuenta, String nombre, TipoCuenta tipoCuenta) {
        if (users > 0) {
            if (search(numeroCuenta) == null) {
                if (TipoCuenta.AHORRO == tipoCuenta) {
                    CuentaAhorro cuenta = new CuentaAhorro(numeroCuenta, nombre);
                    cuentas.add(cuenta);
                    users++;
                }
            }
        }

    }

    public static void evalDeactivations() {
        if (indice < cuentas.size()) {
            if (cuentas.get(indice) instanceof CuentaAhorro) {
                ((CuentaAhorro) cuentas.get(indice)).desactivar();
                indice = 0;
            } else {
                indice++;
                evalDeactivations();
            }
        }
    }

    public static void applyInterests() {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta instanceof CuentaPlazoFijo) {
                cuenta.deposito(cuenta.getSaldo() * TASA);
            }
        }
    }

    public static void transfer(int numeroCuentaOrigen, int numeroCuentaDestino, double cantidad) {
        for (int i = 0; i < cuentas.size(); i++) {
            if (cuentas.get(i).getNumCuenta() == numeroCuentaOrigen) {
                cuenta1 = cuentas.get(i).toString();
            }
            for (int j = 0; j < cuentas.size(); j++) {
                if (cuentas.get(j).getNumCuenta() == numeroCuentaDestino) {
                    cuenta2 = cuentas.get(j).toString();
                    cuentas.get(i).retiro(cantidad);
                    cuentas.get(i + 1).deposito(cantidad);
                    System.out.println("Transferencia realizada de " + cuenta1 + " a " + cuenta2);
                }
            }
        }
    }

}


