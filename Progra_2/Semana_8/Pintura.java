package Semana_8;

import java.util.Calendar;

public class Pintura {

    // Atributos
    private String name;
    private Calendar creationDate;
    private String technique;
    private double price;
    private String description;

    // Constructor
    public Pintura(String name, Calendar creationDate, String technique, double price, String description) {
        this.name = name;
        this.creationDate = creationDate;
        this.technique = technique;
        this.price = price;
        this.description = description;
    }

    // Getters
    public String getName() {
        return name;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public String getTechnique() {
        return technique;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    public void setTechnique(String technique) {
        this.technique = technique;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "Nombre: " + name + "\nFecha de creación: " + creationDate.get(Calendar.DAY_OF_MONTH) + "/" + creationDate.get(Calendar.MONTH) + "/" + creationDate.get(Calendar.YEAR) + "\nTécnica: " + technique + "\nPrecio: " + price + "\nDescripción: " + description;
    }

}
