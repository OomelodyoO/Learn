package cn.zhang.service;

import cn.zhang.model.User;

import javax.persistence.EntityManager;

/**
 * Created by zhangzhixing on 2017/3/14.
 */
public interface UserService {
    String add(EntityManager entityManager, User user);
}
