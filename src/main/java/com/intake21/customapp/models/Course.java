package com.intake21.customapp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Course {
    @Id
    @GeneratedValue
    private UUID id;
    private  String courseName;
    private  String courseCode;
    private  String courseDescription;

    @ManyToMany(mappedBy = "courses" ,  fetch = FetchType.LAZY)
    private Set<Student> students = new HashSet<>();


}
