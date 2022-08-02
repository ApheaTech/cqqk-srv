package com.aphea.cqqksrv.entity.vo;

import lombok.Data;
import org.springframework.security.core.parameters.P;

/**
 * TODO
 *
 * @author 航
 * @date 2022/8/1 20:55
 */
@Data
public class LoginVO {

    private String smsCode;

    private String ucode;

    private String userPwd;

    private String userTel;

}
