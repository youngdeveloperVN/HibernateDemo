package com.vn.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class AccountDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	private String lastName;
	private String firstName;

}