package pl.rpgprojekt.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.rpgprojekt.dao.UserDao;
import pl.rpgprojekt.entities.User;

@Controller
@RequestMapping(produces = "text/html;charset=UTF-8")
public class HomeController {

    @Autowired
    private UserDao userDao;

    private final String BACK = "<br><a href=\"javascript:history.back()\">Powrót</a>";


    @GetMapping("/")
    public String home () {
        return "home";
    }

    @GetMapping(value = "/register")
    public String showRegisterForm () {
        return "registerForm";
    }

    @ResponseBody
    @PostMapping(value = "/register")
    public String processRegister (@RequestParam String username,
                                   @RequestParam String password,
                                   BCryptPasswordEncoder bCryptPasswordEncoder) {
        User user = new User(username, bCryptPasswordEncoder.encode(password));
        for (User u : userDao.findAll()) {
            if (u.getUsername().equals(user.getUsername())) {
                return "Użytkownik o podanym loginie już istnieje! "
                        + BACK;
            }
        }
        userDao.create(user);
        return "Udało się zarejestrować, Możesz się teraz zalogować \n"
                + "<a href=/login>Zaloguj się</a>";
    }
}