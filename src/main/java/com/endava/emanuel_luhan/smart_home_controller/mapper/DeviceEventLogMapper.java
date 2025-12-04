package com.endava.emanuel_luhan.smart_home_controller.mapper;

import com.endava.emanuel_luhan.smart_home_controller.dto.DeviceEventLogResponse;
import com.endava.emanuel_luhan.smart_home_controller.model.DeviceEventLog;

public final class DeviceEventLogMapper {

    private DeviceEventLogMapper(){}

    public static DeviceEventLogResponse toResponse(DeviceEventLog log){
        if (log == null)
            return null;

        return DeviceEventLogResponse.builder()
                .id(log.getId())
                .deviceId(log.getDeviceId())
                .deviceName(log.getDeviceName())
                .oldStatus(log.getOldStatus())
                .newStatus(log.getNewStatus())
                .action(log.getAction())
                .timestamp(log.getTimestamp())
                .build();
    }
}
