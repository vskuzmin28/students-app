package com.students.dto;

public class StudentDTO {
	private long id;
	private GruppaDTO gruppa;
	private String fio;
	public String getFio() {
		return fio;
	}
	public GruppaDTO getGruppa() {
		return gruppa;
	}
	public long getId() {
		return id;
	}
	public void setFio(String fio) {
		this.fio = fio;
	}
	public void setGruppa(GruppaDTO gruppa) {
		this.gruppa = gruppa;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
}
