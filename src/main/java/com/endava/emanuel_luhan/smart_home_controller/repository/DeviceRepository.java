package com.endava.emanuel_luhan.smart_home_controller.repository;

import com.endava.emanuel_luhan.smart_home_controller.model.Device;
import com.endava.emanuel_luhan.smart_home_controller.model.DeviceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
