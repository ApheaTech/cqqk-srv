package com.aphea.cqqksrv.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.aphea.cqqksrv.entity.DriverInfo;

import java.util.Map;

/**
 * 驾驶员信息表(DriverInfo)表服务接口
 *
 * @author xuhang
 * @since 2022-08-02 13:39:01
 */
public interface DriverInfoService extends IService<DriverInfo> {

    Map<String, Object> selectListPageByUserId(String userId, Integer currentPage, Integer pageSize);
}

