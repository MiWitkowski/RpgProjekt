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
@RequestMapping(name = "/user", produces = "text/html;charset=UTF-8")
public class UserController {

    @PersistenceContext
    EntityManager entityManager;


    @Autowired
    private MonsterDao monsterDao;

    @GetMapping
    public String method () {
        return "showAllMonster";
    }


//    @ModelAttribute("monsters")
    /*@RequestMapping(value = "/showall", method = RequestMethod.GET)
    public String showAllMonsters(Model model) {
        model.addAttribute("monsters", monsterDao.getCategory());
        return "showAllMonster";
    }*/



    @ModelAttribute("monsters")
    public List<Monster> getCategory () {
        List<Monster> list = new ArrayList<>();
        Long x = 1L;

        for (; ; ) {
            list.add(entityManager.find(Monster.class, x));
            if (entityManager.find(Monster.class, x) == null
            ) {
                break;
            }
            x++;
        }
        return list;
    }



}
