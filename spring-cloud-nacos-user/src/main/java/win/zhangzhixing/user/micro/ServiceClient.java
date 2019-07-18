package win.zhangzhixing.user.micro;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service")
public interface ServiceClient {
    @GetMapping(path = "/base")
    String base();
}
