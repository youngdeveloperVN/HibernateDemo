package com.vn.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="role_account")
@IdClass(RoleAccountId.class)
public class RoleAccount implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private RoleAccountId id;
	
	private Integer level;
	
}
