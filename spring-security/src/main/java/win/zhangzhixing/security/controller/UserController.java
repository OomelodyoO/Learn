package win.zhangzhixing.security.controller;


import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import win.zhangzhixing.security.entity.User;
import win.zhangzhixing.security.service.UserService;

/**
 * @author zhangzhixing
 */
@RestController
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String user(@RequestParam String name) {
        return userService.findByName(name).getPassword();
    }

    @GetMapping(value = "session")
    public String session() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return requestAttributes.getSessionId();
    }

    @GetMapping(value = "simple")
    @JsonView(User.simple.class)
    public User simple(@RequestParam String name) {
        return userService.findByName(name);
    }

    @GetMapping(value = "detail")
    @JsonView(User.detail.class)
    public User detail(@RequestParam String name) {
        return userService.findByName(name);
    }

    @GetMapping(value = "test")
    public String test(User user) {
        return "test";
    }
}
