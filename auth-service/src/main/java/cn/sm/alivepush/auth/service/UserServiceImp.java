package cn.sm.alivepush.auth.service;


import cn.sm.alivepush.auth.dao.UserDao;
import cn.sm.alivepush.contract.entity.ApplicationUser;
import cn.sm.alivepush.contract.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by youkai on 2017/8/18.
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    public ArrayList<ApplicationUser> getUserList() {
        return userDao.getUserList();
    }

    public ApplicationUser findByUsername(String userName) {
        return userDao.findByUsername(userName);
    }

    public void save(ApplicationUser user) {
        userDao.save(user);
    }
}
