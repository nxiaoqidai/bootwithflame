package com.chenxixiang.bootwithflame.service.interfaces;

import com.chenxixiang.bootwithflame.mongodb.common.PageVo;
import com.chenxixiang.bootwithflame.mongodb.domain.Partner;

public interface PartnerService {
	int insertPartner(Partner entity);

	PageVo<Partner> selectByName(String name, int pageIndex, int pageSize);
}
