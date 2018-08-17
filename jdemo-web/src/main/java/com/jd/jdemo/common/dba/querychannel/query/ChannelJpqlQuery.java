package com.jd.jdemo.common.dba.querychannel.query;

import com.jd.jdemo.common.dba.domain.BaseQuery;
import com.jd.jdemo.common.dba.domain.EntityRepository;
import com.jd.jdemo.common.dba.domain.JpqlQuery;
import com.jd.jdemo.common.dba.querychannel.ChannelQuery;
import com.jd.jdemo.common.dba.utils.Page;

import java.util.List;


/**
 * 通道查询的JPQL实现
 *
 * @author yyang
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class ChannelJpqlQuery extends ChannelQuery<ChannelJpqlQuery> {

    private final JpqlQuery query;

    public ChannelJpqlQuery(EntityRepository repository, String jpql) {
        super(repository);
        query = new JpqlQuery(repository, jpql);
        setQuery(query);
    }

    @Override
    public <T> List<T> list() {
        return query.list();
    }

    @Override
    public <T> Page<T> pagedList() {
        return new Page<T>(query.getFirstResult(), queryResultCount(), query.getMaxResults(), (List<T>) query.list());
    }

    @Override
    public <T> T singleResult() {
        return (T) query.singleResult();
    }

    @Override
    protected String getQueryString() {
        return query.getJpql();
    }

    @Override
    protected BaseQuery createBaseQuery(String queryString) {
        return repository.createJpqlQuery(queryString);
    }
}
