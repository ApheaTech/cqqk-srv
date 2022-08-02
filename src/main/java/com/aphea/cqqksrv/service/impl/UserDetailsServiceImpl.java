package com.aphea.cqqksrv.service.impl;

import com.aphea.cqqksrv.entity.TUserRole;
import com.aphea.cqqksrv.service.TUserRoleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author 航
 * @date 2022/7/31 19:59
 */
@Component
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TUserRoleService tUserRoleService;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        //用户系统用的是三方免登,这里用userId作为唯一标识
        LambdaQueryWrapper<TUserRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TUserRole::getUserId, userId);
        List<TUserRole> userRoles = tUserRoleService.list(wrapper);
        List<SimpleGrantedAuthority> authorities = userRoles.stream().map(x ->
                new SimpleGrantedAuthority(x.getRoleId().toString()))
                .collect(Collectors.toList());

        //这里要填上用户的账号、密码(可以不填)和角色集合
        return new User(userId, "", authorities);
    }
}
