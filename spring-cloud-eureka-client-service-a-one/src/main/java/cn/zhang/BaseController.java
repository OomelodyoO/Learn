package cn.zhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhangzhixing on 2017/3/28.
 */
@RestController
public class BaseController {
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        StringBuffer URL = new StringBuffer();
        List<ServiceInstance> serviceInstances = client.getInstances("SERVICE-A");
        for (ServiceInstance serviceInstance : serviceInstances) {
            String url = String.format("url:%s:%d,", serviceInstance.getHost(), serviceInstance.getPort());
            URL.append(url);
        }
        return URL.toString();
    }
}