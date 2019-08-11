package com.chenxixiang.bootwithflame.service.interfaces;

import com.chenxixiang.bootwithflame.elasticsearch.pojo.ProductType;

public interface ProductTypeService {
    boolean addProductType(ProductType productType);

    ProductType getOneProductTypeByName(String name);
}
