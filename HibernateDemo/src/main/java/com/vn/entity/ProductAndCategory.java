package com.vn.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@AllArgsConstructor
@ToString
public class ProductAndCategory {

	@Id
	private int id;

	private String name;

	private Double price;

	private String categoryName;
}
