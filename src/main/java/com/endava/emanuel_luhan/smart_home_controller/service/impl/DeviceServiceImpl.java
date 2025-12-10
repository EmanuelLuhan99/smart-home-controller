package com.endava.emanuel_luhan.smart_home_controller.service.impl;

import com.endava.emanuel_luhan.smart_home_controller.dto.ChangeStatusRequest;
import com.endava.emanuel_luhan.smart_home_controller.dto.DeviceCreateRequest;
import com.endava.emanuel_luhan.smart_home_controller.dto.DeviceResponse;
import com.endava.emanuel_luhan.smart_home_controller.dto.DeviceUpdateRequest;
import com.endava.emanuel_luhan.smart_home_controller.exception.DeviceNotFoundException;
import com.endava.emanuel_luhan.smart_home_controller.mapper.DeviceMapper;
import com.endava.emanuel_luhan.smart_home_controller.model.Device;
import com.endava.emanuel_luhan.smart_home_controller.model.LogAction;
import com.endava.emanuel_luhan.smart_home_controller.repository.DeviceRepository;
import com.endava.emanuel_luhan.smart_home_controller.service.DeviceLogService;
import com.endava.emanuel_luhan.smart_home_controller.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;
    private final DeviceLogService deviceLogService;

    @Override
    public DeviceResponse createDevice(DeviceCreateRequest request) {
        Device device = DeviceMapper.toEntity(request);

        if (device.getStatus() == null){
            device.setStatus("OFF");
        }

        Device saved = deviceRepository.save(device);

        deviceLogService.logStatusChange(saved, null, saved.getStatus(), LogAction.CREATED);

        return DeviceMapper.toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public DeviceResponse getDeviceById(Long id) {

        Device device = getDeviceOrThrow(id);

        return DeviceMapper.toResponse(device);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DeviceResponse> getAllDevices() {
        return deviceRepository.findAll()
                .stream()
                .map(DeviceMapper::toResponse)
                .toList();
    }

    @Override
    public DeviceResponse updateDevice(Long id, DeviceUpdateRequest request) {

        Device device = getDeviceOrThrow(id);

        String oldStatus = device.getStatus();

        DeviceMapper.updateEntity(device, request);
        Device updatedDevice = deviceRepository.save(device);

        if (oldStatus != null && !oldStatus.equals(updatedDevice.getStatus())) {
            deviceLogService.logStatusChange(
                    updatedDevice,
                    oldStatus,
                    updatedDevice.getStatus(),
                    LogAction.UPDATED
            );
        }

        return DeviceMapper.toResponse(updatedDevice);
    }

    @Override
    public void deleteDevice(Long id) {

        Device device = getDeviceOrThrow(id);

        deviceRepository.delete(device);

        deviceLogService.logStatusChange(
                device,
                device.getStatus(),
                null,
                LogAction.DELETED
        );
    }

    @Override
    public  DeviceResponse changeStatus(Long id, ChangeStatusRequest request){

        Device device = getDeviceOrThrow(id);

        String oldStatus = device.getStatus();
        device.setStatus(request.getStatus());
        Device updatedDevice = deviceRepository.save(device);

        deviceLogService.logStatusChange(
                updatedDevice,
                oldStatus,
                updatedDevice.getStatus(),
                LogAction.STATUS_CHANGED
        );

        return DeviceMapper.toResponse(updatedDevice);
    }


    private Device getDeviceOrThrow(Long id){
        return deviceRepository.findById(id)
                .orElseThrow(() -> new DeviceNotFoundException(id));
    }
}
