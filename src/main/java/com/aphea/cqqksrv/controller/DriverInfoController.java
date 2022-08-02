package com.aphea.cqqksrv.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.aphea.cqqksrv.entity.DriverInfo;
import com.aphea.cqqksrv.service.DriverInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 驾驶员信息表(DriverInfo)表控制层
 *
 * @author xuhang
 * @since 2022-08-02 13:39:01
 */
@RestController
@RequestMapping("/cm/driverInfo")
public class DriverInfoController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private DriverInfoService driverInfoService;

    /**
     * 分页查询所有数据
     *
     * @param page       分页对象
     * @param driverInfo 查询实体
     * @return 所有数据
     */
    @PostMapping("/listAll")
    public com.aphea.cqqksrv.utils.R selectAll(@RequestBody Map<String, Object> map) {

        Map<String, Object> params = (Map<String, Object>) map.get("params");
        String userId = (String) params.get("userId");
        Integer currentPage = (Integer) params.get("currentPage");
        Integer pageSize = (Integer) params.get("pageSize");

        Map<String, Object> resultMap = this.driverInfoService.selectListPageByUserId(userId, currentPage, pageSize);

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
        return success(this.driverInfoService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param driverInfo 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody DriverInfo driverInfo) {
        return success(this.driverInfoService.save(driverInfo));
    }

    /**
     * 修改数据
     *
     * @param driverInfo 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody DriverInfo driverInfo) {
        return success(this.driverInfoService.updateById(driverInfo));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.driverInfoService.removeByIds(idList));
    }
}

