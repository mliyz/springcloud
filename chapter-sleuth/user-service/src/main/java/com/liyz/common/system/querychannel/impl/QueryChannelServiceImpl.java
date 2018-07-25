package com.liyz.common.system.querychannel.impl;

import com.liyz.common.system.domain.EntityRepository;
import com.liyz.common.system.ioc.InstanceFactory;
import com.liyz.common.system.querychannel.ChannelQuery;
import com.liyz.common.system.querychannel.QueryChannelService;
import com.liyz.common.system.querychannel.query.ChannelJpqlQuery;
import com.liyz.common.system.querychannel.query.ChannelNamedQuery;
import com.liyz.common.system.querychannel.query.ChannelSqlQuery;
import com.yixin.common.utils.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenhw on 2016/3/16.
 */
@Service("queryChannel")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class QueryChannelServiceImpl implements QueryChannelService
{

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
