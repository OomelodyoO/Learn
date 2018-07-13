package cn.zhang.dao;

import cn.zhang.model.User;

import javax.persistence.EntityManager;

/**
 * Created by zhangzhixing on 2017/3/14.
 */
public interface UserDao {
    String add(EntityManager entityManager, User user);
}
