package com.aphea.cqqksrv.service.impl;

import com.aphea.cqqksrv.dao.CarInfoDao;
import com.aphea.cqqksrv.entity.TOrg;
import com.aphea.cqqksrv.entity.vo.CarInfoVO;
import com.aphea.cqqksrv.entity.vo.DriverInfoVO;
import com.aphea.cqqksrv.service.TOrgService;
import com.aphea.cqqksrv.service.TUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.aphea.cqqksrv.dao.DriverInfoDao;
import com.aphea.cqqksrv.entity.DriverInfo;
import com.aphea.cqqksrv.service.DriverInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 驾驶员信息表(DriverInfo)表服务实现类
 *
 * @author xuhang
 * @since 2022-08-02 13:39:01
 */
@Service("driverInfoService")
public class DriverInfoServiceImpl extends ServiceImpl<DriverInfoDao, DriverInfo> implements DriverInfoService {

    @Autowired
    private TOrgService tOrgService;

    @Autowired
    private TUserService tUserService;

    @Override
    public Map<String, Object> selectListPageByUserId(String userId, Integer currentPage, Integer pageSize) {

        DriverInfoDao baseMapper = this.baseMapper;

        // 找到查询人所属的作业区
        String orgId = tUserService.getById(userId).getOrgId();
        String workAreaOrgId = tOrgService.getById(orgId).getLevel();

        // 查询从属于该作业区的驾驶员
        List<DriverInfoVO> driverInfoVOList = baseMapper.selectListPageByWorkAreaOrgId(workAreaOrgId, currentPage, pageSize);
        Integer total = baseMapper.countByWorkAreaOrgId(workAreaOrgId);;

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("list", driverInfoVOList);
        resultMap.put("total", total);

        return resultMap;
    }
}

