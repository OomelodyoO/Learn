package cn.zhang;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zhangzhixing on 2017/3/28.
 */
@Service
public class BaseService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService() {
        return restTemplate.getForEntity("http://SERVICE-B/list", String.class).getBody();
    }

    public String addServiceFallback() {
        return "Hystrix Error";
    }
}