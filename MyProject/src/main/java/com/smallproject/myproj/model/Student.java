package com.smallproject.myproj.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student {
	@Id
	@SequenceGenerator(name = "stud_seq",
			sequenceName = "stud_seq",
			allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "stud_seq")
	@Column(name="Student_id")
	private int id;
	
	@Column(name="Student_name")
	private String name;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	//As we are giving the name here , no need to give the name by @Column in their classes. if given it will not start the application.
	//here the name="" reflects as the database column name 
	@JoinColumn(name = "classroom_id",referencedColumnName = "cid")
	private ClassRoom classroom;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "school_id",referencedColumnName = "scid")	
	private School school;

	@Override
	public String toString() {
		return "Student [sid=" + id + ", name=" + name + ", classroom=" + classroom + ", school=" + school + "]";
	}

	public int getSid() {
		return id;
	}

	public void setSid(int sid) {
		this.id = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ClassRoom getClassroom() {
		return classroom;
	}

	public void setClassroom(ClassRoom classroom) {
		this.classroom = classroom;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Student(String name, ClassRoom classroom, School school) {
		super();
		this.name = name;
		this.classroom = classroom;
		this.school = school;
	}

	public Student(int sid) {
		super();
		this.id = sid;
	}

	public Student() {
		super();
	}

}
