package com.nv.atest.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nv.atest.Entity.Product;

@Repository
public interface IProductCustomRepository {
	public Product getProductByProductCode(int productCode) throws Exception;

	public Product getProductByProductName(String productName) throws Exception;

	public List<Product> getProductByCategory(String category) throws Exception;

	@Query("from Product where category = :category and price >= :price1 and price <= :price2 and dealerName =:dealer")
	public List<Product> getProductsByCategoryAndPriceRangeAndDealerName(@Param("category") String category,
			@Param("price1") float price1, @Param("price2") float price2, @Param("dealer") String dealerName)
			throws Exception;

	public List<Product> getAllProductsByDealerName(String dealerName) throws Exception;

	@Query("from Product where category =:category and price = :price and rating =:rating")
	public List<Product> getAllProductsByCategoryAndPriceAndRating(@Param("category") String category,
			@Param("price") float price, @Param("rating") float rating) throws Exception;

}
