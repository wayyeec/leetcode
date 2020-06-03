package com.cwy.service.security;

import com.cwy.dao.mapper.impl.UserMapperImpl;
import com.cwy.dao.po.User;
import com.cwy.service.UserService;
import com.cwy.utils.TimeUtil;
import com.cwy.utils.enums.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wayyee
 * @Date: 2020/6/5 19:11
 * Describe: 用户登录处理
 */
@Service
public class CustomUserServiceImpl implements UserDetailsService{

    @Autowired
    UserMapperImpl userMapper;
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        User user = new User();
        user.setPhone(phone);
        User userUpd = userMapper.findUserByParam(user);

        if(userUpd == null){
            throw  new UsernameNotFoundException("用户不存在");
        }

        userUpd.setRecentlylanded(TimeUtil.getFormatDateForSix());
        userMapper.updateByPrimaryKeySelective(userUpd);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        String[] roles = userUpd.getRole().split(",");
        for (String role:roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+RoleEnum.getDescByCode(role)));
        }


        return new org.springframework.security.core.userdetails.User(userUpd.getUsername(), userUpd.getPassword(), authorities);
    }
}
