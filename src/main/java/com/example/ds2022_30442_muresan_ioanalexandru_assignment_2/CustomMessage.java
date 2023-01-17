package com.example.ds2022_30442_muresan_ioanalexandru_assignment_2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@ToString
public class CustomMessage implements Serializable {

    private Timestamp timestamp;

    private String deviceId;

    private String measurementValue;

    public CustomMessage(@JsonProperty("timestamp") Timestamp timestamp,
                         @JsonProperty("device_id") String deviceId,
                         @JsonProperty("measurement_value") String measurementValue) {
        this.timestamp = timestamp;
        this.deviceId = deviceId;
        this.measurementValue = measurementValue;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getMeasurementValue() {
        return measurementValue;
    }

    public void setMeasurementValue(String measurementValue) {
        this.measurementValue = measurementValue;
    }
}

/*
public record CustomMessage(
                            @JsonProperty("timestamp") Timestamp timestamp,
                            @JsonProperty("device_id") String deviceId,
                            @JsonProperty("measurement_value") String measurementValue)
        implements Serializable {

}
*/