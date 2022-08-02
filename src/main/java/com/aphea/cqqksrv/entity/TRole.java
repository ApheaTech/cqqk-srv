package com.aphea.cqqksrv.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 系统角色(TRole)表实体类
 *
 * @author xuhang
 * @since 2022-07-22 15:29:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class TRole extends Model<TRole> {
    //角色Id
    @TableField
    private String roleId;
    //角色名称
    private String roleName;
    //父级角色Id
    private String parentRoleId;
    //角色类型(0-目录，1-系统超级管理角色，7-系统管理员,9-普通角色)
    private String roleType;
    //备注
    private String remark;
    //创建人
    private String createUser;
    //创建时间
    private Date createDate;
    //状态（0-删除，1-有效，2-无效）
    private String isValid;
    //平台类型（5-运营端)
    private String sysType;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }
}

