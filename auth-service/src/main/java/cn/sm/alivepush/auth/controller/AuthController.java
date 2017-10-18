package cn.sm.alivepush.auth.controller;

import cn.sm.alivepush.contract.entity.ApplicationUser;
import cn.sm.alivepush.contract.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author youkai
 * @date 2017/9/18
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ApplicationUser findByUsername(@RequestParam String userName) {
        return userService.findByUsername(userName);
    }

    @PostMapping("/save")
    public void save(@RequestBody ApplicationUser user) {
        userService.save(user);
    }

    @GetMapping("/list")
    public ArrayList<ApplicationUser> getUserList() {
        return userService.getUserList();
    }
}
