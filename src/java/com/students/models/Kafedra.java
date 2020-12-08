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
@Table(name = "kafedra")
public class Kafedra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "kafedra_id")
	private long id;
	@Column(name = "kafedra_code")
	private String code;
	@Column(name = "kafedra_name")
	private String name;
	@ManyToOne
	@JoinColumn(name = "facultet_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Facultet facultet;

	public String getCode() {
		return code;
	}

	public Facultet getFacultet() {
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

	public void setFacultet(Facultet facultet) {
		this.facultet = facultet;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
