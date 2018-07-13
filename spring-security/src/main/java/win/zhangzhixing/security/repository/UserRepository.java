package win.zhangzhixing.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import win.zhangzhixing.security.entity.User;

/**
 * @author zhangzhixing
 */
@Repository
public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
    /**
     * @param name
     * @return
     */
    User findByName(String name);
}
