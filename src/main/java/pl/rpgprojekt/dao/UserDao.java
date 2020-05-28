package pl.rpgprojekt.dao;

import pl.rpgprojekt.entities.User;

import java.util.List;


public interface UserDao {
    public void create (User user);

    public List<User> findAll ();

    public void update (User user);

    public User findById (int id);

    public void banUnban (int id);

    public void delete (int id);

    public String getCurrentUserLogin ();

    public int getCurrentUserId ();

    public User getCurrentUser ();

    public void levelUp (User user);

    public void recoverHp ();

}
