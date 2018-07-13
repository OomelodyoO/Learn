import cn.zhang.model.User;
import cn.zhang.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangzhixing on 2017/3/14.
 */
public class springDataJpaTest {
    public static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");

    @Test
    public void test() {
        UserService userService = (UserService) applicationContext.getBean("userService");
        User user = new User("zhang", 30);
        userService.add(user);
    }
}
