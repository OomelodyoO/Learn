package cn.zhang.config;

import cn.zhang.dao.StudentDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhangzhixing on 2017/3/13.
 */
@Configuration
public class StudentConfig {
    @Bean
    public StudentDao studentDao() {
        return new StudentDao();
    }
}
