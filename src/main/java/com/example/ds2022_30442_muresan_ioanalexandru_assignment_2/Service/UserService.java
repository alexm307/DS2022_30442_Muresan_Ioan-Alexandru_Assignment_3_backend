package com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Service;

import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.Builders.UserBuilder;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.LoginDTO;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.UserDataDTO;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Model.User;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDataDTO login(LoginDTO loginDTO){
        List<User> allUsers = userRepository.findAll();
        UserDataDTO loggedUser = new UserDataDTO();
        UserBuilder userBuilder = new UserBuilder();

        System.out.println("Total users in DB:" + allUsers.size());

        for (User u : allUsers)
            if (u.getUsername().equals(loginDTO.getUsername())
                    && u.getPassword().equals(loginDTO.getPassword())) {
                loggedUser = userBuilder.toUserDataDTO(u);
                return loggedUser;
            }
        return null;
    }
}
