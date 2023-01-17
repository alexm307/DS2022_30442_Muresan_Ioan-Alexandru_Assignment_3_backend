package com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO;

public class DeviceDTO {

    private Long id;

    private String description;

    private String address;

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
}
