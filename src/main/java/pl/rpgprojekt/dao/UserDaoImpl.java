package pl.rpgprojekt.dao;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import pl.rpgprojekt.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
//@Transactional
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void create (User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> findAll () {
        Query query = entityManager.
                createNativeQuery("select id, username, enabled, lvl from users");

        List<Object[]> rows = query.getResultList();
        List<User> result = new ArrayList<>(rows.size());
        for (Object[] row : rows) {
            result.add(new User(
                    (int) row[0],
                    (String) row[1],
                    (boolean) row[2],
                    (int) row[3]));
        }
        return result;
    }

    @Override
    public void update (User user) {
        entityManager.merge(user);
    }

    @Override
    public User findById (int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void banUnban (int id) {
        User user = entityManager.find(User.class, id);
        if (user.getEnabled() == false) {
            user.setEnabled(true);
            entityManager.merge(user);
        } else {
            user.setEnabled(false);
            entityManager.merge(user);
        }
    }

    @Override
    public void delete (int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
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

    @Override
    public int getCurrentUserId () {
        Query query2 = entityManager.createNativeQuery("select id from users where username = '" + getCurrentUserLogin() + "'");
        int id = (int) query2.getResultList().get(0);
        System.out.println(id);
        return id;
    }

    @Override
    public User getCurrentUser () {
        return findById(getCurrentUserId());
    }

    @Override
    public void levelUp (User user) {
        while (user.getExperience() >= 100) {
            user.setLvl(user.getLvl() + 1);
            user.setExperience(user.getExperience() - 100);
        }
    }

    @Override
    public void recoverHp () {
        User user = getCurrentUser();
        try {
            while (user.getHp() < 100) {
                if (user.getHp() <= 90) {
                    user.setHp(user.getHp() + 10);
                    Thread.sleep(1000);
                } else {
                    user.setHp(100);
                }
            }
        } catch (InterruptedException e) {
        }
    }
}

