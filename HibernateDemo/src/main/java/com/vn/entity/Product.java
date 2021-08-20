package com.vn.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the product database table.
 * 
 */
@Setter
@Getter
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
@Embeddable
public class Product extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int avaiable;

	private String image;

	private String name;

	private Double price;

	private Integer quantity;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

}