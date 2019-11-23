package pl.rpgprojekt.dao;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.rpgprojekt.entities.Monster;
import pl.rpgprojekt.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;

@Service
@Transactional
public class UserDao {

    @PersistenceContext
    EntityManager entityManager;

    public void create (User user) {
        entityManager.persist(user);
    }

    public List<User> findAll () {
        Query query = entityManager.
                createNativeQuery("select id, username, enabled from users");

        List<Object[]> rows = query.getResultList();
        List<User> result = new ArrayList<>(rows.size());
        for (Object[] row : rows) {
            result.add(new User(
                    (int) row[0],
                    (String) row[1],
                    (int) row[2]));
        }
        return result;
    }

    public void update (User user) {
        entityManager.merge(user);
    }

    public User findById (int id) {
        return entityManager.find(User.class, id);
    }

    public void banUnban (int id) {
        User user = entityManager.find(User.class, id);
        if (user.getEnabled() == 0) {
            user.setEnabled(1);
            entityManager.merge(user);
        } else {
            user.setEnabled(0);
            entityManager.merge(user);
        }
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

    public User getCurrentUser () {
        return findById(getCurrentUserId());
    }

    public void levelUp (User user) {
        if (user.getExperience() >= 100) {
            user.setLvl(user.getLvl() + 1);
            user.setExperience(user.getExperience() - 100);
        }
    }

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

