package win.zhang.securityoauth.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zhangzhixing
 */
@Entity
@Table(name = "T_AUTHORITY")
public class Authority implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid-gen")
    @GenericGenerator(name = "uuid-gen", strategy = "uuid")
    @Column(length = 36, name = "uuid")
    private String uuid;
    @Column(length = 36, name = "user_uuid")
    private String userUuid;
    @Column(length = 100, name = "authority_name")
    private String authorityName;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }
}
