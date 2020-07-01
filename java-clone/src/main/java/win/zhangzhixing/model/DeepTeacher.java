package win.zhangzhixing.model;

public class DeepTeacher implements Cloneable{
    private String name;
    private Student student;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        DeepTeacher deepTeacher = (DeepTeacher)super.clone();
        deepTeacher.setStudent((Student) deepTeacher.getStudent().clone());
        return deepTeacher;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
