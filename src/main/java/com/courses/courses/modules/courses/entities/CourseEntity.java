package com.courses.courses.modules.courses.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.courses.courses.modules.courses.enums.CategoriesEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "courses")
public class CourseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;


  @NonNull
  private String name;

  private Boolean active;

  @Enumerated(EnumType.STRING)
  private CategoriesEnum category;
  
  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
