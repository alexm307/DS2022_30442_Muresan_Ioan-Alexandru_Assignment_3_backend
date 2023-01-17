package com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.Builders;


import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.DeviceDTO;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Model.Device;

public class DeviceBuilder {


    public DeviceDTO todeviceDTO(Device device) {
        DeviceDTO deviceDTO = new DeviceDTO();

        if (device.getId() != null)
            deviceDTO.setId(device.getId());
        deviceDTO.setAddress(device.getAddress());
        deviceDTO.setDescription(device.getDescription());
        deviceDTO.setMaxConsHr(device.getMaxConsHr());

        return deviceDTO;
    }

    public Device toDevice(DeviceDTO deviceDTO) {
        Device device = new Device();

        if (deviceDTO.getId() != null)
            device.setId(deviceDTO.getId());
        device.setAddress(deviceDTO.getAddress());
        device.setDescription(deviceDTO.getDescription());
        device.setMaxConsHr(deviceDTO.getMaxConsHr());

        return device;
    }
}
