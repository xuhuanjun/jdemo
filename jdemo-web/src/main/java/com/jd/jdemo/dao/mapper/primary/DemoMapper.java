package com.jd.jdemo.dao.mapper.primary;

import com.jd.jdemo.entity.primary.DemoEntity;

import java.util.List;

public interface DemoMapper {
    List<DemoEntity> getAll();

    DemoEntity getOne(Integer id);

    void insert(DemoEntity demoEntity);

    void update(DemoEntity demoEntity);

    void delete(Integer id);

    List<DemoEntity> page();
}
