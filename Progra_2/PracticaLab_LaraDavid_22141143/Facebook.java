package PracticaLab_LaraDavid_22141143;

import java.util.ArrayList;
import java.util.Iterator;

public class Facebook extends SocialClass implements Commentable {
    public ArrayList<Comment> comentarios;

    public Facebook(String user) {
        super(user);
        comentarios = new ArrayList<>();
    }

    @Override
    public boolean addComment(Comment comment) {
        for (int i = 0; i < super.post.size(); i++) {
            if (comment.postId == i) {

                this.comentarios.add(comment);
                return addComment(comment);
            }
        }
        return false;
    }

    @Override
    public void timeline() {
        Iterator<String> posts = post.iterator();
        Iterator<Comment> comments = comentarios.iterator();

        while (posts.hasNext()) {
            for (int i = 0; i <= post.size(); i++) {
                String posteos = posts.next();
                Comment comentario = comments.next();
                System.out.println("\n" + i + " " + posteos + "\nComentario: " + comentario);
            }
        }
    }
}
