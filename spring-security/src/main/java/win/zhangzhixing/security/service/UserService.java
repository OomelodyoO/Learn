package win.zhangzhixing.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import win.zhangzhixing.security.entity.User;
import win.zhangzhixing.security.repository.UserRepository;

/**
 * @author zhangzhixing
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findByName(String name) {
        return userRepository.findByName(name);
    }
}
