package com.nv.atest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nv.atest.Entity.Product;
import com.nv.atest.Entity.ProductInfo;
import com.nv.atest.Service.ProductInfoService;
import com.nv.atest.Service.ProductServiceInterface;

@RestController
@RequestMapping("product/productinfo")
public class ProductInfoController {
	@Autowired
	ProductInfoService productInfoService;
	@Autowired
	ProductServiceInterface productService;

	@PostMapping("/add")
	public Product doProductInfoThings(@RequestBody ProductInfo productInfo, @RequestParam String productName) {
		Product alreadySavedProduct = null;
		try {
			ProductInfo savedProfile = productInfoService.addProductInfo(productInfo);
			if (savedProfile.getCertificateNumber() != 0) {
				alreadySavedProduct = productService.getProductByProductName(productName);
				if (alreadySavedProduct != null) {
					Product addProduct = productService.linkProduct(productInfo, alreadySavedProduct);

					return addProduct;
				} else {
					throw new Exception("User not found ,  " + alreadySavedProduct + " for " + productName);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			return alreadySavedProduct;
		}

		return alreadySavedProduct;

		// code to add the profile
	}
}
