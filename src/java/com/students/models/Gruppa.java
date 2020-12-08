
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
@Table(name = "gruppa")
public class Gruppa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "gruppa_code")
	private String code;
	@ManyToOne
	@JoinColumn(name = "specializacia_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Specializacia specializacia;
	@ManyToOne
	@JoinColumn(name = "kafedra_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Kafedra kafedra;
	@Column(name = "gruppa_name")
	private String name;
	public String getCode() {
		return code;
	}
	public long getId() {
		return id;
	}
	public Kafedra getKafedra() {
		return kafedra;
	}
	public String getName() {
		return name;
	}
	public Specializacia getSpecializacia() {
		return specializacia;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setKafedra(Kafedra kafedra) {
		this.kafedra = kafedra;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSpecializacia(Specializacia specializacia) {
		this.specializacia = specializacia;
	}

}
