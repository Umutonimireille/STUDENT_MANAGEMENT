package com.intake21.customapp.service;


import com.intake21.customapp.dto.requests.CourseDTO;
import com.intake21.customapp.models.Course;

import java.util.List;
import java.util.UUID;

public interface CourseService {

    List<Course> getAllCourses();

    Course getCourseById(UUID id);

    Course createCourse(CourseDTO courseDTO);
}
