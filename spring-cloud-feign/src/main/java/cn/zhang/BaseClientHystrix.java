package cn.zhang;

import org.springframework.stereotype.Component;

/**
 * Created by zhangzhixing on 2017/5/24.
 */
@Component
public class BaseClientHystrix implements BaseClient {
    @Override
    public String list() {
        return "Hystrix Error";
    }
}