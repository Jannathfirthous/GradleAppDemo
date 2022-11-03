package com.nv.atest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nv.atest.Entity.Product;
import com.nv.atest.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductServiceInterface {
	@Autowired
	ProductRepository productRepository;
	@Override
	public List<Product> getAllProducts() throws Exception {
		List<Product> allProducts =  productRepository.findAll();
		return allProducts;
	}

	@Override
	public Product getProductByProductCode(int productCode) throws Exception {
	
		 return productRepository.getProductByProductCode(productCode);
	}

	@Override
	public Product getProductByProductName(String productName) throws Exception {
	
		return productRepository.getProductByProductName(productName);
	}

	@Override
	public List<Product> getProductsByCategoryAndPriceRangeAndDealerName(String category, float price1, float price2,
			String dealerName) throws Exception {
		
		return productRepository.getProductsByCategoryAndPriceRangeAndDealerName(category, price1, price2, dealerName);
	}

	@Override
	public List<Product> getAllProductsByDealerName(String dealerName) throws Exception {
		
		return productRepository.getAllProductsByDealerName(dealerName);
	}

	@Override
	public List<Product> getAllProductsByCategoryAndPriceAndRating(String category, float price, float rating)
			throws Exception {
		
		return productRepository.getAllProductsByCategoryAndPriceAndRating(category, price, rating);
	}

	@Override
	public String insertProduct(Product p) throws Exception {
		Product savedP =  productRepository.save(p);  // Note :  save() is already implemented by Spring Data JPA
		if(savedP != null)
		{
			return "Product Saved "+savedP.getProductCode()+" product name :- "+savedP.getProductName();
		}
		else return null;
	}

	@Override
	public List<Product> getProductByCategory(String category) throws Exception {
	
		return productRepository.getProductByCategory(category);
	}
	
}
