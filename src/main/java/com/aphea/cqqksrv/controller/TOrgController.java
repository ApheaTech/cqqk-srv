package com.aphea.cqqksrv.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.aphea.cqqksrv.entity.TOrg;
import com.aphea.cqqksrv.service.TOrgService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 系统组织(TOrg)表控制层
 *
 * @author xuhang
 * @since 2022-07-22 09:25:48
 */
@RestController
@RequestMapping(value = {"/ops/server/sys/websysorganize", "/cm/server/sys/websysorganize"})
public class TOrgController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TOrgService tOrgService;

    @PostMapping("/getorganizetree")
    public com.aphea.cqqksrv.utils.R getOrgTree() {

        return com.aphea.cqqksrv.utils.R.ok().setResult(tOrgService.getOrgTree());
    }

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param tOrg 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TOrg> page, TOrg tOrg) {
        return success(this.tOrgService.page(page, new QueryWrapper<>(tOrg)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tOrgService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tOrg 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TOrg tOrg) {
        return success(this.tOrgService.save(tOrg));
    }

    /**
     * 修改数据
     *
     * @param tOrg 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TOrg tOrg) {
        return success(this.tOrgService.updateById(tOrg));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tOrgService.removeByIds(idList));
    }
}

