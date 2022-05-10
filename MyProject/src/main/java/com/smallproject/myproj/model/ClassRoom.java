package com.smallproject.myproj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CLASSROOM")
public class ClassRoom {
	@Id
	@SequenceGenerator(name = "class_seq", sequenceName = "class_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "class_seq")
	
	private int cid;
	
	@Column(name="Grade")
	private int grade;
	
	@Column(name="Section")
	private String section;
	
	
	@Override
	public String toString() {
		return "ClassRoom [cid=" + cid + ", grade=" + grade + ", section=" + section + "]";
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public ClassRoom(int grade, String section) {
		super();
		this.grade = grade;
		this.section = section;
	}
	public ClassRoom(int cid) {
		super();
		this.cid = cid;
	}
	public ClassRoom() {
		super();
	}
	
	
	

}
