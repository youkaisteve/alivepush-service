package cn.sm.alivepush.auth.dao;

import cn.sm.alivepush.contract.entity.ApplicationUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Mapper
public interface UserDao {
    ArrayList<ApplicationUser> getUserList();
    ApplicationUser findByUsername(String userName);
    void save(ApplicationUser user);
}
