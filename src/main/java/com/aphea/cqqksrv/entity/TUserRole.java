package com.aphea.cqqksrv.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (TUserRole)表实体类
 *
 * @author xuhang
 * @since 2022-07-22 15:31:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class TUserRole extends Model<TUserRole> {
    //关联Id
    private String relateId;
    //用户Id
    private String userId;
    //角色id
    private String roleId;
    //创建人帐号
    private String createUser;
    //创建时间
    private Date createDate;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.relateId;
    }
}

