package com.intake21.customapp.serviceImpls;

import com.intake21.customapp.dto.requests.CourseDTO;
import com.intake21.customapp.exceptions.NotFoundException;
import com.intake21.customapp.models.Course;
import com.intake21.customapp.models.Student;
import com.intake21.customapp.repositories.CourseRepository;
import com.intake21.customapp.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private  final CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {

        try {
            return courseRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Course getCourseById(UUID id) {
        try {
            return courseRepository.findById(id).orElseThrow(() -> new NotFoundException("The purchase with the given id was not found"));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Course createCourse(CourseDTO courseDTO) {
       try{
              Course course = new Course();
              course.setCourseName(courseDTO.getCourseName());
              course.setCourseCode(courseDTO.getCourseCode());
              course.setCourseDescription(courseDTO.getCourseDescription());
              return courseRepository.save(course);
       }catch (Exception e) {
           e.printStackTrace();
       }
       return null;

    }
}
