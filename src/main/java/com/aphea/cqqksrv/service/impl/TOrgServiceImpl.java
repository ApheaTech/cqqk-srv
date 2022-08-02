package com.aphea.cqqksrv.service.impl;

import com.aphea.cqqksrv.entity.vo.OrgVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.aphea.cqqksrv.dao.TOrgDao;
import com.aphea.cqqksrv.entity.TOrg;
import com.aphea.cqqksrv.service.TOrgService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 系统组织(TOrg)表服务实现类
 *
 * @author xuhang
 * @since 2022-07-22 09:25:48
 */
@Service("tOrgService")
public class TOrgServiceImpl extends ServiceImpl<TOrgDao, TOrg> implements TOrgService {

    @Autowired
    private RedisTemplate redisTemplate;

    private List<OrgVO> orgList;

    @Override
    public OrgVO getOrgTree() {

        orgList = getOrgList();

        OrgVO rootOrg = orgList.stream().filter(orgVO -> orgVO.getParentOrgId().equals("0")).findAny().orElse(null);
        rootOrg.setChildOrganize(getChildrenOrg(rootOrg));

        return rootOrg;
    }

    public List<OrgVO> getChildrenOrg(OrgVO orgVO) {

        List<OrgVO> subOrgList = orgList.stream()
                .filter(org -> org.getParentOrgId().equals(orgVO.getOrgId()))
                .collect(Collectors.toList());

        for (OrgVO subOrg : subOrgList) {
            List<OrgVO> subChildrenOrg = getChildrenOrg(subOrg);
            subOrg.setChildOrganize(subChildrenOrg);
        }

        return subOrgList;
    }

    @Override
    public List<OrgVO> getOrgList() {

        TOrgDao baseMapper = this.baseMapper;
        List<TOrg> tOrgList = baseMapper.selectList(new QueryWrapper<TOrg>());
        List<OrgVO> list = tOrgList.stream().map(tOrg -> {
            OrgVO orgVO = new OrgVO();
            BeanUtils.copyProperties(tOrg, orgVO);
            return orgVO;
        }).collect(Collectors.toList());

        return list;
    }
}

