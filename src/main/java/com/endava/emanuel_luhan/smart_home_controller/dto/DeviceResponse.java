package com.endava.emanuel_luhan.smart_home_controller.dto;

import com.endava.emanuel_luhan.smart_home_controller.model.DeviceType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DeviceResponse {
    private Long id;
    private String name;
    private String status;
    private DeviceType type;
}
