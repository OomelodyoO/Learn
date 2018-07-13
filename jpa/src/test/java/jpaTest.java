import cn.zhang.model.User;
import cn.zhang.service.impl.UserServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by zhangzhixing on 2017/3/14.
 */
public class jpaTest {
    private EntityManager entityManager = null;
    User user = new User("zhang", 20);

    @Before
    public void before() {
        entityManager = Persistence.createEntityManagerFactory("persistence").createEntityManager();
        entityManager.getTransaction().begin();
    }

    @Test
    public void testDao() {
        System.out.println(new UserServiceImpl().add(entityManager, user));
    }

    @Test
    public void testPersist() {
        entityManager.persist(user);
        user.setAge(1);
    }

    @Test
    public void testClearPersist() {
        user.setAge(1);
        entityManager.persist(user);
        user.setAge(2); // 没有flush的动作
        entityManager.clear();
        user.setAge(3);
    }

    @Test
    public void testFlushClearPersist() {
        user.setAge(1);
        entityManager.persist(user);
        user.setAge(2);
        entityManager.flush();
        entityManager.clear();
        user.setAge(3);
    }

    @Test
    public void testRemove() {
        User user = entityManager.find(User.class, "ff8080815acadfd0015acadfd38d0000");
        entityManager.remove(user);
    }

    @Test
    public void testMerge() {
        User userMerge = entityManager.find(User.class, "ff8080815acad8bf015acad8c3b30000");
        entityManager.clear();
        User merge = entityManager.merge(userMerge);
        merge.setAge(10);
    }

    @After
    public void after() {
        entityManager.getTransaction().commit();
    }
}
