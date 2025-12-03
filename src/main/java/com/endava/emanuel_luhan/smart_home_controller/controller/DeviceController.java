package com.endava.emanuel_luhan.smart_home_controller.controller;

import com.endava.emanuel_luhan.smart_home_controller.dto.ChangeStatusRequest;
import com.endava.emanuel_luhan.smart_home_controller.dto.DeviceRequest;
import com.endava.emanuel_luhan.smart_home_controller.dto.DeviceResponse;
import com.endava.emanuel_luhan.smart_home_controller.service.DeviceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/devices")
public class DeviceController {

    private final DeviceService deviceService;

    @PostMapping
    public ResponseEntity<DeviceResponse> createDevice(@RequestBody @Valid DeviceRequest request){

        log.info("Received request to create device: {}", request);

        DeviceResponse response = deviceService.createDevice(request);

        log.info("Device created successfully with id = {}", response.getId());

        return ResponseEntity.created(URI.create("/devices/" + response.getId()))
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceResponse> getDeviceById(@PathVariable Long id){

        log.info("Fetching device with id = {}", id);

        DeviceResponse response = deviceService.getDeviceById(id);

        log.info("Successfully fetched device with id = {}", id);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<DeviceResponse>> getAllDevices(){

        log.info("Fetching all devices");

        List<DeviceResponse> responses = deviceService.getAllDevices();

        log.info("Fetched {} devices", responses.size());

        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeviceResponse> updateDevice(@PathVariable Long id, @RequestBody @Valid DeviceRequest request){

       log.info("Updating device with id = {} using {}", id, request);

       DeviceResponse response = deviceService.updateDevice(id, request);

       log.info("Device with id = {} updated successfully", id);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id){

        log.info("Deleting device with id={}", id);

        deviceService.deleteDevice(id);

        log.info("Device with id={} deleted successfully", id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<DeviceResponse> changeStatus(@PathVariable Long id, @RequestBody @Valid ChangeStatusRequest request){

        log.info("Changing status of device id={} to '{}'", id, request.getStatus());

        DeviceResponse response = deviceService.changeStatus(id, request);

        log.info("Status of device id={} successfully changed to '{}'", id, response.getStatus());

        return ResponseEntity.ok(response);
    }
}
