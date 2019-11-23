package pl.rpgprojekt.entities;

import javax.persistence.*;


@Table(name = "authorities")
@Entity
public class Authorities {


    public Authorities () {
    }

    public Authorities (String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "authority", nullable = false)
    private String authority;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users")
    private User user;


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

    public String getAuthority () {
        return authority;
    }

    public void setAuthority (String authority) {
        this.authority = authority;
    }

    public User getUser () {
        return user;
    }

    public void setUser (User user) {
        this.user = user;
    }
}



