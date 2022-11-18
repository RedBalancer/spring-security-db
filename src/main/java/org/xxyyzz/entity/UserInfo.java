package org.xxyyzz.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Chunlong Zhang
 * @version 1.0.0
 * @ClassName UserInfo.java
 * @Description @TODO
 * @createTime 2022年11月17日 14:16:00
 */

@Data
@Entity
@Table( name="A_USERS",
        indexes = {@Index(name = "index_on_name",  columnList="user_name", unique = true) }
)
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    long Id;

    @Column(name="user_name", nullable = true, length = 63, unique = true)
    String userName;

    @Column(nullable = true, length = 128)
    String password;

    @Column(nullable = true, length = 10)
    String role;

    @Column
    int enabled;

}
