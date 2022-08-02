package com.aphea.cqqksrv.service.impl;

import com.aphea.cqqksrv.dao.TUserRoleDao;
import com.aphea.cqqksrv.entity.TOrg;
import com.aphea.cqqksrv.entity.TRole;
import com.aphea.cqqksrv.entity.TUserRole;
import com.aphea.cqqksrv.entity.vo.UserVO;
import com.aphea.cqqksrv.service.TOrgService;
import com.aphea.cqqksrv.service.TRoleService;
import com.aphea.cqqksrv.service.TUserRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.aphea.cqqksrv.dao.TUserDao;
import com.aphea.cqqksrv.entity.TUser;
import com.aphea.cqqksrv.service.TUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 系统操作人(TUser)表服务实现类
 *
 * @author xuhang
 * @since 2022-07-22 09:25:42
 */
@Service("tUserService")
public class TUserServiceImpl extends ServiceImpl<TUserDao, TUser> implements TUserService {

    @Autowired
    private TUserDao tUserDao;

    @Autowired
    private TRoleService tRoleService;

    @Autowired
    private TUserRoleService tUserRoleService;

    @Autowired
    private TUserRoleDao tUserRoleDao;

    @Autowired
    private RedisTemplate redisTemplate;

    // @Override
    // public Page getUserPage(Page page, TUser tUser) {
    //
    //     int current = (int) page.getCurrent();
    //     int size = (int) page.getSize();
    //
    //     List<UserVO> userExList = getUserExList();
    //     List<UserVO> userExSubList = userExList.subList(current, size);
    //
    //     // 查找拥有的角色
    //     for (UserVO tUserEx : userExSubList) {
    //         tUserEx.setRoleList(tUserRoleDao.getRoleByUserId(tUserEx.getUserId()));
    //     }
    //
    //     page.setRecords(userExSubList);
    //     page.setTotal(userExSubList.size());
    //
    //     return page;
    // }

    @Override
    public UserVO getByUserTel(String userTel) {

        TUserDao baseMapper = this.baseMapper;
        UserVO user = baseMapper.getUserByUserTel(userTel);

        return user;
    }

    // public List<UserVO> getUserExList() {
    //
    //     List<UserVO> userExList;
    //     if (redisTemplate.opsForValue().get("userExList") != null) {
    //         userExList = (List<UserVO>) redisTemplate.opsForValue().get("userExList");
    //     }else {
    //         userExList = tUserDao.getAllUserEx();
    //
    //         redisTemplate.opsForValue().set("userExList", userExList);
    //     }
    //
    //     return userExList;
    // }
}

