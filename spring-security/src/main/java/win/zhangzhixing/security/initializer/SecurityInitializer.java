package win.zhangzhixing.security.initializer;

import org.apache.catalina.security.SecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import win.zhangzhixing.security.config.SessionConfiguration;

/**
 * @author zhangzhixing
 */
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    public SecurityInitializer() {
        super(SecurityConfig.class, SessionConfiguration.class);
    }
}