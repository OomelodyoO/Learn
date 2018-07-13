package win.zhangzhixing.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;


/**
 * @author zhangzhixing
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    String[] permit = new String[]{
            "/user/session", "/user/simple", "/user/detail"
    };

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .and()
                .authorizeRequests()
                .antMatchers(permit).permitAll()
                .antMatchers("/**").authenticated();
    }

    @Bean
    public static SCryptPasswordEncoder passwordEncoder() {
        return new SCryptPasswordEncoder();
    }
}