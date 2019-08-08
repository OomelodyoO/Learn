package win.zhangzhixing.dao;

import win.zhangzhixing.model.dto.UserDTO;
import win.zhangzhixing.model.vo.UserVO;

import java.util.List;

public interface IUserDao {
    UserVO create(UserDTO userDTO);

    UserVO update(Integer id, UserDTO userDTO);

    UserVO get(Integer id);

    List<UserVO> query();

    void delete(Integer id);
}
