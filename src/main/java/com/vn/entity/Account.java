package com.vn.entity;

import javax.persistence.Basic;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the account database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name = "account")
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	@Basic
	private Boolean active;

	private Boolean admin;

	private String password;
	
	@Embedded
	private AccountDetail detail;

}