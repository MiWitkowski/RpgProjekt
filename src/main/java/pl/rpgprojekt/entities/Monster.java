package pl.rpgprojekt.entities;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigInteger;

@Entity
@Table(name = "monster")
public class Monster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @NotBlank
    private String name;

    @NotBlank
    @Min(1)
    @Max(100)
    private int hp;

    @NotBlank
    private int strength;

    public Monster () {
    }

    public Monster (BigInteger id, int hp, String name, int strength) {
        this.id = id;
        this.hp = hp;
        this.name = name;
        this.strength = strength;
    }

    public BigInteger getId () {
        return id;
    }

    public void setId (BigInteger id) {
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

    public int getStrength () {
        return strength;
    }

    public void setStrength (int strength) {
        this.strength = strength;
    }


    @Override
    public String toString () {
        return "Monster{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", strength=" + strength +
                '}';
    }
}
