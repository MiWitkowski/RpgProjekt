/*
package pl.rpgprojekt.entities;

import org.hibernate.annotations.ValueGenerationType;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name ="champion")
public class Champion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private int lvl = 1;

    @Size(max = 50, message = "Nazwa może mieć maksymalnie 50 znaków")
    @Column(unique = true, nullable = false)
    private String name;

    @NotNull
    @Min(1)
    @Max(100)
    private int hp = 100;

    @NotNull
    @Min(1)
    private int strength = 5;

    @OneToOne
    private User user;

    public Champion () {
    }

    public Champion (String name, User user) {
        this.name = name;
        this.user = user;
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public int getLvl () {
        return lvl;
    }

    public void setLvl (int lvl) {
        this.lvl = lvl;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
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

    public User getUser () {
        return user;
    }

    public void setUser (User user) {
        this.user = user;
    }
}
*/
