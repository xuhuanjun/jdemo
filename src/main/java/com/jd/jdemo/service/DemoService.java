package com.jd.jdemo.service;

import com.github.pagehelper.PageInfo;
import com.jd.jdemo.dto.request.DemoRequest;
import com.jd.jdemo.entity.DemoEntity;

import java.util.List;

public interface DemoService {
    List<DemoEntity> getAll();

    DemoEntity getOne(Integer id);

    void insert(DemoRequest demoRequest);

    void update(DemoRequest demoRequest);

    void delete(Integer id);

    PageInfo page(Integer pageNum, Integer pageSize);
}
