package com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Service;

import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.CustomMessage;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Message;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Model.Consumption;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Model.Device;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Repository.ConsumptionRepository;
import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Repository.DeviceRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class QueueConsumer {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private ConsumptionRepository consumptionRepository;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;


/*
    @RabbitListener(queues = "${queue.name}")
    public void receive(String messageJSON) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        CustomMessage message = mapper.readValue(messageJSON, CustomMessage.class);

        System.out.println("Message " + messageJSON);
        Consumption consumption = new Consumption();
        consumption.setConsumedkW(Double.parseDouble(message.getMeasurementValue()));
        List<Device> devices = deviceRepository.findAll();
        System.out.println(message.getDeviceId());

        if (devices.size() > 0) {
            for (Device d : devices) {
                if (d.getId() == Long.parseLong(message.getDeviceId()))
                    consumption.setDevice(d);
            }

            Date date = new Date(message.getTimestamp().getTime());
            consumption.setDate(date);
            int hours = message.getTimestamp().getHours() % 12;
            consumption.setHour(hours);

            System.out.println(consumption.getConsumedkW() + " " + consumption.getHour() + " " + consumption.getDate());

            //Now save into database, check if device consumption is too much and
            consumptionRepository.save(consumption);

            if (consumption.getDevice().getMaxConsHr() < consumption.getConsumedkW()) {

                Device dev = consumption.getDevice();
                String username = dev.getDeviceOwner().getUsername();

                Message mes = new Message(username, "Exceeded consumption limit with the amount of "
                        + consumption.getConsumedkW() + " while the limit is " + dev.getMaxConsHr());

                simpMessagingTemplate.convertAndSend("/all/messages/" + username, mes);
            }
        }

    }
*/
}