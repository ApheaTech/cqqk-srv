package com.aphea.cqqksrv.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.aphea.cqqksrv.entity.TOrg;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统组织(TOrg)表数据库访问层
 *
 * @author xuhang
 * @since 2022-07-22 09:25:48
 */
@Mapper
public interface TOrgDao extends BaseMapper<TOrg> {

}

