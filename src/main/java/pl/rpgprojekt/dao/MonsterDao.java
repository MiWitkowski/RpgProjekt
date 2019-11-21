package pl.rpgprojekt.dao;


import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.rpgprojekt.entities.Monster;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class MonsterDao {

    @PersistenceContext
    EntityManager entityManager;

    public void create (Monster monster) {
        entityManager.persist(monster);
    }


    public List<Monster> findAllMonsters () {
        Query query = entityManager.
                createNativeQuery("select * from monster");

        List<Object[]> rows = query.getResultList();
        List<Monster> result = new ArrayList<>(rows.size());
        for (Object[] row : rows) {
            result.add(new Monster(
                    (int) row[0],
                    (int) row[1],
                    (String) row[3],
                    (int) row[2]));
        }
        return result;
    }

    public Monster findById (int id) {
        return entityManager.find(Monster.class, id);
    }

}

