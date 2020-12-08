package com.students.dto;

public class FacultetDTO {
	private long id;
	private String code;
	private VuzDTO vuz;
	private String name;
	public String getCode() {
		return code;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public VuzDTO getVuz() {
		return vuz;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setVuz(VuzDTO vuz) {
		this.vuz = vuz;
	}

}
