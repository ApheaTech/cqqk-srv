package com.aphea.cqqksrv.service.impl;

import com.aphea.cqqksrv.entity.vo.CarInfoVO;
import com.aphea.cqqksrv.service.TOrgService;
import com.aphea.cqqksrv.service.TUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.aphea.cqqksrv.dao.CarInfoDao;
import com.aphea.cqqksrv.entity.CarInfo;
import com.aphea.cqqksrv.service.CarInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 车辆信息(CarInfo)表服务实现类
 *
 * @author xuhang
 * @since 2022-08-02 11:03:41
 */
@Service("carInfoService")
public class CarInfoServiceImpl extends ServiceImpl<CarInfoDao, CarInfo> implements CarInfoService {

    @Autowired
    private TOrgService tOrgService;

    @Autowired
    private TUserService tUserService;

    // TODO 根据userID显示该部门的车
    @Override
    public Map<String, Object> selectListPageByUserId(String userId, Integer currentPage, Integer pageSize) {

        CarInfoDao baseMapper = this.baseMapper;

        // 找到查询人所属的作业区
        String orgId = tUserService.getById(userId).getOrgId();
        String workAreaOrgId = tOrgService.getById(orgId).getLevel();

        // 查询从属于该作业区的车辆
        List<CarInfoVO> carInfoVOList = baseMapper.selectListPageByWorkAreaOrgId(workAreaOrgId, currentPage, pageSize);
        Integer total = baseMapper.countByWorkAreaOrgId(workAreaOrgId);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("list", carInfoVOList);
        resultMap.put("total", total);

        return resultMap;
    }
}

