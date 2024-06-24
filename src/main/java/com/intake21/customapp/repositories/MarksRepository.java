package com.intake21.customapp.repositories;

import com.intake21.customapp.models.Course;
import com.intake21.customapp.models.Marks;
import com.intake21.customapp.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MarksRepository  extends JpaRepository<Marks, UUID> {
    List<Marks> findAllByStudent(Student student);
    List<Marks> findAllByCourse(Course course);
}
