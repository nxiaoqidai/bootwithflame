package com.chenxixiang.bootwithflame.mongodb.repository;

import com.chenxixiang.bootwithflame.mongodb.common.PageVo;
import com.chenxixiang.bootwithflame.mongodb.domain.Partner;

public interface PartnerRepository {

	void insert(Partner entity);

	PageVo<Partner> selectByName(String name, int pageIndex, int pageSize);

}
