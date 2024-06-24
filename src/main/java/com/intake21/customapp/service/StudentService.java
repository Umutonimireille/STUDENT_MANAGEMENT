package com.intake21.customapp.service;

import com.intake21.customapp.dto.requests.StudentDTO;
import com.intake21.customapp.models.Student;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(UUID id);
    Student createStudent(StudentDTO student);
     Student assingCourseToStudent(UUID studentId, UUID courseId);
}
