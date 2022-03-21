package Semana_8;

import java.util.ArrayList;
import java.util.Calendar;

public class Pintor {

    // Atributos
    private String name;
    private String nameArtistic;
    private Calendar yearNac;
    private String genre;
    private String age;
    private String artStyle;
    private ArrayList<Pintura> pinturas;

    // Constructor
    public Pintor(String name, String nameArtistic, Calendar yearNac, String genre, String artStyle) {
        this.name = name;
        this.nameArtistic = nameArtistic;
        this.yearNac = yearNac;
        this.genre = genre;
        this.artStyle = artStyle;
        this.pinturas = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getNameArtistic() {
        return nameArtistic;
    }

    public Calendar getYearNac() {
        return yearNac;
    }

    public String getGenre() {
        return genre;
    }

    public String getAge() {
        return age;
    }

    public String getArtStyle() {
        return artStyle;
    }

    public ArrayList<Pintura> getPinturas() {
        return pinturas;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setNameArtistic(String nameArtistic) {
        this.nameArtistic = nameArtistic;
    }

    public void setYearNac(Calendar yearNac) {
        this.yearNac = yearNac;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setArtStyle(String artStyle) {
        this.artStyle = artStyle;
    }

    public void setPinturas(ArrayList<Pintura> pinturas) {
        this.pinturas = pinturas;
    }

    public String toString() {
        return "Pintor: " + name + "\nNombre Artístico: " + nameArtistic + "\nEdad: " + age + "\nGenero: " + genre + "\nEstilo de Arte: " + artStyle + "\n";
    }

    public void addPintura(Pintura pintura) {
        pinturas.add(pintura);
    }
}
