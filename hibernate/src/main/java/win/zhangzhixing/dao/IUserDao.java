package win.zhangzhixing.dao;

import win.zhangzhixing.model.dto.UserDTO;
import win.zhangzhixing.model.entity.User;

import java.util.List;

public interface IUserDao {
    User create(User user);

    User update(Integer id, UserDTO userDTO);

    User get(Integer id);

    List<User> query();

    void delete(Integer id);
}
