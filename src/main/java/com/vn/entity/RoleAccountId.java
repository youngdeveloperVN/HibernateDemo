package com.vn.entity;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleAccountId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "account_id")
	private Integer accountId;
	
	@Column(name = "roll_id")
	private Integer roleId;
	
}
