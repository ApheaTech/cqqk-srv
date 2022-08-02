package com.aphea.cqqksrv.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.aphea.cqqksrv.entity.TPropCfg;

import java.util.Map;

/**
 * 属性配置表(TPropCfg)表服务接口
 *
 * @author xuhang
 * @since 2022-08-02 14:01:05
 */
public interface TPropCfgService extends IService<TPropCfg> {

    Map<String, Object> selectAll();
}

