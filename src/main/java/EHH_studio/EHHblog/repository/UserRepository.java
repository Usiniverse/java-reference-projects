package EHH_studio.EHHblog.repository;

import EHH_studio.EHHblog.domain.dto.UserDto;
import EHH_studio.EHHblog.domain.dto.UserJoinRequest;
import EHH_studio.EHHblog.domain.entity.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager em;

    // Create
    public void save(UserJoinRequest user) {
        em.persist(user);
    }

    // Read
    public User findById(Long id) {
        return em.find(User.class, id);
    }

    public User findByNickname(String nickname) {
        return em.createQuery("select u from User u where nickname = :nickname", User.class)
                .setParameter("nickname", nickname)
                .getSingleResult();
    }

    // Update
    public void update(UserDto user) {
        em.persist(user);
    }

    // Delete
    public void delete(Long id) {
        em.remove(id);
    }
}
