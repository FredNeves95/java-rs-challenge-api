package com.courses.courses.exceptions;

public class CourseNotFoundException extends RuntimeException {
  public CourseNotFoundException() {
    super("Course not found!");
  }
}
