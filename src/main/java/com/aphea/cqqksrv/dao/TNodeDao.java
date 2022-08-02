package com.aphea.cqqksrv.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.aphea.cqqksrv.entity.TNode;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统菜单(TNode)表数据库访问层
 *
 * @author xuhang
 * @since 2022-08-02 10:29:14
 */
@Mapper
public interface TNodeDao extends BaseMapper<TNode> {

}

