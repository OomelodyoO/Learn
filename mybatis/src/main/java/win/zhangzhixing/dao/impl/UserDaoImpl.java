package win.zhangzhixing.dao.impl;

import org.apache.ibatis.session.SqlSession;
import win.zhangzhixing.dao.IUserDao;
import win.zhangzhixing.model.dto.UserDTO;
import win.zhangzhixing.model.vo.UserVO;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    private SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public UserVO create(UserDTO userDTO) {
        sqlSession.insert("insert", userDTO);
        return null;
    }

    @Override
    public UserVO update(Integer id, UserDTO userDTO) {
        userDTO.setId(id);
        sqlSession.update("update", userDTO);
        return null;
    }

    @Override
    public UserVO get(Integer id) {
        return sqlSession.selectOne("get", id);
    }

    @Override
    public List<UserVO> query() {
        return sqlSession.selectList("query");
    }

    @Override
    public void delete(Integer id) {
        sqlSession.delete("delete", id);
    }
}
