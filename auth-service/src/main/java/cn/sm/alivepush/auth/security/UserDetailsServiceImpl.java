package cn.sm.alivepush.auth.security;

import cn.sm.alivepush.contract.entity.ApplicationUser;
import cn.sm.alivepush.contract.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * Created by youkai on 2017/8/15.
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationApplicationUser = userService.findByUsername(username);

        if (applicationApplicationUser == null) {
            throw new UsernameNotFoundException(username);
        }

        return new User(applicationApplicationUser.getUsername(), applicationApplicationUser.getPassword(), Collections.emptyList());
    }
}
