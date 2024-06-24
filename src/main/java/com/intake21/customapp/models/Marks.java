package com.intake21.customapp.models;


import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Getter
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private float marks;
    private String grade;
    private int totalMarks;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
