package com.vn.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the category database table.
 * 
 */
@Setter
@Getter
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	@ElementCollection
	@OneToMany(mappedBy="category")
	@Cascade(value = {org.hibernate.annotations.CascadeType.ALL})
	private List<Product> products;
	
//	@PrePersist
//	public void prePersist() {
//		this.setCreateDate(new Date());
//	}
//	

}