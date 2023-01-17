package com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "consumption")
public class Consumption {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "deviceID")
    private Device device;

    @Column(name = "hour")
    private int hour;

    @Column(name = "consumedkW")
    private double consumedkW;

    @Column(name = "date")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public double getConsumedkW() {
        return consumedkW;
    }

    public void setConsumedkW(double consumedkW) {
        this.consumedkW = consumedkW;
    }

}
