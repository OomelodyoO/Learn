package cn.zhang.service.impl;

import cn.zhang.dao.UserRepository;
import cn.zhang.model.User;
import cn.zhang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangzhixing on 2017/3/14.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public User add(User user) {
        return userRepository.save(user);
    }
}
