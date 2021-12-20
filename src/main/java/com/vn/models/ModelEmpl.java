package com.vn.models;

public class ModelEmpl {

	private String id;
	private String firstName;
	private String lastName;
	private String decription;
	private Boolean age;
	private String phone1;
	private String phone2;
	private String phone3;
	private String phone4;
	private String phone5;
	private String phone6;
	
	public static void main(String[] args) {
		String sql = getSQL("Users", new String[] {"fName", "lName"}, "firstName", "lastName");
		System.out.println(sql);
	}
	
	private static String getSQL(String table, String[] alias, String... columns) {
		String sql = "";
		sql = sql + "SELECT ";
		
		for (int i = 0; i < columns.length; i++) {
			String col = columns[i];
			String ali = alias[i];
			sql = sql + col + " " + ali;
			if(i != columns.length - 1) {
				sql = sql + ", ";
			}
		}
		sql = sql + " FROM ";
		sql = sql + table;
		return sql;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public Boolean getAge() {
		return age;
	}

	public void setAge(Boolean age) {
		this.age = age;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public String getPhone4() {
		return phone4;
	}

	public void setPhone4(String phone4) {
		this.phone4 = phone4;
	}

	public String getPhone5() {
		return phone5;
	}

	public void setPhone5(String phone5) {
		this.phone5 = phone5;
	}

	public String getPhone6() {
		return phone6;
	}

	public void setPhone6(String phone6) {
		this.phone6 = phone6;
	}
	
}
