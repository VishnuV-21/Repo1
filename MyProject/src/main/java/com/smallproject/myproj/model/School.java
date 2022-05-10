package com.smallproject.myproj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SCHOOL")
public class School {
	@Id
	@SequenceGenerator(name = "school_seq", sequenceName = "school_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school_seq")
	
	private int scid;

	@Column(name = "School_name")
	private String name;

	@Override
	public String toString() {
		return "School [scid=" + scid + ", name=" + name + "]";
	}

	public int getScid() {
		return scid;
	}

	public void setScid(int scid) {
		this.scid = scid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public School(String name) {
		super();
		this.name = name;
	}

	public School(int scid) {
		super();
		this.scid = scid;
	}

	public School() {
		super();
	}

}
