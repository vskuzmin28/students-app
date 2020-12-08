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
@Table(name = "facultet")
public class Facultet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "facultet_id")
	private long id;
	@Column(name = "facultet_code")
	private String code;
	@ManyToOne
	@JoinColumn(name = "vuz_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Vuz vuz;
	@Column(name = "facultet_name")
	private String name;
	public Facultet() {
		super();
	}
	public String getCode() {
		return code;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Vuz getVuz() {
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

	public void setVuz(Vuz vuz) {
		this.vuz = vuz;
	}

}
