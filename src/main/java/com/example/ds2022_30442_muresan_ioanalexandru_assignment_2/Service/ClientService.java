package com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Service;

import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.Builders.ConsumptionBuilder;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.Builders.DeviceBuilder;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.ConsSelectionDTO;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.ConsumptionDTO;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.DeviceDTO;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Model.Consumption;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Model.Device;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Repository.ConsumptionRepository;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Repository.DeviceRepository;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private ConsumptionRepository consumptionRepository;

    public List<ConsumptionDTO> getConsumption(ConsSelectionDTO consSelectionDTO) {
        List<ConsumptionDTO> consumptionDTOS = new ArrayList<>();

        ConsumptionBuilder consumptionBuilder = new ConsumptionBuilder();

        List<Consumption> consumptions = consumptionRepository.findAll().stream()
                        .filter(item -> item.getDevice().getId().equals(consSelectionDTO.getDevID()))
                        .collect(Collectors.toList());

        for (Consumption c:consumptions)
            System.out.println(c.getConsumedkW()+"  "+c.getDate().getDate() +" "+c.getDate().getMonth()
            +" "+c.getDate().getYear());

        consumptions = consumptions.stream()
                                    .filter(item -> item.getDate().getDate() == consSelectionDTO.getDay()
                                            && item.getDate().getMonth() == consSelectionDTO.getMonth()
                                            && (item.getDate().getYear() + 1900) == consSelectionDTO.getYear())
                                    .collect(Collectors.toList());


        for (Consumption c: consumptions) {
            consumptionDTOS.add(consumptionBuilder.toConsumptionDTO(c));
        }

        return consumptionDTOS;
    }

    public List<DeviceDTO> getDevices(Long userID) {
        List<DeviceDTO> deviceDTOS = new ArrayList<>();
        List<Device> devices = deviceRepository.findAll();

        DeviceBuilder deviceBuilder = new DeviceBuilder();

        for (Device d : devices) {
            if (d.getDeviceOwner() != null)
                if (d.getDeviceOwner().getId().equals(userID))
                    deviceDTOS.add(deviceBuilder.todeviceDTO(d));
        }

        return deviceDTOS;
    }
}
