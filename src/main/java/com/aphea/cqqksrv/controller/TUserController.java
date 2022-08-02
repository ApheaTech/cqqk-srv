package com.aphea.cqqksrv.controller;


import com.alibaba.fastjson.JSON;
import com.aphea.cqqksrv.entity.vo.LoginVO;
import com.aphea.cqqksrv.entity.vo.UserVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.aphea.cqqksrv.entity.TUser;
import com.aphea.cqqksrv.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 系统操作人(TUser)表控制层
 *
 * @author xuhang
 * @since 2022-07-22 09:25:42
 */
@RestController
@RequestMapping("user")
public class TUserController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TUserService tUserService;

    @PostMapping("/login/byPwd")
    public com.aphea.cqqksrv.utils.R loginByPwd(@RequestBody Map<String, Object> map) {

        LoginVO loginVO = JSON.parseObject(JSON.toJSONString(map.get("params")), LoginVO.class);

        UserVO userVO = tUserService.getByUserTel(loginVO.getUserTel());

        // TODO
        userVO.setHomePage("/operateHome");
        userVO.setIsSuper("0");

        return com.aphea.cqqksrv.utils.R.ok("登陆成功").setResult(userVO);
    }
    /**
     * 分页查询所有数据
     *
     * @param current  分页对象
     * @param size 查询实体
     * @return 所有数据
     */
    @GetMapping("/{current}/{size}")
    public R selectAll(@PathVariable("current") long current,
                       @PathVariable("size") int size) {

        Page<TUser> page = new Page<>(current, size);
        TUser tUser = new TUser();

        // return success(this.tUserService.getUserPage(page, tUser));
        return success(null);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tUserService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tUser 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TUser tUser) {
        return success(this.tUserService.save(tUser));
    }

    /**
     * 修改数据
     *
     * @param tUser 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TUser tUser) {
        return success(this.tUserService.updateById(tUser));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tUserService.removeByIds(idList));
    }
}

