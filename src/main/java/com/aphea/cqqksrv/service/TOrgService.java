package com.aphea.cqqksrv.service;

import com.aphea.cqqksrv.entity.vo.OrgVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.aphea.cqqksrv.entity.TOrg;

import java.util.List;

/**
 * 系统组织(TOrg)表服务接口
 *
 * @author xuhang
 * @since 2022-07-22 09:25:48
 */
public interface TOrgService extends IService<TOrg> {

    // TOrg getOrgTree();

    OrgVO getOrgTree();

    List<OrgVO> getOrgList();

}

