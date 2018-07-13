package win.zhangzhxing.shiro.realm;

import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.springframework.stereotype.Component;

@Component
public class ShiroRealm extends JdbcRealm {
    protected static final String DEFAULT_AUTHENTICATION_QUERY = "select password from t_user where username = ?";
    protected static final String DEFAULT_PERMISSIONS_QUERY = "select permission from t_roles_permissions where role_name = ?";
    protected static final String DEFAULT_USER_ROLES_QUERY = "select role_name from t_user_roles where username = ?";

    public ShiroRealm() {
        setAuthenticationQuery(DEFAULT_AUTHENTICATION_QUERY);
        setPermissionsQuery(DEFAULT_PERMISSIONS_QUERY);
        setUserRolesQuery(DEFAULT_USER_ROLES_QUERY);
        setPermissionsLookupEnabled(true);
    }
}
