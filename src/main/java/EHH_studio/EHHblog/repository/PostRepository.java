package EHH_studio.EHHblog.repository;

import EHH_studio.EHHblog.domain.Post;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepository {
    private final EntityManager em;

    // create
    public void savePost(Post post) {
        em.persist(post);
    }

    // delete
    public void removePost(Long id) {
        em.remove(findByPostId(id));
    }

    // read
    public Post findByPostId(Long id) {
        return em.find(Post.class, id);
    }

    public Post findByTitle(String title) {
        return em.createQuery("select p from Post p where p = :title", Post.class)
                .setParameter("title", title)
                .getSingleResult();
    }

    public List<Post> findAllPost() {
        return em.createQuery("select p from Post p", Post.class)
                .getResultList();
    }
}
