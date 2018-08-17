package com.jd.jdemo.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.jd.jdemo.common.InvokeResult;
import com.jd.jdemo.dto.request.DemoRequest;
import com.jd.jdemo.dto.response.DemoResponse;
import com.jd.jdemo.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/demo", produces = {MediaType.APPLICATION_JSON_VALUE})
@Slf4j
@Api(description = "演示类")
public class DemoController {
    @Autowired
    private DemoService demoService;

    /**
     * 单条数据插入
     *
     * @param demoRequest
     */
    @ApiOperation(tags = {"单条,创建"}, value = "演示单条数据创建", notes = "单条数据创建采用JPA")
    @PostMapping(path = "/insert")
    public void insert(@RequestBody DemoRequest demoRequest) {
        log.info("#$#$# 输入的请求信息{}", JSON.toJSONString(demoRequest));
        demoService.insert(demoRequest);
    }

    /**
     * 分页查询
     *
     * @param pageNum  页码
     * @param pageSize 每页显示行数
     * @return
     */
    @ApiOperation(tags = {"分页查询,mybatis,pageHelper"}, value = "演示分页查询", notes = "利用pageHelper实现的分页查询")
    @GetMapping(path = "/page/{pageNum}/{pageSize}")
    public InvokeResult<PageInfo<DemoResponse>> page(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        log.info("#$#$# 分页查询 pageNum：{} pageSize:{}", pageNum, pageSize);
        PageInfo<DemoResponse> pageInfo = demoService.page(pageNum, pageSize);
        return InvokeResult.successed(pageInfo);

    }
}
