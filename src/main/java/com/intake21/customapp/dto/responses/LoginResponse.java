package com.intake21.customapp.dto.responses;

import com.intake21.customapp.models.Role;
import com.intake21.customapp.models.UserData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class LoginResponse {

    public String token;
    public UserData userData;
    private Set<Role> userRoles;
}
