package com.nv.atest.Entity;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productCode;
	private String category;
	private String productName;
	private int price;
	private String dealerName;
	private float userRating;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "profile")
	private ProductInfo productInfo;
	
	

}
