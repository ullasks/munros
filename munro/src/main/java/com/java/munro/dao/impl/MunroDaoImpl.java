package com.java.munro.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.java.munro.dao.AbstractRepository;
import com.java.munro.dao.MunroRepositoryCustom;
import com.java.munro.model.MunroFilterModel;
import com.java.munro.orm.Munro;

@Repository
public class MunroDaoImpl extends AbstractRepository implements MunroRepositoryCustom {

	@SuppressWarnings("unchecked")
	@Override
	public List<Munro> findByFilter(MunroFilterModel filter) {
		final Criteria criteria = createCriteria(Munro.class);
		
		String defaultSortField = "name";
		
		String fieldToBeSorted = StringUtils.isEmpty(filter.getFieldToBeSorted()) ? defaultSortField
				: filter.getFieldToBeSorted();
		if(defaultSortField.equalsIgnoreCase("maxHeight") || defaultSortField.equalsIgnoreCase("minHeight")) {
			defaultSortField = "height";
		}

		if (!StringUtils.isEmpty(filter.getName())) {
			criteria.add(Restrictions.eq("name", filter.getName()).ignoreCase());
		}

		if (null != filter.getMinHeight()) {
			criteria.add(Restrictions.ge("height", filter.getMinHeight()));
		}
		if (null != filter.getMaxHeight()) {
			criteria.add(Restrictions.le("height", filter.getMaxHeight()));
		}
		if (null != filter.getLimit()) {
			criteria.setMaxResults(filter.getLimit());
		}
		if(StringUtils.isEmpty(filter.getHillCategory()) || filter.getHillCategory().equalsIgnoreCase("either")) {
			Criterion munroHillCategory = Restrictions.eq("hillCategory", "MUN").ignoreCase();
			Criterion munroTopHillCategory = Restrictions.eq("hillCategory", "TOP").ignoreCase();
			criteria.add(Restrictions.or(munroHillCategory, munroTopHillCategory));
		}else{
			criteria.add(Restrictions.eq("hillCategory", filter.getHillCategory()).ignoreCase());
		}
		
		criteria.addOrder(filter.isAsc()?Order.asc(fieldToBeSorted): Order.desc(fieldToBeSorted));

		
		return criteria.list();
	}

}
