package com.aphea.cqqksrv.entity.vo;

import com.aphea.cqqksrv.entity.TOrg;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * TODO
 *
 * @author 航
 * @date 2022/8/2 8:08
 */
@Data
@ToString
public class OrgVO {

    private String orgId;

    private String orgName;

    private String fullOrgName;

    private String parentOrgId;

    private String state;

    private String createUser;

    private List<OrgVO> childOrganize;
}
