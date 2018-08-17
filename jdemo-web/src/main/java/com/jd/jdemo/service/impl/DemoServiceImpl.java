package com.jd.jdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jd.jdemo.dao.mapper.primary.DemoMapper;
import com.jd.jdemo.dto.request.DemoRequest;
import com.jd.jdemo.dto.response.DemoResponse;
import com.jd.jdemo.entity.primary.DemoEntity;
import com.jd.jdemo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DemoServiceImpl implements DemoService {
    /**
     * mybatis 数据操作接口
     */
    @Autowired
    private DemoMapper demoMapper;
    /**
     * DTO转换值拷贝工具
     */
    @Autowired
    private MapperFacade mapperFacade;

    @PersistenceContext
    private EntityManager em;

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
        //BeanUtils方式拷贝
        //BeanUtils.copyProperties(demoRequest, demoEntity);
        mapperFacade.map(demoRequest, demoEntity);
        demoEntity.create();
        //throw new RuntimeException("2");
        //mybatis方式创建数据
        //demoMapper.insert(demoEntity);
        //jpa方式创建数据
        //em.persist(demoEntity);
        //em.flush();
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
        List<DemoResponse> li = new ArrayList<>();
        //TODO 加入DTO转换框架
        for (DemoEntity entity : list) {
            DemoResponse response = new DemoResponse();
            BeanUtils.copyProperties(entity, response);
            li.add(response);
        }
        PageInfo<DemoEntity> pageInfo = new PageInfo(li);
        return pageInfo;
    }
}
