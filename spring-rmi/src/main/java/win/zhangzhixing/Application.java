package win.zhangzhixing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.remoting.rmi.RmiServiceExporter;
import win.zhangzhixing.service.EchoService;
import win.zhangzhixing.service.impl.EchoServiceImpl;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Value("${zhang.rmi.host:localhost}")
    private String rmiHost;
    @Value("${zhang.rmi.port:5566}")
    private int rmiPort;
    @Value("${zhang.rmi.serviceName:EchoService}")
    private String rmiServiceName;

    @Bean
    public EchoService echoService() {
        return new EchoServiceImpl();
    }


    @Bean
    public RmiServiceExporter exporter() {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName(rmiServiceName);
        rmiServiceExporter.setService(echoService());
        rmiServiceExporter.setServiceInterface(EchoService.class);
        rmiServiceExporter.setRegistryPort(rmiPort);
        return rmiServiceExporter;
    }

    @Bean
    RmiProxyFactoryBean rmiProxyFactoryBean() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl(String.format("rmi://%s:%s/%s", rmiHost, rmiPort, rmiServiceName));
        rmiProxyFactoryBean.setServiceInterface(EchoService.class);
        return rmiProxyFactoryBean;
    }

}