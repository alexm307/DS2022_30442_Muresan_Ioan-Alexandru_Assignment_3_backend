package com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Service;

import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.Builders.DeviceBuilder;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.Builders.UserBuilder;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.DeviceDTO;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.UserDataDTO;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Model.Device;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Model.User;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Repository.DeviceRepository;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    public boolean createDevice(DeviceDTO deviceDTO) {
        DeviceBuilder deviceBuilder = new DeviceBuilder();

        if (!Validator.isDeviceValid(deviceDTO))
            return false;

        Device newDevice = deviceBuilder.toDevice(deviceDTO);
        deviceRepository.save(newDevice);
        return true;
    }

    public List<DeviceDTO> viewDevices() {
        List<DeviceDTO> deviceDTOS = new ArrayList<>();
        List<Device> devices = deviceRepository.findAll();

        DeviceBuilder deviceBuilder = new DeviceBuilder();

        for (Device d : devices)
            deviceDTOS.add(deviceBuilder.todeviceDTO(d));

        return deviceDTOS;
    }

    public boolean updateDevice(DeviceDTO deviceDTO) {
        Device device = deviceRepository.getReferenceById(deviceDTO.getId());

        if (device.getAddress() == null || device.getAddress().isEmpty())
            return false;

        if (deviceDTO.getAddress() != null && !deviceDTO.getAddress().isEmpty())
            device.setAddress(deviceDTO.getAddress());
        if (deviceDTO.getDescription() != null && !deviceDTO.getDescription().isEmpty())
            device.setDescription(deviceDTO.getDescription());
        if (!deviceDTO.getMaxConsHr().isNaN())
            device.setMaxConsHr(deviceDTO.getMaxConsHr());

        deviceRepository.save(device);
        return true;
    }

    public void deleteDevice(Long devID) {
        deviceRepository.deleteById(devID);
    }

    public boolean createUser(UserDataDTO userDataDTO) {
        UserBuilder userBuilder = new UserBuilder();

        System.out.println(userDataDTO.getUsername() + "   " + userDataDTO.getPassword());

        if (!Validator.isUserValid(userDataDTO))
            return false;

        User newUser = userBuilder.toUser(userDataDTO);
        userRepository.save(newUser);
        return true;
    }

    public List<UserDataDTO> viewUsers() {
        List<UserDataDTO> userDataDTOS = new ArrayList<>();
        List<User> userList = userRepository.findAll();

        UserBuilder userBuilder = new UserBuilder();

        for (User u: userList)
            userDataDTOS.add(userBuilder.toUserDataDTO(u));

        return userDataDTOS;
    }

    public boolean updateUser(UserDataDTO newUserDataDTO) {
        User user = userRepository.getReferenceById(newUserDataDTO.getId());

        if (user.getUsername().isEmpty() || user.getUsername() == null)
            return false;

        if (newUserDataDTO.getUsername() != null && !newUserDataDTO.getUsername().isEmpty())
            user.setUsername(newUserDataDTO.getUsername());
        if (newUserDataDTO.getPassword() != null && !newUserDataDTO.getPassword().isEmpty())
            user.setPassword(newUserDataDTO.getPassword());
        if (newUserDataDTO.getRole() != null)
            user.setRole(newUserDataDTO.getRole());

        userRepository.save(user);
        return true;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public boolean connectUserDevice(Long userID, Long deviceID) {
        User user = userRepository.getReferenceById(userID);
        Device device = deviceRepository.getReferenceById(deviceID);

        if (user.getUsername().isEmpty())
            return false;
        if (device.getAddress().isEmpty())
            return false;
        if (device.getDeviceOwner() != null)
            return false;

        device.setDeviceOwner(user);

        userRepository.save(user);
        deviceRepository.save(device);

        return true;
    }
}
