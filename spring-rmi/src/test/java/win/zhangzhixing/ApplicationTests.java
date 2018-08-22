package win.zhangzhixing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.test.context.junit4.SpringRunner;
import win.zhangzhixing.service.EchoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    RmiProxyFactoryBean rmiProxyFactoryBean;

    @Test
    public void contextLoads() {
    }

    @Test
    public void echoServiceTest() {
        EchoService echoService = (EchoService) rmiProxyFactoryBean.getObject();
        System.out.println(echoService.echo("Zhang"));
    }

}
