package com.smallproject.myproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smallproject.myproj.model.School;

public interface SchoolRepository extends JpaRepository<School, Integer>{

}
