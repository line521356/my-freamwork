package com.lucius.business.model.caspain;

import com.lucius.common.support.model.base.BaseModel;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "auth_user")
@org.hibernate.annotations.Table(appliesTo = "auth_user", comment = "用户表")
public class AuthUser implements Serializable {
    private static final Long serialVersionUID = -530914243116630842L;

    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "identity")
    @Column(length = 32, nullable = false, unique = true, columnDefinition = "int(11) comment '用户Id主键'")
    private Long id;

    @Column(name = "password", columnDefinition = "varchar(128) comment '密码'")
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_login", columnDefinition = "datetime(6) comment '最后一次登录时间'", updatable = false)
    private Date lastLogin;

    @Column(name = "is_superuser", columnDefinition = "tinyint(1) comment '是否是超级用户'")
    private Long isSuperuser;

    @Column(name = "username", columnDefinition = "varchar(30) comment '用户姓名'", unique = true)
    private String username;

    @Column(name = "first_name", columnDefinition = "varchar(30) comment '姓氏'")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "varchar(30) comment '名'")
    private String lastName;

    @Column(name = "email", columnDefinition = "varchar(254) comment '邮箱'")
    private String email;

    @Column(name = "is_staff", columnDefinition = "tinyint(1) comment ''")
    private Long isStaff;

    @Column(name = "is_active", columnDefinition = "tinyint(1) comment ''")
    private Long isActive;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_joined", columnDefinition = "datetime(6) comment '加入时间'",updatable = false)
    private Date dateJoined;

}
