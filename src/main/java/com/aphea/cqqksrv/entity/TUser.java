package com.aphea.cqqksrv.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 系统操作人(TUser)表实体类
 *
 * @author xuhang
 * @since 2022-07-22 09:25:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class TUser extends Model<TUser> {
    //用户ID
    @TableId
    private String userId;
    //密码
    private String userPass;
    //性别（0-未知，1-男，2-女）
    private String userSex;
    //账号类型
    private String userType;
    //手机号码
    private String userTel;
    //账号名称
    private String userName;
    //账号昵称
    private String userNickname;
    //部门ID
    private String orgId;
    //状态(0-删除，1-有效，2-禁用)
    private String isValid;
    //用户头像
    private String userHead;
    //用户数据传输密钥（8位随机）
    private String encodeKey;
    //生效时间
    private Date beginDate;
    //失效时间
    private Date endDate;
    //邮箱
    private String email;
    //是否推送（0-否，1-是）
    private String isPush;
    //图标
    private String remark;
    //创建人帐号
    private String createUser;
    //创建时间
    private Date createDate;
    //修改人
    private String modifyUser;
    //修改时间
    private Date modifyDate;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.userId;
    }


}

