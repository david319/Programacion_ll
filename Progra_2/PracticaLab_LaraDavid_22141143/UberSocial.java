package PracticaLab_LaraDavid_22141143;

import java.util.ArrayList;

public class UberSocial {

    public static ArrayList<SocialClass> redesSociales = new ArrayList<>();
    public static Facebook facebook = new Facebook("");
    public static Twitter twitter = new Twitter("");

    public static SocialClass buscar(String user) {
        int indice = 0;
        return buscar(user, indice);
    }

    private static SocialClass buscar(String user, int indice) {
        if (indice < redesSociales.size()) {
            if (redesSociales.get(indice) instanceof Facebook) {
                return redesSociales.get(indice);
            } else if (redesSociales.get(indice) instanceof Twitter) {
                return redesSociales.get(indice);
            } else
                return buscar(user, indice + 1);
        }
        return null;
    }


    public static void agregarCuenta(String user, String tipo) {
        SocialClass id = buscar(user);
        if (id != null) {
            System.out.println("Ya existe");
        } else {
            if (tipo.equals("Facebook") && buscar(user) == null) {
                facebook = new Facebook(user);
            } else if (tipo.equals("Twitter") && buscar(user) == null) {
                twitter = new Twitter(user);
            }
        }
    }


    public static void agregarPost(String user, String post) {
        SocialClass id = buscar(user);
        if (id != null) {
            id.post.add(post);
        } else {
            System.out.println("No existe");        }
    }

    public static void agregarAmigo(String user1, String user2) {
        SocialClass id1 = buscar(user1);
        SocialClass id2 = buscar(user2);
        if (id1 != null && id2 != null) {
            if (id1 instanceof Facebook && id2 instanceof Facebook) {
                id2.addAmigo(user1);
                id1.addAmigo(user2);
            }
        } else {
            System.out.println("No existe");
        }
    }

    public static void agregarComment(String user, int postID, String autor, String comment) {
        SocialClass id1 = buscar(user);
        if (id1 != null) {
            if (id1 instanceof Facebook) {
                facebook.addComment(new Comment(postID, autor, comment));
            }
        }
        System.out.println("No existe");

    }

    public static void profileForm(String user) {
        SocialClass id1 = buscar(user);
        if (id1 != null) {
            if (id1 instanceof Facebook) {
                id1.myProfile();
            } else if (id1 instanceof Twitter) {
                id1.myProfile();
            }
        }
    }

}

