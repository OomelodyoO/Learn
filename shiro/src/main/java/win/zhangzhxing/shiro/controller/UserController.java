package win.zhangzhxing.shiro.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @GetMapping
    public String getUser() {
        return "getUser";
    }

    @PutMapping
    public String putUser() {
        return "putUser";
    }

    @PostMapping
    public String login() {
        return "login";
    }

    @PostMapping(value = "authentication")
    public String authentication(@RequestBody Map<String, String> map) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        UsernamePasswordToken token = new UsernamePasswordToken(
                map.get("username").toString(), map.get("password").toString()
        );
        subject.login(token);
        return "authentication";
    }

    @GetMapping(value = "logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "logout";
    }

    @GetMapping(value = "unauthentication")
    public String unauthentication() {
        return "unauthentication";
    }

    @GetMapping(value = "unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }

    @GetMapping(value = "success")
    public String success() {
        return "success";
    }
}
