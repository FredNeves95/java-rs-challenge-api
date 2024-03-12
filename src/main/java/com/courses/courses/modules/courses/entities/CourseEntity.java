package com.courses.courses.modules.courses.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.courses.courses.modules.courses.enums.CategoriesEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
@Entity(name = "courses")
public class CourseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;


  @NonNull
  private String name;

  private Boolean active;

  private CategoriesEnum category;
  
  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
