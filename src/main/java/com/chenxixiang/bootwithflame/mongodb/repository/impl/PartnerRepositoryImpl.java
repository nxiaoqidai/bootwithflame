package com.chenxixiang.bootwithflame.mongodb.repository.impl;

import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.chenxixiang.bootwithflame.mongodb.common.PageVo;
import com.chenxixiang.bootwithflame.mongodb.domain.Partner;
import com.chenxixiang.bootwithflame.mongodb.repository.PartnerRepository;

@Repository
public class PartnerRepositoryImpl implements PartnerRepository {
	@Autowired
	public MongoTemplate mongoTemplate;

	@Override
	public void insert(Partner entity) {
		mongoTemplate.insert(entity);
	}

	@Override
	public PageVo<Partner> selectByName(String name, int pageIndex, int pageSize) {
		Query query = new Query();
		Criteria criteria = new Criteria();
		if (StringUtils.isNotBlank(name)) {
			Pattern pattern = Pattern.compile("^.*" + name + ".*$", Pattern.CASE_INSENSITIVE); // 根据关键字进行模糊搜索
			criteria.andOperator(Criteria.where("name").regex(pattern));
		}
		query.addCriteria(criteria);
		query.skip((pageIndex - 1) * pageSize).limit(pageSize);
		long total = mongoTemplate.count(query, Partner.class);
		List<Partner> datas = mongoTemplate.find(query, Partner.class);
		PageVo<Partner> page = new PageVo<Partner>(pageIndex, pageSize, total, datas);
		return page;
	}
}
