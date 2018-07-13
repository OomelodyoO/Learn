package cn.zhang.dao;

import cn.zhang.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by zhangzhixing on 2017/3/14.
 */
public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
}
