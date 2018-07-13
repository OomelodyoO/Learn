import cn.zhang.dao.TeacherDao;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangzhixing on 2017/3/13.
 */
public class springTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        TeacherDao teacherDao = (TeacherDao) context.getBean("teacherDao");
        teacherDao.doSomething();
    }
}
