package com.courses.courses.modules.courses.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.courses.courses.modules.courses.entities.CourseEntity;

public interface CourseRepository extends JpaRepository <CourseEntity, UUID>{
  
}
