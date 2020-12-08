package com.students.dto;

public class GruppaDTO {
	private long id;
	private String code;
	private SpecializaciaDTO specializacia;
	private KafedraDTO kafedra;
	private String name;
	public String getCode() {
		return code;
	}
	public long getId() {
		return id;
	}
	public KafedraDTO getKafedra() {
		return kafedra;
	}
	public String getName() {
		return name;
	}
	public SpecializaciaDTO getSpecializacia() {
		return specializacia;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setKafedra(KafedraDTO kafedra) {
		this.kafedra = kafedra;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSpecializacia(SpecializaciaDTO specializacia) {
		this.specializacia = specializacia;
	}

}
