package com.aphea.cqqksrv.entity.vo;

import lombok.Data;

/**
 * TODO
 *
 * @author 航
 * @date 2022/8/1 22:40
 */
@Data
public class RoleVO {

    private String roleId;

    private String roleName;

    private String parentRoleId;

    private String parentRoleName;
}
