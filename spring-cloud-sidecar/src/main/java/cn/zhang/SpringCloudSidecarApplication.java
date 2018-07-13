package cn.zhang;

import com.netflix.appinfo.HealthCheckHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableSidecar
public class SpringCloudSidecarApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudSidecarApplication.class, args);
    }

    @Bean
    public HealthCheckHandler healthCheckHandler() {
        return new BaseHealthCheckHandler();
    }
}
