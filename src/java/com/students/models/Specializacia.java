package com.students.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "specializacia")
public class Specializacia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "specializacia_id")
	private long id;
	@Column(name = "specializacia_shifr")
	private String shifr;
	@Column(name = "specializacia_name")
	private String name;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getShifr() {
		return shifr;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setShifr(String shifr) {
		this.shifr = shifr;
	}

}
