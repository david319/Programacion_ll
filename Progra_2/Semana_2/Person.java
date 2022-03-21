package Semana_2;

public class Person {
    // Attributes
    protected String name;
    protected int age;

    public void person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String grado() {
        return "Grado: ";
    }

    public static class Programmer extends Person {
        String language;

        public void programmer(String name, int age, String language) {
            super.person(name, age);
            this.language = language;
        }

        // Polimorfismo
        public String grado() {
           return "Grado: Lieutenant";
        }
    }

    public static class Dancer extends Person {
        String dance;

        public void dancer(String name, int age, String dance) {
            super.person(name, age);
            this.dance = dance;
        }
    }

    public static void main(String[] args) {

        // Upcasting
        Person p = new Programmer(); // Upcasting
        p.grado();


        // Down casting
        Programmer p1 = (Programmer) p; // Down casting
        p1.programmer("Juan", 23, "Java");

        System.out.println(p1.name);
        System.out.println(p1.age);
        System.out.println(p1.language);



    }
}
