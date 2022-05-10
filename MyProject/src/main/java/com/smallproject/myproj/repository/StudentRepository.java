package com.smallproject.myproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smallproject.myproj.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
