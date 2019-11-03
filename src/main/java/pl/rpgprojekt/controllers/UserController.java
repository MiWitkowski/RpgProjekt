package pl.rpgprojekt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.rpgprojekt.config.AppConfig;
import pl.rpgprojekt.dao.MonsterDao;
import pl.rpgprojekt.dao.UserDao;
import pl.rpgprojekt.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
//@Import(AppConfig.class)

@Controller
@RequestMapping(name = "/", produces = "text/html;charset=UTF-8")
public class UserController {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private MonsterDao monsterDao;

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/showAllMonster", method = RequestMethod.GET)
    public String showAllMonsters (Model monsters) {
        monsters.addAttribute("monsters", monsterDao.getMon());
        return "showAllMonster";
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterForm () {
        return "registerForm";
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegister (@RequestParam String login,
                                   @RequestParam String password,
                                   BCryptPasswordEncoder bCryptPasswordEncoder) {
        User user = new User(login, bCryptPasswordEncoder.encode(password) );
        userDao.register(user);
        return "Udało się";



        /*    User user = new User(login, bCryptPasswordEncoder.encode(password));
        model.addAttribute("user"
                , user);
        entityManager.persist(user);
    */
    }
}



