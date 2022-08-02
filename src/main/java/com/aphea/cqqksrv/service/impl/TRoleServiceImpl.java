package com.aphea.cqqksrv.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.aphea.cqqksrv.dao.TRoleDao;
import com.aphea.cqqksrv.entity.TRole;
import com.aphea.cqqksrv.service.TRoleService;
import org.springframework.stereotype.Service;

/**
 * 系统角色(TRole)表服务实现类
 *
 * @author xuhang
 * @since 2022-07-22 15:29:20
 */
@Service("tRoleService")
public class TRoleServiceImpl extends ServiceImpl<TRoleDao, TRole> implements TRoleService {

}

