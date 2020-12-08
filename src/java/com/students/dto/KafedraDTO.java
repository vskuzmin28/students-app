package com.students.dto;

public class KafedraDTO {
	private long id;
	private String code;
	private String name;
	private FacultetDTO facultet;
	public String getCode() {
		return code;
	}
	public FacultetDTO getFacultet() {
		return facultet;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setFacultet(FacultetDTO facultet) {
		this.facultet = facultet;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
