package cn.zhang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by zhangzhixing on 2017/3/14.
 */
@EnableRedisHttpSession
public class Config {
    @Bean
    public LettuceConnectionFactory connectionFactory() {
        return new LettuceConnectionFactory();
    }
//    @Bean
//    public JedisConnectionFactory connectionFactory()
//    {
//        JedisConnectionFactory connection = new JedisConnectionFactory();
//        connection.setPort(6379);
//        connection.setHostName("localhost");
//        return connection;
//    }
}
