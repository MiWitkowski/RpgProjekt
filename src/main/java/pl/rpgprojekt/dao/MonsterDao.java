package pl.rpgprojekt.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.rpgprojekt.entities.Monster;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class MonsterDao {

    @PersistenceContext
    EntityManager entityManager;

/*    @ModelAttribute("monsters")
    public List<Monster> getAllMonsters() {
        Query query = entityManager.createNativeQuery("select name from monster");
        List<Monster> list = new ArrayList<>();
        return query.getResultList();
    }*/





/*

    @ModelAttribute("monster")
    public Monster getMon (Long id) {
        return entityManager.find(Monster.class, id);
    }
*/


}
