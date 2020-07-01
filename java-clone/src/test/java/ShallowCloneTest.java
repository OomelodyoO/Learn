import org.junit.Test;
import win.zhangzhixing.model.ShallowTeacher;
import win.zhangzhixing.model.Student;

public class ShallowCloneTest {
    @Test
    public void shallowCloneTest() throws CloneNotSupportedException {
        // 生成Student对象
        Student student = new Student();
        student.setAge(34);
        student.setName("zhangzhixing");
        // 生成DeepTeacher对象
        ShallowTeacher shallowTeacher = new ShallowTeacher();
        shallowTeacher.setName("zhangTeacher");
        shallowTeacher.setStudent(student);
        // 克隆对象
        ShallowTeacher shallowTeacherClone = (ShallowTeacher) shallowTeacher.clone();
        // 改变克隆对象 引用类型对象的值
        shallowTeacherClone.getStudent().setName("zhangzhiguang");

        System.out.println(shallowTeacher);
        System.out.println(shallowTeacherClone);
    }
}
