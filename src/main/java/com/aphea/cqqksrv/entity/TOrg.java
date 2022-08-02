package com.aphea.cqqksrv.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 系统组织(TOrg)表实体类
 *
 * @author xuhang
 * @since 2022-07-22 09:25:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class TOrg extends Model<TOrg> {

    //权限节点ID
    @TableId
    private String orgId;

    private String orgName;

    private String fullOrgName;

    private String parentOrgId;
    //层级（科级id）
    private String level;
    //所属的科室类型，0机关科室，1作业区
    private Integer orgType;

    private String orgAddress;

    private String createUser;

    private Date createDate;

    private String state;
    //平台类型（5-运营端)
    private String sysType;

    @TableField(exist = false)
    private List<TOrg> childrenOrganize;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.orgId;
    }
}

