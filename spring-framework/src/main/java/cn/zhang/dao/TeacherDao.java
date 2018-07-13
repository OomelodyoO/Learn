package cn.zhang.dao;

/**
 * Created by zhangzhixing on 2017/3/13.
 */
public class TeacherDao {
    private StudentDao studentDao;

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void doSomething() {
        studentDao.doSomething();
        System.out.println("teacher doSomething");
    }
}
