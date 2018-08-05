package com.jd.jdemo.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.jd.jdemo.dto.request.DemoRequest;
import com.jd.jdemo.entity.DemoEntity;
import com.jd.jdemo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/demo", produces = {MediaType.APPLICATION_JSON_VALUE})
@Slf4j
public class DemoController {
    @Autowired
    private DemoService demoService;

    /**
     * 单条数据插入
     *
     * @param demoRequest
     */
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
    @GetMapping(path = "/page/{pageNum}/{pageSize}")
    public PageInfo<DemoEntity> page(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        log.info("#$#$# 分页查询 pageNum：{} pageSize:{}", pageNum, pageSize);
        return demoService.page(pageNum, pageSize);
    }
}
