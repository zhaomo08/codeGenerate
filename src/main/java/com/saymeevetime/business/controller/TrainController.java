package com.saymeevetime.business.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.saymeevetime.business.service.ITrainService;
import com.saymeevetime.business.entity.Train;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.Map;

import com.saymeevetime.vo.PageVO;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 车次 前端控制器
 * </p>
 *
 * @author ChesterZhao
 * @version v1.0
 * @since 2023-12-06
 */
@Slf4j
@Api(tags = {"车次"})
@RestController
@RequestMapping("/business/train")
public class TrainController {
    @Autowired
    private ITrainService trainService;

    /**
     * 查询分页数据
     */
    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "当前页码", required = false, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pagesize", value = "分大小", required = false, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "searchMap", value = "任意参数组合", required = false, dataType = "Map")
    })
    @PostMapping(value = "/pagelist")
    public PageVO<Train> findListByPage(@RequestParam(name = "page", defaultValue = "1") int pageNum, @RequestParam(name = "pagesize", defaultValue = "20") int pageSize, @RequestParam Map searchMap) {
        IPage<Train> page = new Page<Train>(pageNum, pageSize);
        QueryWrapper<Train> queryWrapper = new QueryWrapper<Train>();
        if (searchMap != null & !searchMap.isEmpty()) {
            queryWrapper.allEq(searchMap);
        }
        return new PageVO<Train>(trainService.page(page, queryWrapper));
    }


    @ApiOperation(value = "查询数据(不分页)")
    @ApiImplicitParam(paramType = "query", name = "searchMap", value = "任意参数组合", required = false, dataType = "Map")
    @PostMapping("/list")
    @ResponseBody
    public List<Train> list(@RequestParam Map searchMap) {
        QueryWrapper<Train> queryWrapper = new QueryWrapper<Train>();
        if (searchMap != null & !searchMap.isEmpty()) {
            queryWrapper.allEq(searchMap);
        }
        return trainService.list(queryWrapper);
    }


    /**
     * 根据id查询
     */
    @ApiOperation(value = "根据id查询数据")
    @ApiImplicitParam(paramType = "query", name = "pkid", value = "主键", required = true, dataType = "String")
    @PostMapping(value = "/getById")
    public Train getById(@RequestParam("pkid") String pkid) {
        return trainService.getById(pkid);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "新增数据")
    @ApiImplicitParam(paramType = "body", name = "train", value = "json数据", required = true, dataType = "Train")
    @PostMapping(value = "/add")
    public boolean add(@RequestBody Train train) {
        return trainService.save(train);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除数据")
    @ApiImplicitParam(paramType = "query", name = "ids", value = "支持主键批量删除", required = true, dataType = "List")
    @PostMapping(value = "/del")
    public boolean delete(@RequestParam("ids") List<String> ids) {
        return trainService.removeByIds(ids);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "更新数据")
    @ApiImplicitParam(paramType = "body", name = "train", value = "json数据", required = true, dataType = "Train")
    @PostMapping(value = "/update")
    public boolean update(@RequestBody Train train) {
        return trainService.updateById(train);
    }

}
