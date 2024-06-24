package com.intake21.customapp.dto.requests;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserDataDTO {
    private String name;
    private String email;
    private String password;
    private String roles;;
}
