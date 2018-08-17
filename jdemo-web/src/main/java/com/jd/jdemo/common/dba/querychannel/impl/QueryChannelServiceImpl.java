package com.jd.jdemo.common.dba.querychannel.impl;

import com.jd.jdemo.common.dba.domain.EntityRepository;
import com.jd.jdemo.common.dba.ioc.InstanceFactory;
import com.jd.jdemo.common.dba.querychannel.ChannelQuery;
import com.jd.jdemo.common.dba.querychannel.QueryChannelService;
import com.jd.jdemo.common.dba.querychannel.query.ChannelJpqlQuery;
import com.jd.jdemo.common.dba.querychannel.query.ChannelNamedQuery;
import com.jd.jdemo.common.dba.querychannel.query.ChannelSqlQuery;
import com.jd.jdemo.common.dba.utils.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuhj on 2018/8/16.
 */
@Service("queryChannel")
@SuppressWarnings({"rawtypes", "unchecked"})
public class QueryChannelServiceImpl implements QueryChannelService {

    private static final long serialVersionUID = -1045471527037313221L;
    // @Autowired
    private EntityRepository repository;

    private EntityRepository getEntityRepository() {
        if (null == repository) {
            repository = InstanceFactory.getInstance(EntityRepository.class);
        }
        return repository;
    }

    @Override
    public ChannelJpqlQuery createJpqlQuery(String jpql) {
        return new ChannelJpqlQuery(getEntityRepository(), jpql);
    }

    @Override
    public ChannelNamedQuery createNamedQuery(String queryName) {
        return new ChannelNamedQuery(getEntityRepository(), queryName);
    }

    @Override
    public ChannelSqlQuery createSqlQuery(String sql) {
        return new ChannelSqlQuery(getEntityRepository(), sql);
    }

    @Override
    public <T> List<T> list(ChannelQuery query) {
        return query.list();
    }

    @Override
    public <T> Page<T> pagedList(ChannelQuery query) {
        return query.pagedList();
    }

    @Override
    public <T> T getSingleResult(ChannelQuery query) {
        return (T) query.singleResult();
    }

    @Override
    public long getResultCount(ChannelQuery query) {
        return query.queryResultCount();
    }
}
