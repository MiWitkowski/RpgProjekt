package pl.rpgprojekt.entities;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


@Entity
@Table(name = "user")

public class User {

    public User () {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    @Size(min = 1, max = 20, message = "Login musi mieć minimum 1 znak")
    @Column(unique = true, nullable = false)
    private String login;

    @NotBlank
    @Size(min = 5, max = 30, message = "Hasło musi mieć minimum 5 znaków")
    private String password;

    @NotBlank
    @Min(1)
    @Max(100)
    private int hp;

    @NotBlank
    private int strength;


    public User (String login, String password, int hp, int strength) {
        this.login = login;
        this.password = password;
        this.hp = 100;
        this.strength = 5;
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

    public int getStrength () {
        return strength;
    }

    public void setStrength (int strength) {
        this.strength = strength;
    }



}

