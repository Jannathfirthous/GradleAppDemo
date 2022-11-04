package com.nv.atest.Service;

import org.springframework.stereotype.Service;

import com.nv.atest.Entity.ProductInfo;
@Service
public interface ProductInfoService {
	public ProductInfo addProductInfo(ProductInfo productInfo);
}
