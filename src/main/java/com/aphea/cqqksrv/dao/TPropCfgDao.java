package com.aphea.cqqksrv.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.aphea.cqqksrv.entity.TPropCfg;
import org.apache.ibatis.annotations.Mapper;

/**
 * 属性配置表(TPropCfg)表数据库访问层
 *
 * @author xuhang
 * @since 2022-08-02 14:01:05
 */
@Mapper
public interface TPropCfgDao extends BaseMapper<TPropCfg> {

}

