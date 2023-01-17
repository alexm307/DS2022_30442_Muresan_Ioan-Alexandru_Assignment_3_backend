package com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Repository;

import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
}
