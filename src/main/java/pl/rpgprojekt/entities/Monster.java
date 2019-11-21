package pl.rpgprojekt.entities;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "monster")
public class Monster {

    public Monster () {
    }

    @Column(columnDefinition = "INT")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String name;

    @NotNull
    @Min(1)
    @Max(100)
    private int hp;

    @NotNull
    private int experience;

    public Monster (int hp, String name, int experience) {
        this.hp = hp;
        this.name = name;
        this.experience = experience;
    }


    public Monster (int id, int experience, String name, int hp) {
        this.id = id;
        this.experience = experience;
        this.name = name;
        this.hp = hp;
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
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

    public int getExperience () {
        return experience;
    }

    public void setExperience (int experience) {
        this.experience = experience;
    }


    @Override
    public String toString () {
        return "Monster{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", experience=" + experience +
                '}';
    }
}
