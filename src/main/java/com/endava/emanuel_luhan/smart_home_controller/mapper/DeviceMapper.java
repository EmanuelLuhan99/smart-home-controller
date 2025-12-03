package com.endava.emanuel_luhan.smart_home_controller.mapper;

import com.endava.emanuel_luhan.smart_home_controller.dto.DeviceRequest;
import com.endava.emanuel_luhan.smart_home_controller.dto.DeviceResponse;
import com.endava.emanuel_luhan.smart_home_controller.model.Device;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class DeviceMapper {

    public static Device toEntity(DeviceRequest request){

        if (request == null)
            return null;

        Device device = new Device();
        device.setName(request.getName());
        device.setStatus(request.getStatus());
        device.setType(request.getType());

        return device;
    }

    public static void updateEntity(Device device, DeviceRequest request){

        if (request == null)
            return;

        device.setName(request.getName());
        device.setType(request.getType());
        if (request.getStatus() != null){
            device.setStatus(request.getStatus());
        }
    }

    public static DeviceResponse toResponse(Device device){

        if (device == null)
            return null;

        return DeviceResponse.builder()
                .id(device.getId())
                .name(device.getName())
                .status(device.getStatus())
                .type(device.getType())
                .build();
    }
}
