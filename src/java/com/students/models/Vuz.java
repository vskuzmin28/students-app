package com.students.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vuz")
public class Vuz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vuz_id")
	private long id;
	@Column(name = "vuz_reg_num")
	private String regNum;
	@Column(name = "vuz_name")
	private String name;
	@Column(name = "vuz_address")
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
