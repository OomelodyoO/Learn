package cn.zhang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by zhangzhixing on 2017/3/13.
 */
@Configuration
@Import({StudentConfig.class, TeacherConfig.class})
@ImportResource(value = "classpath:application.xml")
public class AppConfig {
}
