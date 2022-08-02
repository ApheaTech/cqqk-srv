package com.aphea.cqqksrv.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.aphea.cqqksrv.dao.TUserRoleDao;
import com.aphea.cqqksrv.entity.TUserRole;
import com.aphea.cqqksrv.service.TUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * (TUserRole)表服务实现类
 *
 * @author xuhang
 * @since 2022-07-22 15:31:47
 */
@Service("tUserRoleService")
public class TUserRoleServiceImpl extends ServiceImpl<TUserRoleDao, TUserRole> implements TUserRoleService {

    @Autowired
    private RedisTemplate redisTemplate;

    public List<TUserRole> getUserRoleList() {

        List<TUserRole> userRoleList;

        if (redisTemplate.opsForValue().get("userRoleList") != null) {
            userRoleList = (List<TUserRole>) redisTemplate.opsForValue().get("userRoleList");
        }else {
            userRoleList = this.list();
            redisTemplate.opsForValue().set("userRoleList", userRoleList);
        }

        return userRoleList;
    }
}

