package com.intake21.customapp.controllers;

import com.intake21.customapp.dto.requests.UserDataDTO;
import com.intake21.customapp.models.AuthRequest;
import com.intake21.customapp.models.UserData;
import com.intake21.customapp.payload.ApiResponse;
import com.intake21.customapp.security.jwt.JwtService;
import com.intake21.customapp.security.user.UserDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserDataService userDataService;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }
    @PostMapping("/addNewUser")
    ResponseEntity <ApiResponse> addNewUser(@RequestBody UserDataDTO userDataDTO ) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "The user created successfully", this.userDataService.addUser(userDataDTO)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null ;

    }
    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userProfile() {
        return "Welcome to User Profile";
    }
    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }
    @GetMapping("/admin/list")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<UserData> listUsers() {
        return userDataService.listAll();
    }
    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            if (authentication.isAuthenticated()) {
                return jwtService.generateToken(authRequest.getUsername());
            } else {
                throw new UsernameNotFoundException("invalid user request !");
            }
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
//            ResponseEntity.status(500).body(new ApiResponse(false, "Error occurred while generating token", null));
        }
    }

}

