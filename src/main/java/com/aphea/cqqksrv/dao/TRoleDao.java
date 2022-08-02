package com.aphea.cqqksrv.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.aphea.cqqksrv.entity.TRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统角色(TRole)表数据库访问层
 *
 * @author xuhang
 * @since 2022-07-22 15:29:19
 */
@Mapper
public interface TRoleDao extends BaseMapper<TRole> {

}

