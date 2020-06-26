package pl.rpgprojekt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.rpgprojekt.dao.Fight;
import pl.rpgprojekt.dao.MonsterDao;
import pl.rpgprojekt.dao.UserDao;
import pl.rpgprojekt.entities.Monster;
import pl.rpgprojekt.entities.User;

import java.util.Collections;
import java.util.List;


@Controller
@RequestMapping(value = "/user", produces = "text/html;charset=UTF-8")
public class UserController {


    @Autowired
    private MonsterDao monsterDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private Fight fight;

    private final String BACK = "<br><a href=\"javascript:history.back()\">Powrót</a>";


    @GetMapping()
    public String userPanel (Model user) {
        user.addAttribute("user", userDao.getCurrentUser());
        return "user/userPanel";
    }

    @GetMapping(value = "/rest")
    @ResponseBody
    public String rest () {
        if (userDao.getCurrentUser().getHp() < 100) {
            userDao.recoverHp();
            return "Zostałeś uzdrowiony" +
                    BACK;
        }
        return "Twój poziom zdrowia jest maksymalny!" +
                BACK;
    }

    @GetMapping(value = "/showAllMonster")
    public String showAllMonsters (Model monsters) {
        monsters.addAttribute("monsters", monsterDao.findAllMonsters());
        return "user/showAllMonster";
    }

    @GetMapping(value = "/fight/{monsterId}")
    @ResponseBody
    public String fight (@PathVariable int monsterId) {
        User user = userDao.findById(userDao.getCurrentUserId());
        int currentHp = user.getHp();
        Monster monster = monsterDao.findById(monsterId);
        if (user.getHp() <= 0) {
            return "<h3>Masz za mało życia. Odpocznij</h3>" + "<br>" +
                    BACK;
        }
        fight.fight(monster, user);
        int lostHp = currentHp - user.getHp();
        return "<h3>Wygrywasz</h3> " +
                "Straciłeś " + lostHp + " HP" +
                BACK +
                "<br><a href=/user/fight/" + monsterId + ">Walcz ponownie</a>";
    }

    @GetMapping(value = "/ranking")
    public String ranking (Model users) {
        List<User> userList = userDao.findAll();
        Collections.sort(userList);
        users.addAttribute("users", userList);
        return "user/ranking";
    }
}
