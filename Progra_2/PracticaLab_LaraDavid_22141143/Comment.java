package PracticaLab_LaraDavid_22141143;

import java.util.Calendar;

public final class Comment {

    public int postId;
    public static String autor;
    public static String comentario;
    public static Calendar fechaComent;

    public Comment(int postId, String autor, String comentario) {
        this.postId = postId;
        Comment.autor = autor;
        Comment.comentario = comentario;
        fechaComent = Calendar.getInstance();
        fechaComent = Calendar.getInstance();
    }

    public static void print() {
        System.out.println("Autor: " + autor + " Fecha: " + fechaComent.getTime() + "\nComentario: " + comentario);
    }

}
