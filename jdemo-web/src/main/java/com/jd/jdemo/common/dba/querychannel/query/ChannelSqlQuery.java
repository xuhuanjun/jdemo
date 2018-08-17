package com.jd.jdemo.common.dba.querychannel.query;

import com.jd.jdemo.common.dba.domain.BaseQuery;
import com.jd.jdemo.common.dba.domain.Entity;
import com.jd.jdemo.common.dba.domain.EntityRepository;
import com.jd.jdemo.common.dba.domain.SqlQuery;
import com.jd.jdemo.common.dba.querychannel.ChannelQuery;
import com.jd.jdemo.common.dba.utils.Page;

import java.util.List;

/**
 * 通道查询的SQL实现
 *
 * @author yyang
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class ChannelSqlQuery extends ChannelQuery<ChannelSqlQuery> {

    private final SqlQuery query;

    public ChannelSqlQuery(EntityRepository repository, String sql) {
        super(repository);
        query = new SqlQuery(repository, sql);
        setQuery(query);
    }

    /**
     * 设置查询的结果实体类型。注意setResultEntityClass()和addScalar()是互斥的，
     * 分别适用于查询结果是实体和标量两种情形
     *
     * @param resultEntityClass 要设置的查询结果类型
     * @return 该对象本身
     */
    public ChannelSqlQuery setResultEntityClass(Class<? extends Entity> resultEntityClass) {
        query.setResultEntityClass(resultEntityClass);
        return this;
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
        return query.getSql();
    }

    @Override
    protected BaseQuery createBaseQuery(String queryString) {
        return repository.createSqlQuery(queryString);
    }
}
