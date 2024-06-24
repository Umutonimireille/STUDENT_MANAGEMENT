package com.intake21.customapp.service;

import com.intake21.customapp.dto.requests.MarksDTO;
import com.intake21.customapp.models.Marks;

import java.util.List;
import java.util.UUID;

public interface MarksService {

    List<Marks> getAllMarks();
    Marks getMarksById(UUID id);
    Marks createMarks(MarksDTO marks);
    List<Marks> getMarksByStudentId(UUID studentId);
    List<Marks> getMarksByCourseId(UUID courseId);
}
