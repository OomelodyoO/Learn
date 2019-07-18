package win.zhangzhixing.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import win.zhangzhixing.user.micro.ServiceClient;

@RestController
@RequestMapping(path = "/base")
public class BaseController {
    //    private final RestTemplate restTemplate;
    private final ServiceClient serviceClient;

    public BaseController(
//            RestTemplate restTemplate,
            ServiceClient serviceClient
    ) {
//        this.restTemplate = restTemplate;
        this.serviceClient = serviceClient;
    }

    @GetMapping
    public String base() {
//        String forObject = restTemplate.getForObject("http://service/base/", String.class);
        String base = serviceClient.base();
        return "user" + base;
    }
}
