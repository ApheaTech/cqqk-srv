package com.aphea.cqqksrv.service;

import com.aphea.cqqksrv.entity.vo.UserVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.aphea.cqqksrv.entity.TUser;

import java.util.List;
import java.util.Map;

/**
 * 系统操作人(TUser)表服务接口
 *
 * @author xuhang
 * @since 2022-07-22 09:25:42
 */
public interface TUserService extends IService<TUser> {

    // Page getUserPage(Page page, TUser tUser);

    UserVO getByUserTel(String userTel);
}

