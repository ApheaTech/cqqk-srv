package com.aphea.cqqksrv.dao;

import com.aphea.cqqksrv.entity.vo.CarInfoVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.aphea.cqqksrv.entity.CarInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 车辆信息(CarInfo)表数据库访问层
 *
 * @author xuhang
 * @since 2022-08-02 11:03:40
 */
@Mapper
public interface CarInfoDao extends BaseMapper<CarInfo> {

    List<CarInfoVO> selectListPageByWorkAreaOrgId(@Param("workAreaOrgId") String workAreaOrgId, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    Integer countByWorkAreaOrgId(String workAreaOrgId);
}

