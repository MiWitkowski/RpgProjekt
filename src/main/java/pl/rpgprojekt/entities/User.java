package pl.rpgprojekt.entities;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Role;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;


@Entity
@Table(name = "user")
public class User {

    public User () {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private int lvl = 1;

    @NotBlank
    @Size(min = 1, max = 20, message = "Login musi mieć minimum 1 znak")
    @Column(unique = true, nullable = false)
    private String login;

    @NotBlank
    @Size(min = 5, message = "Hasło musi mieć minimum 5 znaków")
    private String password;

    @ManyToMany
    private Set<Role> roles;

    @NotNull
    @Min(1)
    @Max(100)
    private int hp = 100;

    @NotNull
    @Min(1)
    @Max(100)
    private int strength = 5;


    public User (String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User (String login, String password, int hp, int strength, int lvl) {
        this.login = login;
        this.password = password;
        //this.hp = 100;
        //this.strength = 5;
        //this.lvl = 1;
    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getLogin () {
        return login;
    }

    public void setLogin (String login) {
        this.login = login;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public int getHp () {
        return hp;
    }

    public void setHp (int hp) {
        this.hp = hp;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    /*

    public int getStrength () {
        return strength;
    }

    public void setStrength (int strength) {
        this.strength = strength;
    }

*/

}

