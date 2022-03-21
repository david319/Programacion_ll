package PracticaLab_LaraDavid_22141143;

import java.util.Iterator;

public class Twitter extends SocialClass {

    public Twitter(String user) {
        super(user);
    }

    @Override
    public void timeline() {
        Iterator<String> posts = post.iterator();
        while (posts.hasNext()) {
            for (int i = 0; i <= post.size(); i++) {
                String imprimir = posts.next();
                System.out.println("\n" + i + " " + imprimir);
            }
        }
    }
}
