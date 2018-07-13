import cn.zhang.config.AppConfig;
import cn.zhang.config.StudentConfig;
import cn.zhang.config.TeacherConfig;
import cn.zhang.dao.CoursesDao;
import cn.zhang.dao.TeacherDao;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by zhangzhixing on 2017/3/13.
 */
public class springConfigTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class, TeacherConfig.class);
        TeacherDao teacherDao = (TeacherDao) context.getBean("teacherDao");
        teacherDao.doSomething();
    }

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TeacherDao teacherDao = (TeacherDao) context.getBean("teacherDao");
        teacherDao.doSomething();
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TeacherDao teacherDao = (TeacherDao) context.getBean("teacherDao");
        teacherDao.doSomething();
        CoursesDao coursesDao = (CoursesDao) context.getBean("coursesDao");
        coursesDao.doSomething();
    }
}
