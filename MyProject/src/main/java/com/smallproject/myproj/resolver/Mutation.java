package com.smallproject.myproj.resolver;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.smallproject.myproj.model.ClassRoom;
import com.smallproject.myproj.model.School;
import com.smallproject.myproj.model.Student;
import com.smallproject.myproj.repository.ClassRoomRepository;
import com.smallproject.myproj.repository.SchoolRepository;
import com.smallproject.myproj.repository.StudentRepository;

import javassist.NotFoundException;

@Component
public class Mutation implements GraphQLMutationResolver {

	private StudentRepository strepo;
	private ClassRoomRepository crepo;
	private SchoolRepository screpo;

	@Autowired
	public Mutation(StudentRepository strepo, ClassRoomRepository crepo, SchoolRepository screpo) {
		super();
		this.strepo = strepo;
		this.crepo = crepo;
		this.screpo = screpo;
	}

	public School createSchool(String name) {
		School school = new School();
		school.setName(name);
		screpo.save(school);
		return school;
	}

	public ClassRoom createClassRoom(int grade, String section) {
		ClassRoom classroom = new ClassRoom();
		classroom.setGrade(grade);
		classroom.setSection(section);
		crepo.save(classroom);
		return classroom;
	}

	public Student createStudent(String name, int cid, int scid) {
		Student student = new Student();
		student.setName(name);
		student.setClassroom(new ClassRoom(cid));
		student.setSchool(new School(scid));
		strepo.save(student);
		return student;
	}
	 public boolean deleteStudent(int id) {
		 strepo.deleteById(id);
		 crepo.deleteById(id);
		 screpo.deleteById(id);
		 return true;
	 }
public Student updateStudent(int id, String name) throws Exception{
	Optional<Student> optstudent=strepo.findById(id);
	if(optstudent.isPresent()) {
		Student student=optstudent.get();
		if(name!=null) {
			student.setName(name);
		}
		strepo.save(student);
		return student;
	}
	throw new NotFoundException(name+ "is not found in the database ");
	
	
}
}
