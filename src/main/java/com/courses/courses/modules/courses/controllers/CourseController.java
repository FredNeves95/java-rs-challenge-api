package com.courses.courses.modules.courses.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.courses.courses.modules.courses.dtos.CreateCourseRequestDTO;
import com.courses.courses.modules.courses.dtos.CreateCourseResponseDTO;
import com.courses.courses.modules.courses.entities.CourseEntity;
import com.courses.courses.modules.courses.useCases.CreateCourseUseCase;
import com.courses.courses.modules.courses.useCases.GetAllCoursesUseCase;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/cursos")
public class CourseController {

  @Autowired
  private CreateCourseUseCase createCourseUseCase;

  @Autowired
  private GetAllCoursesUseCase getAllCoursesUseCase;


  @PostMapping("")
  public CreateCourseResponseDTO create(@Valid @RequestBody CreateCourseRequestDTO courseRequestDTO) {
      CourseEntity newCourseEntity = CourseEntity.builder()
      .name(courseRequestDTO.getName())
      .active(courseRequestDTO.getActive())
      .category(courseRequestDTO.getCategory())
      .build();
      var response = createCourseUseCase.execute(newCourseEntity);
      return response;
  }

  @GetMapping("")
  public List<CourseEntity> getAll() {
      var courses = getAllCoursesUseCase.execute();
      return courses;
  }
  
}
