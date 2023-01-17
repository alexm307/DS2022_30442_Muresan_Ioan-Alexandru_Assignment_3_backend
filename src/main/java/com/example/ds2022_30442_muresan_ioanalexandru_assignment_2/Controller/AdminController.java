package com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Controller;


import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.ConnectionDTO;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.DeviceDTO;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.UserDataDTO;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/createUser")
    public ResponseEntity createUser(@RequestBody UserDataDTO newUserData) {
        if (adminService.createUser(newUserData))
            return ResponseEntity.status(HttpStatus.OK).body("Succesfully registered!");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something was wrong when registering!");
    }

    @GetMapping("/getUsers")
    public List<UserDataDTO> viewUsers() {
        return adminService.viewUsers();
    }

    @PostMapping("/updateUser")
    public ResponseEntity updateUser(@RequestBody UserDataDTO userDataDTO) {
        adminService.updateUser(userDataDTO);
        return ResponseEntity.status(HttpStatus.OK).body("User succesfully updated!");
    }

    @PostMapping("/deleteUser/{uID}")
    public ResponseEntity deleteUser(@RequestBody Long uID) {
        adminService.deleteUser(uID);
        return ResponseEntity.status(HttpStatus.OK).body("User succesfully deleted!");
    }

    @PostMapping("/createDevice")
    public ResponseEntity createDevice(@RequestBody DeviceDTO newDevice) {
        if (adminService.createDevice(newDevice))
            return ResponseEntity.status(HttpStatus.OK).body("Succesfully registered!");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something was wrong when registering!");
    }

    @GetMapping("/getDevices")
    public List<DeviceDTO> viewDevices() {
        return adminService.viewDevices();
    }

    @PostMapping("/updateDevice")
    public ResponseEntity updateDevice(@RequestBody DeviceDTO deviceDTO) {
        adminService.updateDevice(deviceDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Device succesfully updated!");
    }

    @PostMapping("/deleteDevice/{dID}")
    public ResponseEntity deleteDevice(@PathVariable Long dID) {
        System.out.println(dID);
        adminService.deleteDevice(dID);
        return ResponseEntity.status(HttpStatus.OK).body("Device succesfully deleted!");
    }

    @PostMapping("/connectUserDevice")
    public ResponseEntity connectUserDevice(@RequestBody ConnectionDTO connectionDTO) {
        if (adminService.connectUserDevice(connectionDTO.getUserID(), connectionDTO.getDevID()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Connection not ok?");
        else
            return ResponseEntity.status(HttpStatus.OK).body("");
    }
}
