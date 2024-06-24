package com.intake21.customapp.dto.requests;

import com.intake21.customapp.enums.EGender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class StudentDTO {
    private  String firstName;
    private  String lastName;
    private  String email;
    private EGender gender;



}
