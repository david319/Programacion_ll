package Semana_2;

public class clase_hija extends Person{

    String grado;

    public void Programmer(String name, int age, String grado){
        super.person(name, age);
        this.grado = grado;
    }

    public String grado(){
        return "Grado: Lieutenant";

    }

    public static void main(String[] args) {
        // Upcasting
        Person p = new Programmer();
        System.out.println(p.grado());

        // Down casting
        Programmer p1 = (Programmer)p;

        System.out.println(p1.grado());

    }
}
