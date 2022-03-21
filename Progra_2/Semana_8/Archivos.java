package Semana_8;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Calendar;

public class Archivos {

    static ArrayList<Pintura> pinturas = new ArrayList<>();
    static ArrayList<Pintor> pintores = new ArrayList<>();

    public static boolean CheckPintura(String name) {
        for (Pintura pintura : pinturas) {
            if (pintura.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean CheckPintor(String name) {
        for (Pintor pintor : pintores) {
            if (pintor.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void addPintura(String name, Calendar creationDate, String technique, double price, String description) {
        if (!CheckPintura(name)) {
            pinturas.add(new Pintura(name, creationDate, technique, price, description));
        }
    }

    public void addPintor(String name, String nameArtistic, Calendar yearNac, String genre, String artStyle) {
        if (!CheckPintor(name)) {
            pintores.add(new Pintor(name, nameArtistic, yearNac, genre, artStyle));
        }
    }

    public void addPinturaPintor(String namePintura, String namePintor) {
        for (Pintura pintura : pinturas) {
            if (pintura.getName().equals(namePintura)) {
                for (Pintor pintor : pintores) {
                    if (pintor.getName().equals(namePintor)) {
                        pintor.addPintura(pintura);
                    }
                }
            }
        }
    }

    public void savePinturas() throws FileNotFoundException {
        RandomAccessFile raf = new RandomAccessFile("pinturas.dat", "rw");
        try {
            for (Pintura pintura : pinturas) {
                raf.writeUTF(pintura.getName());
                raf.writeLong(pintura.getCreationDate().getTimeInMillis());
                raf.writeUTF(pintura.getTechnique());
                raf.writeDouble(pintura.getPrice());
                raf.writeUTF(pintura.getDescription());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void savePintores() throws FileNotFoundException {
        RandomAccessFile raf = new RandomAccessFile("pintores.dat", "rw");
        try {
            for (Pintor pintor : pintores) {
                raf.writeUTF(pintor.getName());
                raf.writeUTF(pintor.getNameArtistic());
                raf.writeLong(pintor.getYearNac().getTimeInMillis());
                raf.writeUTF(pintor.getGenre());
                raf.writeUTF(pintor.getArtStyle());
                for (Pintura pintura : pintor.getPinturas()) {
                    raf.writeUTF(pintura.getName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
