package org.xxyyzz.entity;

import javax.persistence.*;

/**
 * @author Chunlong Zhang
 * @version 1.0.0
 * @ClassName UserInfo.java
 * @Description @TODO
 * @createTime 2022年11月17日 14:16:00
 */

@Entity
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    long Id;

    String userName;

    String password;

    String role;

    int enabled;


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

}
