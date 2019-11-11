package pl.rpgprojekt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.rpgprojekt.dao.MonsterDao;
import pl.rpgprojekt.dao.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Controller
@RequestMapping(value = "/user", produces = "text/html;charset=UTF-8")
public class UserController {

    @PersistenceContext
    EntityManager entitymanager;

    @Autowired
    private MonsterDao monsterDao;

    @Autowired
    private UserDao userDao;


    @GetMapping(value = "/showAllMonster")
    public String showAllMonsters (Model monsters) {
        monsters.addAttribute("monsters", monsterDao.getMon());
        userDao.currentUser();
        return "user/showAllMonster";
    }



}