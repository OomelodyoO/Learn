package win.zhangzhixing.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Basic
    @Column(name = "AGE")
    private Integer age;
    @Basic
    @Column(name = "GENDER")
    private Boolean gender;
    @Basic
    @Column(name = "NAME")
    private String name;
}
