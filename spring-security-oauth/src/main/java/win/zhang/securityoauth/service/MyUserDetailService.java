package win.zhang.securityoauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import win.zhang.securityoauth.entity.MyUserDetail;
import win.zhang.securityoauth.entity.User;
import win.zhang.securityoauth.repository.UserRepository;

import javax.transaction.Transactional;

@Component
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);
        return new MyUserDetail(user.getName(), user.getPassword(), user.getAuthorities());
    }
}
