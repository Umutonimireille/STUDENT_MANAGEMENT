package com.intake21.customapp.repositories;

import com.intake21.customapp.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository

public interface CourseRepository extends JpaRepository<Course, UUID> {
}
