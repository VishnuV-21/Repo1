package com.smallproject.myproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smallproject.myproj.model.ClassRoom;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, Integer> {

}
