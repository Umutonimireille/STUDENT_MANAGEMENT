package com.intake21.customapp.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MarksDTO {
    private float marks;
    private String grade;
    private int totalMarks;
    private UUID studentId;
    private  UUID courseId;
}
