package cn.sm.alivepush.auth.controller;

import cn.sm.alivepush.contract.entity.ApplicationUser;
import cn.sm.alivepush.contract.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by youkai on 2017/9/18.
 */
@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<ApplicationUser> getUserList() {
        return userService.getUserList();
    }
}
