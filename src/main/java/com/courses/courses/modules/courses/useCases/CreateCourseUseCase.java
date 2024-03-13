package com.courses.courses.modules.courses.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courses.courses.modules.courses.dtos.CreateCourseResponseDTO;
import com.courses.courses.modules.courses.entities.CourseEntity;
import com.courses.courses.modules.courses.enums.CategoriesEnum;
import com.courses.courses.modules.courses.repositories.CourseRepository;

@Service
public class CreateCourseUseCase {
  @Autowired
  private CourseRepository courseRepository;

  public CreateCourseResponseDTO execute (CourseEntity courseEntity) {
    if(courseEntity.getActive() == null){
      courseEntity.setActive(true);
    }
    if(courseEntity.getCategory() == null){
      courseEntity.setCategory(CategoriesEnum.OTHER);
    }
    var response = courseRepository.save(courseEntity);
    var responseDTO = CreateCourseResponseDTO.builder()
      .id(response.getId())
      .name(response.getName())
      .category(response.getCategory())
      .active(response.getActive())
      .createdAt(response.getCreatedAt())
      .build();
      return responseDTO;
  }
}
