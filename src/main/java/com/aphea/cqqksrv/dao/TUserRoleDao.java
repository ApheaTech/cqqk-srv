package com.aphea.cqqksrv.dao;

import com.aphea.cqqksrv.entity.TRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.aphea.cqqksrv.entity.TUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TUserRole)表数据库访问层
 *
 * @author xuhang
 * @since 2022-07-22 15:31:47
 */
@Mapper
public interface TUserRoleDao extends BaseMapper<TUserRole> {

    List<TRole> getRoleByUserId(@Param("userId") String userId);
}

