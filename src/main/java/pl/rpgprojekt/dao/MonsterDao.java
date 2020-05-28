package pl.rpgprojekt.dao;

import org.springframework.stereotype.Repository;
import pl.rpgprojekt.entities.Monster;

import javax.transaction.Transactional;
import java.util.List;


//@Repository
@Transactional
public interface MonsterDao {
    public void create (Monster monster);
    public List<Monster> findAllMonsters();
    public Monster findById (int id);
}
