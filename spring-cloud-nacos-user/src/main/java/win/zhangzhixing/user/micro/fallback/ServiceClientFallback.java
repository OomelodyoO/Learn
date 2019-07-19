package win.zhangzhixing.user.micro.fallback;

import org.springframework.stereotype.Component;
import win.zhangzhixing.user.micro.ServiceClient;

@Component
public class ServiceClientFallback implements ServiceClient {
    @Override
    public String base() {
        return "service base error";
    }
}
