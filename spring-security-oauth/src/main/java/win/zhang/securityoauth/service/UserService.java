package win.zhang.securityoauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import win.zhang.securityoauth.entity.User;
import win.zhang.securityoauth.repository.UserRepository;

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

    public User findByUuid(String uuid) {
        return userRepository.findOne(uuid);
    }
}
