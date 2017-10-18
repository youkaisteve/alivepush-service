package cn.sm.alivepush.gateway.fegin;

import cn.sm.alivepush.common.exception.BusinessException;
import cn.sm.alivepush.contract.entity.ApplicationUser;
import cn.sm.alivepush.contract.service.UserService;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author steve
 * @date 2017/10/18
 */
@FeignClient(name = "auth-service", fallback = AuthClient.HystrixClientFallback.class)
public interface AuthClient extends UserService{

    /**
     * 注册
     *
     * @param user 用户实体
     */
    @RequestMapping("/auth/save")
    void save(@RequestBody ApplicationUser user);

    /**
     * 根据userName获取用户
     *
     * @param userName 用户名
     * @return
     */
    @RequestMapping("/auth/user")
    ApplicationUser findByUsername(@RequestParam("userName") String userName);

    /**
     * 用户列表
     *
     * @return
     */
    @RequestMapping("/auth/list")
    ArrayList<ApplicationUser> getUserList();

    @Component
    class HystrixClientFallback implements AuthClient {
        @Override
        public ArrayList<ApplicationUser> getUserList() {
            return null;
        }

        @Override
        public ApplicationUser findByUsername(String userName) {
            return null;
        }

        @Override
        public void save(ApplicationUser user) {
            throw new BusinessException("保存失败");
        }
    }
}
