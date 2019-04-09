package com.chenxixiang.bootwithflame.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenxixiang.bootwithflame.mongodb.common.PageVo;
import com.chenxixiang.bootwithflame.mongodb.domain.Partner;
import com.chenxixiang.bootwithflame.mongodb.repository.PartnerRepository;
import com.chenxixiang.bootwithflame.service.interfaces.PartnerService;

@Service
public class PartnerServiceImpl implements PartnerService {

	@Autowired
	PartnerRepository dao;

	@Override
	public int insertPartner(Partner entity) {
		dao.insert(entity);
		return 1;
	}

	@Override
	public PageVo<Partner> selectByName(String name, int pageIndex, int pageSize) {
		PageVo<Partner> pageVo = dao.selectByName(name, pageIndex, pageSize);
		return pageVo;
	}

}
