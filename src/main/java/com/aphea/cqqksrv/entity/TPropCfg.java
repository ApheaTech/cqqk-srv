package com.aphea.cqqksrv.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 属性配置表(TPropCfg)表实体类
 *
 * @author xuhang
 * @since 2022-08-02 14:01:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class TPropCfg extends Model<TPropCfg> {
    //ID
    private Integer propId;
    //属性组名称(如系统配置)
    private String propGrpName;
    //属性物理名称
    private String propLogicName;
    //属性逻辑名称
    private String propPhysicalName;
    //属性值
    private String propValue;
    //属性备注
    private String propNote;
    //是否可修改(0-不可修改，1-可修改)
    private String canEdit;
    //创建人
    private String createUser;
    //创建时间
    private Date createDt;
    //是否有效
    private String isValid;
    //修改人
    private String modifyUser;
    //修改时间
    private Date modifyDt;
    //属性适用调用类型
    private String propCallType;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.propId;
    }
}

