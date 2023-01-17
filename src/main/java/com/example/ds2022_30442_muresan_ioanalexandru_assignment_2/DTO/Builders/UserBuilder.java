package com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.Builders;


import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.UserDataDTO;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Model.User;

public class UserBuilder {

    public UserDataDTO toUserDataDTO(User user) {
        UserDataDTO userDataDTO = new UserDataDTO();
        userDataDTO.setId(user.getId());
        userDataDTO.setRole(user.getRole());
        userDataDTO.setUsername(user.getUsername());
        userDataDTO.setPassword(user.getPassword());

        return userDataDTO;
    }

    public User toUser(UserDataDTO userDataDTO){
        User user = new User();
        user.setUsername(userDataDTO.getUsername());
        user.setPassword(userDataDTO.getPassword());
        user.setRole(userDataDTO.getRole());

        return user;
    }
}
