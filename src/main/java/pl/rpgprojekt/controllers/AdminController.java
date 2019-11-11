package pl.rpgprojekt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.rpgprojekt.dao.UserDao;
import pl.rpgprojekt.entities.User;

@Controller
@RequestMapping(value = "/admin", produces = "text/html;charset=UTF-8")
public class AdminController {

    @Autowired
    private UserDao userDao;

    @GetMapping
    public String home () {
        return "admin/adminPanel";
    }

    /*
    @GetMapping
    public void modifyUser (@RequestParam User user) {
        userDao.update(user);
    }
*/
/*
    @GetMapping(value = "/deleteUser")
    public String showDeleteUserForm () {
    return "admin/deleteUser";
    }

    @GetMapping(value = "/deleteUser")
    public String processDelete (@RequestParam int id) {
        userDao.delete(id);
        return "redirect:showAllUsers" ;
    }
*/

    @GetMapping(value = "/showUsers")
    public String showAllUsers (Model users) {
        users.addAttribute("users", userDao.findAll());
        return "admin/showUsers";
    }
}
