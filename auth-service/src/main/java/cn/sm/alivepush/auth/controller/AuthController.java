package cn.sm.alivepush.auth.controller;

import cn.sm.alivepush.contract.entity.ApplicationUser;
import cn.sm.alivepush.contract.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by youkai on 2017/9/18.
 */
@RestController
@RefreshScope
@RequestMapping("/auth")
public class AuthController {
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserService userService;

    @Value("${profile}")
    private String profile;

    public AuthController(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping("/info")
    public HashMap serviceInfo() {
        HashMap map = new HashMap();
        map.put("profile", profile);
        return map;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.save(user);
    }

    @GetMapping("/list")
    public ArrayList<ApplicationUser> getUserList() {
        return userService.getUserList();
    }
}
