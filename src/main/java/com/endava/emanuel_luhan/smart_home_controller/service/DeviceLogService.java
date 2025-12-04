package com.endava.emanuel_luhan.smart_home_controller.service;

import com.endava.emanuel_luhan.smart_home_controller.model.Device;
import com.endava.emanuel_luhan.smart_home_controller.model.DeviceEventLog;
import com.endava.emanuel_luhan.smart_home_controller.model.LogAction;

import java.util.List;

public interface DeviceLogService {

    void logStatusChange(Device device, String oldStatus, String newStatus, LogAction action);
    List<DeviceEventLog> getLogsForDevice(Long deviceId);
    List<DeviceEventLog> getAllLogs();
}
