package com.courses.courses.modules.courses.dtos;

import com.courses.courses.modules.courses.enums.CategoriesEnum;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCourseRequestDTO {
  private String name;
  private Boolean active;
  private CategoriesEnum category;
}
