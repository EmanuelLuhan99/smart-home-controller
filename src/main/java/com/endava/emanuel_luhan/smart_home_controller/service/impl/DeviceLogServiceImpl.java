package com.endava.emanuel_luhan.smart_home_controller.service.impl;

import com.endava.emanuel_luhan.smart_home_controller.model.Device;
import com.endava.emanuel_luhan.smart_home_controller.model.DeviceEventLog;
import com.endava.emanuel_luhan.smart_home_controller.model.LogAction;
import com.endava.emanuel_luhan.smart_home_controller.repository.DeviceEventLogRepository;
import com.endava.emanuel_luhan.smart_home_controller.service.DeviceLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceLogServiceImpl implements DeviceLogService {

    private final DeviceEventLogRepository deviceEventLogRepository;

    @Override
    public void logStatusChange(Device device, String oldStatus, String newStatus, LogAction action) {

        DeviceEventLog log = new DeviceEventLog(device.getId(),
                device.getName(),
                oldStatus,
                newStatus,
                action,
                LocalDateTime.now());

        deviceEventLogRepository.save(log);
    }

    @Override
    public List<DeviceEventLog> getLogsForDevice(Long deviceId){
        return deviceEventLogRepository.findByDeviceIdOrderByTimestampDesc(deviceId);
    }

    @Override
    public List<DeviceEventLog> getAllLogs() {
        return deviceEventLogRepository.findAll();
    }
}
