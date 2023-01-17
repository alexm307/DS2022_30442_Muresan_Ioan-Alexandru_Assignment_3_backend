package com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "device")
public class Device {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "deviceID")
    private User deviceOwner;

    @Column(name = "description")
    private String description;

    @Column(name = "address")
    private String address;

    @Column(name = "maximumConsumption")
    private Double maxConsHr;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getMaxConsHr() {
        return maxConsHr;
    }

    public void setMaxConsHr(Double maxConsHr) {
        this.maxConsHr = maxConsHr;
    }

    public User getDeviceOwner() {
        return deviceOwner;
    }

    public void setDeviceOwner(User deviceOwner) {
        this.deviceOwner = deviceOwner;
    }
}
