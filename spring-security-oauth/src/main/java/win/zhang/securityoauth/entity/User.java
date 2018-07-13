package win.zhang.securityoauth.entity;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author zhangzhixing
 */
@Entity
@Table(name = "T_USER")
public class User implements Serializable {

    public interface simple {
    }

    public interface detail {
    }

    @Id
    @GeneratedValue(generator = "uuid-gen")
    @GenericGenerator(name = "uuid-gen", strategy = "uuid")
    @Column(length = 36, name = "uuid")
    private String uuid;
    @Column(length = 50, name = "name")
    private String name;
    @Column(length = 50, name = "password")
    private String password;
    @OneToMany
    @JoinTable(name = "T_AUTHORITY",
            joinColumns = @JoinColumn(name = "user_uuid"),
            inverseJoinColumns = @JoinColumn(name = "uuid"))
    private List<Authority> authorities;


    @JsonView({simple.class, detail.class})
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @JsonView({detail.class})
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonView({detail.class})
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
