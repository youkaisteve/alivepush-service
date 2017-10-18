package cn.sm.alivepush.gateway.security;

import cn.sm.alivepush.contract.entity.ApplicationUser;
import cn.sm.alivepush.contract.service.UserService;
import cn.sm.alivepush.gateway.fegin.AuthClient;
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
    private AuthClient authClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationApplicationUser = authClient.findByUsername(username);

        if (applicationApplicationUser == null) {
            throw new UsernameNotFoundException(username);
        }

        return new User(applicationApplicationUser.getUsername(), applicationApplicationUser.getPassword(), Collections.emptyList());
    }
}
