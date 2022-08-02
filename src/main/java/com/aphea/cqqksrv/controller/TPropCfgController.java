package com.aphea.cqqksrv.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.aphea.cqqksrv.entity.TPropCfg;
import com.aphea.cqqksrv.service.TPropCfgService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 属性配置表(TPropCfg)表控制层
 *
 * @author xuhang
 * @since 2022-08-02 14:01:05
 */
@RestController
@RequestMapping("/base/prop")
public class TPropCfgController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TPropCfgService tPropCfgService;

    /**
     * 分页查询所有数据
     *
     * @param page     分页对象
     * @param tPropCfg 查询实体
     * @return 所有数据
     */
    @PostMapping("listForPage")
    public com.aphea.cqqksrv.utils.R selectAll() {

        Map<String, Object> resultMap = this.tPropCfgService.selectAll();

        return com.aphea.cqqksrv.utils.R.ok().setResult(resultMap);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tPropCfgService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tPropCfg 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TPropCfg tPropCfg) {
        return success(this.tPropCfgService.save(tPropCfg));
    }

    /**
     * 修改数据
     *
     * @param tPropCfg 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TPropCfg tPropCfg) {
        return success(this.tPropCfgService.updateById(tPropCfg));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tPropCfgService.removeByIds(idList));
    }
}

