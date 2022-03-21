package Semana_4;

public enum TarifaPeaje {
    EJES2(12), EJES4(24), EJES6(50);
    public int precio;

    TarifaPeaje(int p) {
        precio = p;
    }
}
