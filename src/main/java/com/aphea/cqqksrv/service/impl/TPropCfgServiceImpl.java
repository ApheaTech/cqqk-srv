package com.aphea.cqqksrv.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.aphea.cqqksrv.dao.TPropCfgDao;
import com.aphea.cqqksrv.entity.TPropCfg;
import com.aphea.cqqksrv.service.TPropCfgService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 属性配置表(TPropCfg)表服务实现类
 *
 * @author xuhang
 * @since 2022-08-02 14:01:05
 */
@Service("tPropCfgService")
public class TPropCfgServiceImpl extends ServiceImpl<TPropCfgDao, TPropCfg> implements TPropCfgService {


    @Override
    public Map<String, Object> selectAll() {

        TPropCfgDao baseMapper = this.baseMapper;

        List<TPropCfg> tPropCfgList = baseMapper.selectList(new QueryWrapper<TPropCfg>().eq("PROP_GRP_NAME", "carClass"));
        int totalResults = this.count(new QueryWrapper<TPropCfg>().eq("PROP_GRP_NAME", "carClass"));

        HashMap<String, Object> map = new HashMap<>();
        map.put("list", tPropCfgList);
        map.put("totalResults", totalResults);

        return map;
    }
}

