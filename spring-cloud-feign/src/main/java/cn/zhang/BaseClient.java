package cn.zhang;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhangzhixing on 2017/5/24.
 */
@FeignClient(value = "SERVICE-A", fallback = BaseClientHystrix.class)
public interface BaseClient {
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    String list();
}
