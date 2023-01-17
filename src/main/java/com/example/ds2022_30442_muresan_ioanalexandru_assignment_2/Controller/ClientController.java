package com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Controller;

import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.ConsSelectionDTO;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.ConsumptionDTO;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.DeviceDTO;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @PostMapping("/getConsumption")
    public List<ConsumptionDTO> getConsumption(@RequestBody ConsSelectionDTO consSelectionDTO) {
        System.out.println(consSelectionDTO.getMonth() + " " + consSelectionDTO.getYear());
        //consSelectionDTO.setMonth(consSelectionDTO.getMonth() + 1);
        return clientService.getConsumption(consSelectionDTO);
    }

    @GetMapping("/getDevices/{uID}")
    public List<DeviceDTO> getDevices(@PathVariable Long uID) {
        return clientService.getDevices(uID);
    }
}
