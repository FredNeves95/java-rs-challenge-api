package com.courses.courses.modules.courses.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courses.courses.modules.courses.repositories.CourseRepository;
import com.courses.courses.exceptions.CourseNotFoundException;

@Service
public class DeleteCourseUseCase {
  @Autowired
  private CourseRepository courseRepository;

  public void execute(UUID id) throws CourseNotFoundException {
    courseRepository.findById(id)
    .orElseThrow(() -> {
      throw new CourseNotFoundException();
    });
 
    courseRepository.deleteById(id);
  }
}
