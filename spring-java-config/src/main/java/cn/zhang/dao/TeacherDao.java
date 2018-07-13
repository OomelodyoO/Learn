package cn.zhang.dao;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhangzhixing on 2017/3/13.
 */
public class TeacherDao {
    @Autowired
    private StudentDao studentDao;

    public void doSomething() {
        studentDao.doSomething();
        System.out.println("teacher doSomething");
    }
}
