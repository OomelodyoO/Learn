package win.zhangzhixing.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;
import win.zhangzhixing.dao.impl.UserDaoImpl;
import win.zhangzhixing.model.dto.UserDTO;
import win.zhangzhixing.model.entity.User;

import java.util.List;

public class UserDaoTest {
    private IUserDao userDao;
    private Session session;

    @Before
    public void before() {
        Configuration configure = new Configuration().configure();
        SessionFactory sessionFactory = configure.buildSessionFactory();
        session = sessionFactory.openSession();
        userDao = new UserDaoImpl(session);
    }

    @Test
    public void testCreate() {
        User user = new User();
        user.setAge(12);
        user.setName("12");
        session.beginTransaction();
        userDao.create(user);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testUpdate() {
        UserDTO userDTO = new UserDTO();
        userDTO.setAge(1231);
        session.beginTransaction();
        userDao.update(9, userDTO);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testGet() {
        User user = userDao.get(6);
        System.out.println(user);
    }

    @Test
    public void testQuery() {
        List<User> query = userDao.query();
        System.out.println(query);
    }

    @Test
    public void testDelete() {
        session.beginTransaction();
        userDao.delete(9);
        session.getTransaction().commit();
        session.close();
    }
}
