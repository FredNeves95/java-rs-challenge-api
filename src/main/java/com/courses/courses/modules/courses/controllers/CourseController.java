package com.courses.courses.modules.courses.controllers;

import com.courses.courses.modules.courses.dtos.CreateCourseRequestDTO;
import com.courses.courses.modules.courses.dtos.CreateCourseResponseDTO;
import com.courses.courses.modules.courses.entities.CourseEntity;
import com.courses.courses.modules.courses.useCases.CreateCourseUseCase;
import com.courses.courses.modules.courses.useCases.DeleteCourseUseCase;
import com.courses.courses.modules.courses.useCases.GetAllCoursesUseCase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.UUID;


@RestController
@RequestMapping("/cursos")
public class CourseController {

  @Autowired
  private CreateCourseUseCase createCourseUseCase;

  @Autowired
  private GetAllCoursesUseCase getAllCoursesUseCase;

  @Autowired
  private DeleteCourseUseCase deleteCourseUseCase;

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

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable UUID id) {
    try {
      deleteCourseUseCase.execute(id);
      return ResponseEntity.noContent().build();
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
