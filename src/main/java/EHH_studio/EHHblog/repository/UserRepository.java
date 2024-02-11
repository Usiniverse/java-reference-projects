package EHH_studio.EHHblog.repository;

import EHH_studio.EHHblog.domain.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager em;

    // create
    public void save(User user) {
        em.persist(user);
    }

    // delete
    public void remove(Long id) {
        em.remove(findById(id));
    }

    // read
    public User findById(Long id) {
        return em.find(User.class, id);
    }

    public User findByName(String findName) {
        return em.createQuery("select u from User u where u = :findName", User.class)
                .setParameter("findName", findName)
                .getSingleResult();
    }

    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }
}
