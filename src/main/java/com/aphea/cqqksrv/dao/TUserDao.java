package com.aphea.cqqksrv.dao;

import com.aphea.cqqksrv.entity.TRole;
import com.aphea.cqqksrv.entity.vo.UserVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.aphea.cqqksrv.entity.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统操作人(TUser)表数据库访问层
 *
 * @author xuhang
 * @since 2022-07-22 09:25:42
 */
@Mapper
public interface TUserDao extends BaseMapper<TUser> {

    // List<TUserEx> getAllUserEx();

    UserVO getUserByUserTel(@Param("userTel") String userTel);

}

