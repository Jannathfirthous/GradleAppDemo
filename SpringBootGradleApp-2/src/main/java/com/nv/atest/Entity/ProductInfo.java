package com.nv.atest.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productinfo")
public class ProductInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int certificateNumber;
	private String countryOfOrgin;
	private String manufacturingDate;
	private int weight;
	private String color;

	public ProductInfo(String countryOfOrgin, String manufacturingDate, int weight, String color) {
		super();
		this.countryOfOrgin = countryOfOrgin;
		this.manufacturingDate = manufacturingDate;
		this.weight = weight;
		this.color = color;
	}

}
