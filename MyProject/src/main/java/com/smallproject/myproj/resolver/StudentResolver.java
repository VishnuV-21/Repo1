package com.smallproject.myproj.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.smallproject.myproj.model.ClassRoom;
import com.smallproject.myproj.model.School;
import com.smallproject.myproj.model.Student;
import com.smallproject.myproj.repository.ClassRoomRepository;
import com.smallproject.myproj.repository.SchoolRepository;

@Component
public class StudentResolver implements GraphQLMutationResolver {
	
ClassRoomRepository crepo;
SchoolRepository screpo;

@Autowired
public StudentResolver(ClassRoomRepository crepo, SchoolRepository screpo) {
	super();
	this.crepo = crepo;
	this.screpo = screpo;
}

public ClassRoom getClassRoom(Student student) {
	return crepo.findById(student.getClassroom().getCid()).orElseThrow(null);
}

public School getSchool(Student student) {
	return screpo.findById(student.getSchool().getScid()).orElseThrow(null);
}
}
