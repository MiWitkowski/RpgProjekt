package pl.rpgprojekt.dao;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import pl.rpgprojekt.entities.Monster;
import pl.rpgprojekt.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserDao {

    @PersistenceContext
    EntityManager entityManager;

    public void create (User user) {
        entityManager.persist(user);
    }

    public List<User> findAll () {
        Query query = entityManager.
                createNativeQuery("select id, username from users");

        List<Object[]> rows = query.getResultList();
        List<User> result = new ArrayList<>(rows.size());
        for (Object[] row : rows) {
            result.add(new User(
                    (int) row[0],
                    (String) row[1]));
        }
        return result;
    }


    public User findById (int id) {
        return entityManager.find(User.class, id);
    }

    public void update (User user) {
        entityManager.merge(user);
    }

    public void delete (int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    public String getCurrentUserLogin () {
        org.springframework.security.core.context.SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String login = null;
        if (authentication != null)
            if (authentication.getPrincipal() instanceof UserDetails)
                login = ((UserDetails) authentication.getPrincipal()).getUsername();
            else if (authentication.getPrincipal() instanceof String)
                login = (String) authentication.getPrincipal();

        return login;

    }

    public int getCurrentUserId () {
        Query query2 = entityManager.createNativeQuery("select id from users where username = '" + getCurrentUserLogin() + "'");
        int id = (int) query2.getResultList().get(0);
        System.out.println(id);
        return id;
    }
}
