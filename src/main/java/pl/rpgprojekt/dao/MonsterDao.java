package pl.rpgprojekt.dao;

import pl.rpgprojekt.entities.Monster;

import java.util.List;

public interface MonsterDao {
    public void create (Monster monster);
    public List<Monster> findAllMonsters();
    public Monster findById (int id);
}
