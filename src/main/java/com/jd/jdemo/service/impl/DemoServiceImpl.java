package com.jd.jdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jd.jdemo.dao.mapper.primary.DemoMapper;
import com.jd.jdemo.dto.request.DemoRequest;
import com.jd.jdemo.entity.DemoEntity;
import com.jd.jdemo.service.DemoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoMapper demoMapper;

    @Override
    public List<DemoEntity> getAll() {
        return null;
    }

    @Override
    public DemoEntity getOne(Integer id) {
        return null;
    }

    @Override
    @Transactional
    public void insert(DemoRequest demoRequest) {
        DemoEntity demoEntity = new DemoEntity();
        BeanUtils.copyProperties(demoRequest, demoEntity);
        demoMapper.insert(demoEntity);
    }

    @Override
    public void update(DemoRequest demoRequest) {

    }

    @Override
    public void delete(Integer id) {

    }

    public PageInfo page(Integer pageNum, Integer pageSize) {
        //pageNum 指定页数，pageSize指定每页显示条数
        PageHelper.startPage(pageNum, pageSize);
        List<DemoEntity> list = demoMapper.page();
        PageInfo<DemoEntity> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
