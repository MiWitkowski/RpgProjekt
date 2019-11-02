package pl.rpgprojekt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.rpgprojekt.dao.MonsterDao;
import pl.rpgprojekt.entities.Monster;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(name = "/", produces = "text/html;charset=UTF-8")
public class UserController {

    @PersistenceContext
    EntityManager entityManager;


    @Autowired
    private MonsterDao monsterDao;

    @RequestMapping(value = "/showAllMonster", method = RequestMethod.GET)
    public String showAllMonsters(Model monsters) {
        monsters.addAttribute("monsters", monsterDao.getMon());
        return "showAllMonster";
    }


}
