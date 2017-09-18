package cn.sm.alivepush.contract.entity;

import com.sun.xml.internal.ws.developer.Serialization;

/**
 * Created by youkai on 2017/8/18.
 */
@Serialization
public class ApplicationUser {
    private Long id;
    private String username;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
