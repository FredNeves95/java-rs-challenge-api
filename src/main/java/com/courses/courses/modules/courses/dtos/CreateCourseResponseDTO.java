package com.courses.courses.modules.courses.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import com.courses.courses.modules.courses.enums.CategoriesEnum;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateCourseResponseDTO {
  private UUID id;
  private String name;
  private Boolean active;
  private CategoriesEnum category;
  private LocalDateTime createdAt;
}
