package com.endava.emanuel_luhan.smart_home_controller.dto;

import com.endava.emanuel_luhan.smart_home_controller.model.LogAction;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class DeviceEventLogResponse {
    private Long id;
    private Long deviceId;
    private String deviceName;
    private String oldStatus;
    private String newStatus;
    private LogAction action;
    private LocalDateTime timestamp;

}
