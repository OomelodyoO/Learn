package win.zhangzhixing.dao.impl;

import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import win.zhangzhixing.dao.IUserDao;
import win.zhangzhixing.model.dto.UserDTO;
import win.zhangzhixing.model.entity.User;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    private Session session;

    public UserDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public User create(User user) {
        session.save(user);
        return null;
    }

    @Override
    public User update(Integer id, UserDTO userDTO) {
        User user = session.get(User.class, id);
        if (!ObjectUtils.isEmpty(userDTO.getAge())) {
            user.setAge(userDTO.getAge());
        } else if (!ObjectUtils.isEmpty(userDTO.getGender())) {
            user.setGender(userDTO.getGender());
        } else if (!ObjectUtils.isEmpty(userDTO.getName())) {
            user.setName(userDTO.getName());
        }
        session.update(user);
        return null;
    }

    @Override
    public User get(Integer id) {
        return session.get(User.class, id);
    }

    @Override
    public List<User> query() {
        Query<User> userQuery = session.createQuery("from User", User.class);
        return userQuery.getResultList();
    }

    @Override
    public void delete(Integer id) {
        session.delete(session.get(User.class, id));
    }
}
