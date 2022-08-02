package com.aphea.cqqksrv.entity.vo;

import com.aphea.cqqksrv.entity.TRole;
import lombok.Data;

import java.util.List;

/**
 * TODO
 *
 * @author 航
 * @date 2022/8/1 21:41
 */
@Data
public class UserVO {

    private String userId;
    //性别（0-未知，1-男，2-女）
    private String sex;
    //账号类型
    private String userType;
    //手机号码
    private String userTel;
    //账号名称
    private String userName;
    //账号昵称
    private String userNickName;
    //部门ID
    private String orgId;
    //邮箱
    private String email;

    private String orgName;

    private String fullOrgName;

    private List<RoleVO> roleList;

    private String tokenId;

    private String homePage;

    private String isSuper;
}
