package com.nv.atest.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nv.atest.Entity.ProductInfo;
import com.nv.atest.Repository.ProductInfoRepository;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {
	@Autowired
	ProductInfoRepository productInfoRepository;

	@Transactional
	@Override
	public ProductInfo addProductInfo(ProductInfo productInfo) {
		// TODO Auto-generated method stub
		ProductInfo savedProfile = productInfoRepository.save(productInfo);

		return savedProfile;
	}
}
