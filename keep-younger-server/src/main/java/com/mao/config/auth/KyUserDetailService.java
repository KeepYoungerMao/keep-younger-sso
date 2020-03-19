package com.mao.config.auth;

import com.mao.entity.sys.User;
import com.mao.service.sys.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * spring security 用户身份认证
 * @author mao by 11:17 2020/3/18
 */
@Component
public class KyUserDetailService implements UserDetailsService {

    private SystemService systemService;

    @Autowired
    public void setSystemService(SystemService systemService){
        this.systemService = systemService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = systemService.getUserByName(username);
        if (null == user) throw new UsernameNotFoundException("cannot load message by this username");
        return user;
    }

}