package com.aphea.cqqksrv.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.aphea.cqqksrv.entity.TRole;
import com.aphea.cqqksrv.service.TRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 系统角色(TRole)表控制层
 *
 * @author xuhang
 * @since 2022-07-22 15:29:19
 */
@RestController
@RequestMapping("tRole")
public class TRoleController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TRoleService tRoleService;

    /**
     * 分页查询所有数据
     *
     * @param page  分页对象
     * @param tRole 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TRole> page, TRole tRole) {
        return success(this.tRoleService.page(page, new QueryWrapper<>(tRole)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tRoleService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tRole 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TRole tRole) {
        return success(this.tRoleService.save(tRole));
    }

    /**
     * 修改数据
     *
     * @param tRole 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TRole tRole) {
        return success(this.tRoleService.updateById(tRole));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tRoleService.removeByIds(idList));
    }
}

