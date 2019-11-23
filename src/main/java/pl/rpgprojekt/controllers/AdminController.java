package pl.rpgprojekt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.rpgprojekt.dao.MonsterDao;
import pl.rpgprojekt.dao.UserDao;
import pl.rpgprojekt.entities.Monster;
import pl.rpgprojekt.entities.User;

@Controller
@RequestMapping(value = "/admin", produces = "text/html;charset=UTF-8")
public class AdminController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private MonsterDao monsterDao;

    @GetMapping
    public String home () {
        return "admin/adminPanel";
    }


    @GetMapping(value = "/ban/{userId}")
    @ResponseBody
    public String banUser (@PathVariable int userId) {
        userDao.banUnban(userId);
        return "Status użytkownika zmieniony" +
                "<br><a href=\"javascript:history.back()\">Powrót</a>";
    }


    @GetMapping(value = "/addMonster")
    public String addMonsterForm () {
        return "admin/addMonsterForm";
    }


    @ResponseBody
    @PostMapping(value = "/addMonster")
    public String processMonster (@RequestParam int hp,
                                  @RequestParam String name,
                                  @RequestParam int experience) {
        Monster monster = new Monster(hp, name, experience);
        for (int i = 0; i < monsterDao.findAllMonsters().size(); i++) {
            if (monsterDao.findAllMonsters().get(i).getName().equals(monster.getName())) {
                return "Potwór o podanej nazwie już istnieje!" +
                        "<br><a href=\"javascript:history.back()\">Powrót</a>";
            }
        }
        monsterDao.create(monster);
        return "Udało się, Nowy potwór już jest dostępny.\n"
                + "<br><a href=\"javascript:history.back()\">Powrót</a>";


    }

    @GetMapping(value = "/delete/{userId}")
    @ResponseBody
    public String showDeleteUserForm (@PathVariable int userId) {
        userDao.delete(userId);
        return "Użytkownik usunięty" +
                "<br><a href=\"javascript:history.back()\">Powrót</a>";
    }


    @GetMapping(value = "/showUsers")
    public String showAllUsers (Model users) {
        users.addAttribute("users", userDao.findAll());
        return "admin/showUsers";
    }
}
