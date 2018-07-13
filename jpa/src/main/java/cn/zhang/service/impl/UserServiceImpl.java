package cn.zhang.service.impl;

import cn.zhang.dao.impl.UserDaoImpl;
import cn.zhang.model.User;
import cn.zhang.service.UserService;

import javax.persistence.EntityManager;

/**
 * Created by zhangzhixing on 2017/3/14.
 */
public class UserServiceImpl implements UserService {
    public String add(EntityManager entityManager, User user) {
        return new UserDaoImpl().add(entityManager, user);
    }
}
