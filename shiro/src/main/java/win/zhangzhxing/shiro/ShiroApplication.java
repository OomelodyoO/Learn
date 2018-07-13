package win.zhangzhxing.shiro;

import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.DelegatingFilterProxy;
import win.zhangzhxing.shiro.realm.ShiroRealm;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ShiroApplication {
    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;
    @Autowired
    private ShiroRealm shiroRealm;

    public static void main(String[] args) {
        SpringApplication.run(ShiroApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new DelegatingFilterProxy());
        registration.addUrlPatterns("/*");
        registration.setName("shiroFilter");
        return registration;
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        Map<String, String> map = new HashMap<>();
        map.put("/user/**:read", "authc,perms[user:read]");
        map.put("/user/**:create", "authc,perms[user:create]");
        map.put("/user/authentication", "anon");
        map.put("/user/unauthentication", "anon");
        map.put("/user/logout", "anon");
        map.put("/**", "authc");
        shiroFilterFactoryBean.setUnauthorizedUrl("/user/unauthorized");
        shiroFilterFactoryBean.setLoginUrl("/user/unauthentication");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    @Bean
    public JdbcRealm jdbcRealm() {
        shiroRealm.setDataSource(dataSource);
        return shiroRealm;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(JdbcRealm jdbcRealm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(jdbcRealm);
        return defaultWebSecurityManager;
    }


}
