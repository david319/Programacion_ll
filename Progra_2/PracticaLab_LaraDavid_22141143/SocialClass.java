package PracticaLab_LaraDavid_22141143;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class SocialClass {
    public ArrayList<String> amigos;
    public ArrayList<String> post;
    public String usuario;

    public SocialClass(String user) {
        this.amigos = new ArrayList<>();
        this.post = new ArrayList<>();
        this.usuario = user;
    }

    public boolean addAmigo(String user) {
        if (!amigos.contains(user)) {
            amigos.add(user);
            return true;
        } else {
            System.out.println("El usuario ya es tu amigo");
            return false;
        }
    }

    public void addPost(String comentario) {
        this.post.add(comentario);
    }

    public abstract void timeline();

    public void myProfile() {
        System.out.println("Usuario: " + this.amigos);
        timeline();
        Iterator<String> lista = amigos.iterator();

        while (lista.hasNext()) {
            for (int i = 0; i <= 10; i++) {
                String imprimir = lista.next();
                System.out.println((i + 1) + " " + imprimir);
            }
        }
    }
}
