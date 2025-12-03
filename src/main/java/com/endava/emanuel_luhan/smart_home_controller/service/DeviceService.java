package com.endava.emanuel_luhan.smart_home_controller.service;

import com.endava.emanuel_luhan.smart_home_controller.dto.ChangeStatusRequest;
import com.endava.emanuel_luhan.smart_home_controller.dto.DeviceRequest;
import com.endava.emanuel_luhan.smart_home_controller.dto.DeviceResponse;

import java.util.List;

public interface DeviceService {

    DeviceResponse createDevice(DeviceRequest request);
    DeviceResponse getDeviceById(Long id);
    List<DeviceResponse> getAllDevices();
    DeviceResponse updateDevice(Long id, DeviceRequest request);
    void deleteDevice(Long id);
    DeviceResponse changeStatus(Long id, ChangeStatusRequest request);
}
