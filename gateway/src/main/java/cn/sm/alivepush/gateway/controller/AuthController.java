package cn.sm.alivepush.gateway.controller;

import cn.sm.alivepush.contract.entity.ApplicationUser;
import cn.sm.alivepush.gateway.fegin.AuthClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by youkai on 2017/10/17.
 */
@RestController
@RefreshScope
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthClient authClient;

//    @Value("${profile}")
//    private String profile;
//
//    @GetMapping("/info")
//    public HashMap serviceInfo() {
//        HashMap map = new HashMap();
//        map.put("profile", profile);
//        return map;
//    }

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthController(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        authClient.save(user);
    }

    @GetMapping("/list")
    public ArrayList<ApplicationUser> list() {
        return authClient.getUserList();
    }
}
