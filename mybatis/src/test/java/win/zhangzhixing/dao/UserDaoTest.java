package win.zhangzhixing.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import win.zhangzhixing.dao.impl.UserDaoImpl;
import win.zhangzhixing.model.dto.UserDTO;
import win.zhangzhixing.model.vo.UserVO;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDaoTest {
    private final String resource = "SqlMapConfig.xml";
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
        sqlSession = sqlSessionFactory.openSession();
        userDao = new UserDaoImpl(sqlSession);
    }

    @Test
    public void testCreate() {
        UserDTO userDTO = new UserDTO();
        userDTO.setAge(1);
        userDTO.setGender(true);
        userDTO.setName("1");
        userDao.create(userDTO);
        sqlSession.commit();
        System.out.println(userDao.get(userDTO.getId()));
        sqlSession.close();
    }

    @Test
    public void testUpdate() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1);
        userDTO.setAge(11);
        userDTO.setGender(false);
        userDTO.setName("11");
        userDao.update(1, userDTO);
        sqlSession.commit();
        System.out.println(userDao.get(userDTO.getId()));
        sqlSession.close();
    }

    @Test
    public void testGet() {
        UserVO userVO = userDao.get(2);
        System.out.println(userVO);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testQuery() {
        List<UserVO> userVOList = userDao.query();
        System.out.println(userVOList);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDelete() {
        userDao.delete(1);
        sqlSession.commit();
        sqlSession.close();
    }
}
