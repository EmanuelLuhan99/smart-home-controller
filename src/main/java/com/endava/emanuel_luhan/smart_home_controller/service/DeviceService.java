package com.endava.emanuel_luhan.smart_home_controller.service;

import com.endava.emanuel_luhan.smart_home_controller.dto.ChangeStatusRequest;
import com.endava.emanuel_luhan.smart_home_controller.dto.DeviceCreateRequest;
import com.endava.emanuel_luhan.smart_home_controller.dto.DeviceResponse;
import com.endava.emanuel_luhan.smart_home_controller.dto.DeviceUpdateRequest;

import java.util.List;

public interface DeviceService {

    DeviceResponse createDevice(DeviceCreateRequest request);
    DeviceResponse getDeviceById(Long id);
    List<DeviceResponse> getAllDevices();
    DeviceResponse updateDevice(Long id, DeviceUpdateRequest request);
    void deleteDevice(Long id);
    DeviceResponse changeStatus(Long id, ChangeStatusRequest request);
}
