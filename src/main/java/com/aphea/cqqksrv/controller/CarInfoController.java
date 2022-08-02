package com.aphea.cqqksrv.controller;


import com.aphea.cqqksrv.entity.vo.CarInfoVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.aphea.cqqksrv.entity.CarInfo;
import com.aphea.cqqksrv.service.CarInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 车辆信息(CarInfo)表控制层
 *
 * @author xuhang
 * @since 2022-08-02 11:03:40
 */
@RestController
@RequestMapping("/cm/carInfo")
public class CarInfoController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CarInfoService carInfoService;

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param carInfo 查询实体
     * @return 所有数据
     */
    @PostMapping("/listAll")
    public com.aphea.cqqksrv.utils.R selectAll(@RequestBody Map<String, Object> map) {

        Map<String, Object> params = (Map<String, Object>) map.get("params");
        String userId = (String) params.get("userId");
        Integer currentPage = (Integer) params.get("currentPage");
        Integer pageSize = (Integer) params.get("pageSize");

        Map<String, Object> resultMap = this.carInfoService.selectListPageByUserId(userId, currentPage, pageSize);

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
        return success(this.carInfoService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param carInfo 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody CarInfo carInfo) {
        return success(this.carInfoService.save(carInfo));
    }

    /**
     * 修改数据
     *
     * @param carInfo 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody CarInfo carInfo) {
        return success(this.carInfoService.updateById(carInfo));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.carInfoService.removeByIds(idList));
    }
}

