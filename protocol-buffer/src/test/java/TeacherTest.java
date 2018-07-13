import cn.zhang.model.StudentProtos;
import cn.zhang.model.TeacherProtos;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by zhangzhixing on 2017/4/11.
 */
public class TeacherTest {
    @Test
    public void test() throws IOException {
        StudentProtos.Student student = StudentProtos.Student.newBuilder()
                .setId(1)
                .setName("Zhang")
                .setAge(30)
                .build();
        FileOutputStream output = new FileOutputStream("./proto_bin/Student.bin");
        student.writeTo(output);
        output.close();

        TeacherProtos.Teacher teacher = TeacherProtos.Teacher.newBuilder()
                .setId(2)
                .setName("Zhang")
                .setAge(60)
                .addStudent(student)
                .build();
        output = new FileOutputStream("./proto_bin/Teacher.bin");
        teacher.writeTo(output);
        output.close();
    }
}
