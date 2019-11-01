package pl.rpgprojekt.dao;

import org.springframework.stereotype.Repository;
import pl.rpgprojekt.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDao {

    @PersistenceContext
    EntityManager entityManager;
    public void saveBook(User entity) {
        entityManager.persist(entity);
    }

}
