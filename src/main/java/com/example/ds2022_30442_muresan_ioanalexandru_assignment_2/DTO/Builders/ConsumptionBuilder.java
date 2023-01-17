package com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.Builders;


import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO.ConsumptionDTO;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Model.Consumption;

public class ConsumptionBuilder {

    public ConsumptionDTO toConsumptionDTO(Consumption consumption) {
        ConsumptionDTO newConsDTO = new ConsumptionDTO();

        newConsDTO.setHour(consumption.getHour());
        newConsDTO.setConsumedKw(consumption.getConsumedkW());

        return newConsDTO;
    }
}
