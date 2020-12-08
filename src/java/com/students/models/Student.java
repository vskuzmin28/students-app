package com.students.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private long id;
	@ManyToOne
	@JoinColumn(name = "gruppa_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Gruppa gruppa;
	@Column(name = "student_fio")
	private String fio;

	public String getFio() {
		return fio;
	}

	public Gruppa getGruppa() {
		return gruppa;
	}

	public long getId() {
		return id;
	}

	public void setFio(String fio) {
		this.fio = fio;
	}

	public void setGruppa(Gruppa gruppa) {
		this.gruppa = gruppa;
	}

	public void setId(long id) {
		this.id = id;
	}

}
