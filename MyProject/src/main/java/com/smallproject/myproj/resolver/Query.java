package com.smallproject.myproj.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.smallproject.myproj.model.ClassRoom;
import com.smallproject.myproj.model.School;
import com.smallproject.myproj.model.Student;
import com.smallproject.myproj.repository.ClassRoomRepository;
import com.smallproject.myproj.repository.SchoolRepository;
import com.smallproject.myproj.repository.StudentRepository;

@Component
public class Query implements GraphQLQueryResolver {
	
	 private StudentRepository strepo;
	 private  ClassRoomRepository crepo;
	 private SchoolRepository screpo;
	
	@Autowired
	public Query(StudentRepository strepo, ClassRoomRepository crepo, SchoolRepository screpo) {
		
		this.strepo = strepo;
		this.crepo = crepo;
		this.screpo = screpo;
	}
	
	public Iterable<Student> findAllStudent(){
		return strepo.findAll();
	}
	
	public Iterable<ClassRoom> findAllClassRoom(){
		return crepo.findAll();
	}
	
	public Iterable<School> findAllSchool(){
		return screpo.findAll();
		
	}
	public School findSchoolById(int scid) {
		return screpo.findById(scid).get();
		 
	}
	 public ClassRoom findClassRoomById(int cid) {
		 return crepo.findById(cid).get();
	 }

	 public Student findStudentById(int id) {
		 return strepo.findById(id).get();
	 }
	
}
