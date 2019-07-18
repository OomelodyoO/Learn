package win.zhangzhixing.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "/base")
public class BaseController {
    private final RestTemplate restTemplate;

    public BaseController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String base() {
        String forObject = restTemplate.getForObject("http://service/base/", String.class);
        return "user" + forObject;
    }
}
