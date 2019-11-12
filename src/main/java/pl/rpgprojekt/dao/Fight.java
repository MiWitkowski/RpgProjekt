package pl.rpgprojekt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.rpgprojekt.entities.Monster;
import pl.rpgprojekt.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Random;

@Repository
@Transactional
public class Fight {

    @PersistenceContext
    EntityManager entityManager;

    private UserDao userdao;

    @Autowired
    public Fight (UserDao userDao) {
        this.userdao = userDao;
    }

    public void fight (Monster monster, User user) {
        Random random = new Random();
        int monsterHp = monster.getHp();
        int lost = random.nextInt(monsterHp);

        if (user.getHp() > monster.getHp()) {
            user.setExperience(user.getExperience() + monster.getExperience());
            user.setHp(user.getHp() - lost);
        }

        System.out.println(LocalDateTime.now());
        int currentHp = user.getHp();
        System.out.println(currentHp);

        entityManager.merge(user);

    }
}
