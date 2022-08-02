package com.aphea.cqqksrv.service;

import com.aphea.cqqksrv.entity.vo.CarInfoVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.aphea.cqqksrv.entity.CarInfo;

import java.util.List;
import java.util.Map;

/**
 * 车辆信息(CarInfo)表服务接口
 *
 * @author xuhang
 * @since 2022-08-02 11:03:41
 */
public interface CarInfoService extends IService<CarInfo> {

    Map<String, Object> selectListPageByUserId(String userId, Integer currentPage, Integer pageSize);
}

