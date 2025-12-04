package com.endava.emanuel_luhan.smart_home_controller.repository;

import com.endava.emanuel_luhan.smart_home_controller.model.DeviceEventLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceEventLogRepository extends JpaRepository<DeviceEventLog, Long> {

    List<DeviceEventLog> findByDeviceIdOrderByTimestampDesc(Long deviceId);
}
