package com.intake21.customapp.serviceImpls;

import com.intake21.customapp.dto.requests.StudentDTO;
import com.intake21.customapp.exceptions.NotFoundException;
import com.intake21.customapp.models.Course;
import com.intake21.customapp.models.Student;
import com.intake21.customapp.repositories.CourseRepository;
import com.intake21.customapp.repositories.StudentRepository;
import com.intake21.customapp.service.StudentService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Override
    public List<Student> getAllStudents() {
        try {
            return studentRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Student getStudentById(UUID id) {
        try {
            return studentRepository.findById(id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Student createStudent(StudentDTO student) {
        try {
            Student studentEntity = new Student();
            studentEntity.setFirstName(student.getFirstName());
            studentEntity.setLastName(student.getLastName());
            studentEntity.setEmail(student.getEmail());
            studentEntity.setGender(student.getGender());

            return studentRepository.save(studentEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Student assingCourseToStudent(UUID studentId, UUID courseId) {
        try {
            Student student = studentRepository.findById(studentId).orElseThrow(() -> new NotFoundException("The student with the given id was not found"));
            Course course = courseRepository.findById(courseId).orElseThrow(() -> new NotFoundException("The course with the given id was not found"));
            Set<Course> courses = student.getCourses();
            courses.add(course);
            student.setCourses(courses);
            return studentRepository.save(student);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

