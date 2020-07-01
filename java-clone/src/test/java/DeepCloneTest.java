import org.junit.Test;
import win.zhangzhixing.model.DeepTeacher;
import win.zhangzhixing.model.Student;

public class DeepCloneTest {
    @Test
    public void deepCloneTest() throws CloneNotSupportedException {
        // 生成Student对象
        Student student = new Student();
        student.setAge(34);
        student.setName("zhangzhixing");
        // 生成DeepTeacher对象
        DeepTeacher deepTeacher = new DeepTeacher();
        deepTeacher.setName("zhangTeacher");
        deepTeacher.setStudent(student);
        // 克隆对象
        DeepTeacher deepTeacherClone = (DeepTeacher) deepTeacher.clone();
        // 改变克隆对象 引用类型对象的值
        deepTeacherClone.getStudent().setName("zhangzhiguang");

        System.out.println(deepTeacher);
        System.out.println(deepTeacherClone);
    }
}
