package com.liyz.common.system.querychannel.query;

import com.liyz.common.system.domain.BaseQuery;
import com.liyz.common.system.domain.EntityRepository;
import com.liyz.common.system.domain.JpqlQuery;
import com.liyz.common.system.querychannel.ChannelQuery;
import com.yixin.common.utils.Page;

import java.util.List;

/**
 * 通道查询的JPQL实现
 *
 * @author yyang
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ChannelJpqlQuery extends ChannelQuery<ChannelJpqlQuery>
{

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
