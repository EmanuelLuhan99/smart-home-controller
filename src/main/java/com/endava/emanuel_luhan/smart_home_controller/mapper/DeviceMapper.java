package com.endava.emanuel_luhan.smart_home_controller.mapper;

import com.endava.emanuel_luhan.smart_home_controller.dto.DeviceCreateRequest;
import com.endava.emanuel_luhan.smart_home_controller.dto.DeviceResponse;
import com.endava.emanuel_luhan.smart_home_controller.dto.DeviceUpdateRequest;
import com.endava.emanuel_luhan.smart_home_controller.model.*;

public final class DeviceMapper {

    private DeviceMapper(){}

    public static Device toEntity(DeviceCreateRequest request){

        if (request == null)
            return null;

        String name = request.getName();
        String status = request.getStatus() != null ? request.getStatus() : "OFF";

        return switch (request.getType()){
            case ALARM -> new AlarmDevice(name, status, false);
            case LIGHT -> new LightDevice(name, status, 0);
            case THERMOSTAT -> new ThermostatDevice(name, status, 22.0);
        };
    }

    public static void updateEntity(Device device, DeviceUpdateRequest request){

        if (request == null)
            return;

        device.setName(request.getName());

        if (request.getStatus() != null){
            device.setStatus(request.getStatus());
        }
    }

    public static DeviceResponse toResponse(Device device){

        if (device == null)
            return null;

        DeviceType type;
        if (device instanceof LightDevice){
            type=DeviceType.LIGHT;
        } else if (device instanceof ThermostatDevice) {
            type = DeviceType.THERMOSTAT;
        } else if (device instanceof AlarmDevice) {
            type = DeviceType.ALARM;
        } else {
            throw new IllegalStateException("Unknown device subclass: " + device.getClass());
        }

        return DeviceResponse.builder()
                .id(device.getId())
                .name(device.getName())
                .status(device.getStatus())
                .type(type)
                .build();
    }
}
