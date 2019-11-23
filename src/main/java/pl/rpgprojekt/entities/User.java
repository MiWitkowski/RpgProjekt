package pl.rpgprojekt.entities;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "users")
public class User implements Comparable<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 50, message = "Login może mieć maksymalnie 50 znaków")
    @Column(unique = true, nullable = false)
    private String username;

    @NotBlank
    @Size(min = 5, message = "Hasło musi mieć minimum 5 znaków")
    private String password;

    private int enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

/*
    @OneToOne(mappedBy = "user")*/
/*
    @JoinTable(name = "user_authority", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))*//*

    private Set<Authorities> authorities;
*/

    //Game stats==========================================================================================
    @NotNull
    @Column(columnDefinition = "int default 1")
    private int lvl;
    @NotNull
    @Min(0)
    @Column(columnDefinition = "int default 100")
    private int hp;

    @NotNull
    @Column(columnDefinition = "int default 5")
    private int experience;

    //constructors
    public User () {
    }

    public User (String username, String password) {
        this.username = username;
        this.password = password;
        this.enabled = 1;
        this.lvl = 1;
        this.hp = 100;
        this.experience = 0;
    }

    public User (int id, String username, int enabled, int lvl) {
        this.id = id;
        this.username = username;
        this.enabled = enabled;
        this.lvl = lvl;
    }

    @Override
    public int compareTo(User o) {
        if(lvl>o.getLvl()) return -1;
        if(lvl<o.getLvl()) return 1;
        return 0;
    }

    /*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(lvl, user.lvl);
    }
*/

    //getters and setters
    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public Set<Role> getRoles () {
        return roles;
    }

    public void setRoles (Set<Role> roles) {
        this.roles = roles;
    }

    public int getEnabled () {
        return enabled;
    }

    public void setEnabled (int enabled) {
        this.enabled = enabled;
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

    public int getLvl () {
        return lvl;
    }

    public void setLvl (int lvl) {
        this.lvl = lvl;
    }



/*
    private int strength;

    public void setStrength (int strength) {
        this.strength = strength;
    }
    public int getStrength () {
        return strength;
    }
*/

    @Override
    public String toString () {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", roles=" + roles +
                ", lvl=" + lvl +
                ", hp=" + hp +
                ", experience=" + experience +
//                ", strength=" + strength +
                '}';
    }
}

