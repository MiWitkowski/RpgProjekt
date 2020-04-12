package pl.rpgprojekt.dao;

import org.hibernate.internal.SessionImpl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import pl.rpgprojekt.config.AppConfig;
import pl.rpgprojekt.entities.Monster;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.ResultSet;


@ContextConfiguration(classes = AppConfig.class)
public class MonsterDaoTest {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("rpg_projektPersistenceUnit");

    public EntityManager getEntityManager () {
        return factory.createEntityManager();
    }

/*
    EntityManager entityManager = getEntityManager();
*/


    @Autowired
    MonsterDao monsterDao = new MonsterDao();



    @Transactional
    @Test
    public void doExist () throws Exception {
        Connection1.getConnection();
        ResultSet rs = Connection1.getConnection().createStatement().executeQuery("SELECT * FROM monster WHERE id = '1'");

        Monster a = getEntityManager().find(Monster.class, 1);

//        System.out.println("asd" + entityManager.find(Monster.class, 2).toString());

        Monster ada = monsterDao.findById(1);
//        Monster monster =  (Monster) getEntityManager().createNativeQuery("SELECT * FROM monster WHERE id='1';");

        while (rs.next()) {
            Monster mk = new Monster(
                    rs.getInt("id"),
                    rs.getInt("experience"),
                    rs.getString("name"),
                    rs.getInt("hp"));

            Monster m = new Monster(1, 5, "Goblin", 5);
            Assert.assertEquals(ada, m);
        }
    }
}