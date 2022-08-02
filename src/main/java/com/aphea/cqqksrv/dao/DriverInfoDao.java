package com.aphea.cqqksrv.dao;

import com.aphea.cqqksrv.entity.vo.DriverInfoVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.aphea.cqqksrv.entity.DriverInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 驾驶员信息表(DriverInfo)表数据库访问层
 *
 * @author xuhang
 * @since 2022-08-02 13:39:01
 */
@Mapper
public interface DriverInfoDao extends BaseMapper<DriverInfo> {

    List<DriverInfoVO> selectListPageByWorkAreaOrgId(@Param("workAreaOrgId") String workAreaOrgId, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    Integer countByWorkAreaOrgId(String workAreaOrgId);
}

