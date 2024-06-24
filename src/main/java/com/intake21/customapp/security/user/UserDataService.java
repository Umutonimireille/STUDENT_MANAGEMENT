package com.intake21.customapp.security.user;

import com.intake21.customapp.dto.requests.UserDataDTO;
import com.intake21.customapp.models.UserData;
import com.intake21.customapp.repositories.UserDataRepository;
import com.intake21.customapp.security.user.UserDataDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserDataService implements UserDetailsService {
    public UserDataService(UserDataRepository repository,  @Lazy PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public UserDataService () {}

    @Autowired
    private UserDataRepository repository;
    @Autowired
    private PasswordEncoder encoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserData> userData = repository.findByEmail(username);
        //Convert userData to UserDetails
        return userData.map(UserDataDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }
    public UserData loadCurrentUser(String username) throws UsernameNotFoundException {
        Optional<UserData> userDetail = repository.findByEmail(username);
        return userDetail
                .orElseThrow(() -> new UsernameNotFoundException("User not found " +
                        username));
    }
    public String addUser(UserDataDTO userDataDTO) {
        UserData userData = new UserData();
        userData.setEmail(userDataDTO.getEmail());
        userData.setName(userDataDTO.getName());
        userData.setRoles(userDataDTO.getRoles());
        userData.setPassword(userDataDTO.getPassword());
        userDataDTO.setPassword(encoder.encode(userDataDTO.getPassword()));
        repository.save(userData);
        return "User Added Successfully";
    }
    public List<UserData> listAll() {
        return repository.findAll();
    }
}

