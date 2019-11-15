package pl.rpgprojekt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.rpgprojekt.entities.Monster;
import pl.rpgprojekt.entities.User;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Random;

@Repository
@Transactional
public class Fight {

    @Autowired
    private UserDao userDao;

    public void fight (Monster monster, User user) {
        Random random = new Random();
        int lost = random.nextInt(monster.getHp());
        int currentHp = user.getHp();

        if (user.getHp() > monster.getHp()) {
            currentHp = (user.getHp() - lost);
            user.setExperience(user.getExperience() + monster.getExperience());
        } else if (user.getHp() < monster.getHp()) {
            currentHp = 0;
        }

        user.setHp(currentHp);

        userDao.levelUp(user);

        userDao.update(user);

    }
}
