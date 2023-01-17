package com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Service;

import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.DeviceDTO;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.UserDataDTO;

public class Validator {

    public static boolean isUserValid(UserDataDTO user) {
        if (user.getUsername() == null || user.getUsername().isEmpty())
            return false;
        if (user.getRole() == null)
            return false;
        return user.getPassword() != null && !user.getPassword().isEmpty();
    }

    public static boolean isDeviceValid(DeviceDTO device) {
        if (device.getAddress() == null || device.getAddress().isEmpty())
            return false;
        if (device.getDescription() == null || device.getDescription().isEmpty())
            return false;
        return !device.getMaxConsHr().isNaN();
    }
}
