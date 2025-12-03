package com.endava.emanuel_luhan.smart_home_controller.service.impl;

import com.endava.emanuel_luhan.smart_home_controller.dto.ChangeStatusRequest;
import com.endava.emanuel_luhan.smart_home_controller.dto.DeviceRequest;
import com.endava.emanuel_luhan.smart_home_controller.dto.DeviceResponse;
import com.endava.emanuel_luhan.smart_home_controller.mapper.DeviceMapper;
import com.endava.emanuel_luhan.smart_home_controller.model.Device;
import com.endava.emanuel_luhan.smart_home_controller.repository.DeviceRepository;
import com.endava.emanuel_luhan.smart_home_controller.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;

    @Override
    public DeviceResponse createDevice(DeviceRequest request) {
        Device device = DeviceMapper.toEntity(request);

        if (device.getStatus() == null){
            device.setStatus("OFF");
        }

        Device saved = deviceRepository.save(device);

        return DeviceMapper.toResponse(saved);
    }

    @Override
    public DeviceResponse getDeviceById(Long id) {

        Device device = deviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());//change this exception(MODIFY)

        return DeviceMapper.toResponse(device);
    }

    @Override
    public List<DeviceResponse> getAllDevices() {
        return deviceRepository.findAll()
                .stream()
                .map(DeviceMapper::toResponse)
                .toList();
    }

    @Override
    public DeviceResponse updateDevice(Long id, DeviceRequest request) {
        Device device = deviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());

        String oldStatus = device.getStatus();

        DeviceMapper.updateEntity(device, request);
        Device updatedDevice = deviceRepository.save(device);

        return DeviceMapper.toResponse(updatedDevice);
    }

    @Override
    public void deleteDevice(Long id) {
        Device device = deviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());

        deviceRepository.delete(device);
    }

    @Override
    public  DeviceResponse changeStatus(Long id, ChangeStatusRequest request){
        Device device = deviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());

        String oldStatus = device.getStatus();
        device.setStatus(request.getStatus());
        Device updatedDevice = deviceRepository.save(device);

        return DeviceMapper.toResponse(updatedDevice);
    }

}
