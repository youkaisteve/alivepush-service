package cn.sm.alivepush.contract.service;


import cn.sm.alivepush.contract.entity.ApplicationUser;

import java.util.ArrayList;

/**
 * Created by youkai on 2017/8/18.
 */
public interface UserService {
    ArrayList<ApplicationUser> getUserList();
    ApplicationUser findByUsername(String userName);
    void save(ApplicationUser user);
}
