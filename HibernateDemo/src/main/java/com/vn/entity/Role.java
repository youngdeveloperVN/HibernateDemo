package com.vn.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	
	private String name;

}