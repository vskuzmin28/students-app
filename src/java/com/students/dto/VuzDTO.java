package com.students.dto;

public class VuzDTO {
	private long id;
	private String regNum;
	private String name;
	private String address;

	public String getAddress() {
		return address;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

}
