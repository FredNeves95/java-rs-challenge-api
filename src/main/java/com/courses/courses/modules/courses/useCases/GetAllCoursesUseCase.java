package com.courses.courses.modules.courses.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courses.courses.modules.courses.entities.CourseEntity;
import com.courses.courses.modules.courses.repositories.CourseRepository;

@Service
public class GetAllCoursesUseCase {
  @Autowired
  private CourseRepository courseRepository;

  public List<CourseEntity> execute() {
    return courseRepository.findAll();
  }
}
