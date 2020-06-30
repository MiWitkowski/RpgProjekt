//package pl.rpgprojekt.dao;
//
//import org.junit.Assert;
//import org.junit.Test;
//import pl.rpgprojekt.entities.Monster;
//
//
//public class MonsterDaoImplTest {
//
//    private MonsterDaoImpl monsterDaoImpl = new MonsterDaoImpl();
//
//    @Test
//    public void doExist () throws Exception {
//
//        //should return Monster(id:1, experience:5, name:"Goblin", hp:5)
//        Monster ada = monsterDaoImpl.findById(1);
//
//        System.out.println(ada);
//
//        Monster m = new Monster(1, 5, "Goblin", 5);
//        Assert.assertEquals(ada, m);
//    }
//}
