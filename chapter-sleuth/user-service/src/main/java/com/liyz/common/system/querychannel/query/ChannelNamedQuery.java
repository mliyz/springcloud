package com.liyz.common.system.querychannel.query;

import com.liyz.common.system.domain.BaseQuery;
import com.liyz.common.system.domain.EntityRepository;
import com.liyz.common.system.domain.NamedQuery;
import com.liyz.common.system.querychannel.ChannelQuery;
import com.yixin.common.utils.Page;

import java.util.List;

/**
 * 通道查询的SQL实现
 *
 * @author yyang
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ChannelNamedQuery extends ChannelQuery<ChannelNamedQuery>
{

	private NamedQuery query;

	public ChannelNamedQuery(EntityRepository repository, String queryName) {
		super(repository);
		query = new NamedQuery(repository, queryName);
		setQuery(query);
	}

	@Override
	public <T> List<T> list() {
		return query.list();
	}

	@Override
	public <T> Page<T> pagedList() {
		return new Page<T>(query.getFirstResult(), queryResultCount(), query.getMaxResults(),
				(List<T>) query.list());
	}

	@Override
	public <T> T singleResult() {
		return (T) query.singleResult();
	}

	@Override
	protected String getQueryString() {
		return repository.getQueryStringOfNamedQuery(query.getQueryName());
	}

	@Override
	protected BaseQuery createBaseQuery(String queryString) {
		return repository.createJpqlQuery(queryString);
	}

}
