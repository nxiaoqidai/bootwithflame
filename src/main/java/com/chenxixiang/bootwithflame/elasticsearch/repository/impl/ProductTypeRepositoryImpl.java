package com.chenxixiang.bootwithflame.elasticsearch.repository.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.stereotype.Service;

import com.chenxixiang.bootwithflame.elasticsearch.pojo.ProductType;

@Service
public class ProductTypeRepositoryImpl {
	@Autowired
	ElasticsearchTemplate elasticsearchTemplate;

	public Map getProductTypeMapping() {
//		Client client = elasticsearchTemplate.getClient();
		Map map = elasticsearchTemplate.getMapping(ProductType.class);
		return map;
	}

	public void getProductypeByName() {
		StringQuery query = new StringQuery(null);
		Page<ProductType> page = elasticsearchTemplate.queryForPage(query, ProductType.class);

//		List<ProductType> list = elasticsearchTemplate.queryForList(criteria, ProductType.class);
	}

}
