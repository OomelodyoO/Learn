package cn.zhang.Initializer;

import cn.zhang.config.Config;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * Created by zhangzhixing on 2017/3/14.
 */
public class Initializer extends AbstractHttpSessionApplicationInitializer {
    public Initializer() {
        super(Config.class);
    }
}