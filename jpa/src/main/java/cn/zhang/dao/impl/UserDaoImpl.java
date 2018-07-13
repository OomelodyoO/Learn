package cn.zhang.dao.impl;

import cn.zhang.dao.UserDao;
import cn.zhang.model.User;

import javax.persistence.EntityManager;

/**
 * Created by zhangzhixing on 2017/3/14.
 */
public class UserDaoImpl implements UserDao {
    public String add(EntityManager entityManager, User user) {
        entityManager.persist(user);
        return user.getUuid();
    }
}
