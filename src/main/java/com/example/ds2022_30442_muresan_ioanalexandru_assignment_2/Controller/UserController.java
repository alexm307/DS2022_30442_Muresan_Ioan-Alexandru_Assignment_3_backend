package com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Controller;

import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.LoginDTO;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.UserDataDTO;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO) {
        UserDataDTO user = userService.login(loginDTO);

        if (user == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sth went wrong when logging in");
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

}
