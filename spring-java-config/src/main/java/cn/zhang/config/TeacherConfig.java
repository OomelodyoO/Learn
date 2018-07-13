package cn.zhang.config;

import cn.zhang.dao.TeacherDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhangzhixing on 2017/3/13.
 */
@Configuration
public class TeacherConfig {
    @Bean
    public TeacherDao teacherDao() {
        return new TeacherDao();
    }
}
