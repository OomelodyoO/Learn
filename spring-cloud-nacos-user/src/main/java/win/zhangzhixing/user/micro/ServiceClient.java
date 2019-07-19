package win.zhangzhixing.user.micro;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import win.zhangzhixing.user.micro.fallback.ServiceClientFallback;

@FeignClient(name = "service", fallback = ServiceClientFallback.class)
public interface ServiceClient {
    @GetMapping(path = "/base")
    String base();
}
