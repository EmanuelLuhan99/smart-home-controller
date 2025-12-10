package com.endava.emanuel_luhan.smart_home_controller.controller;

import com.endava.emanuel_luhan.smart_home_controller.dto.ChangeStatusRequest;
import com.endava.emanuel_luhan.smart_home_controller.dto.DeviceCreateRequest;
import com.endava.emanuel_luhan.smart_home_controller.dto.DeviceResponse;
import com.endava.emanuel_luhan.smart_home_controller.dto.DeviceUpdateRequest;
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
    public ResponseEntity<DeviceResponse> createDevice(@RequestBody @Valid DeviceCreateRequest request){

        DeviceResponse response = deviceService.createDevice(request);

        return ResponseEntity.created(URI.create("/devices/" + response.getId()))
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceResponse> getDeviceById(@PathVariable Long id){

        DeviceResponse response = deviceService.getDeviceById(id);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<DeviceResponse>> getAllDevices(){

        List<DeviceResponse> responses = deviceService.getAllDevices();

        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeviceResponse> updateDevice(@PathVariable Long id, @RequestBody @Valid DeviceUpdateRequest request){

        DeviceResponse response = deviceService.updateDevice(id, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id){

        deviceService.deleteDevice(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<DeviceResponse> changeStatus(@PathVariable Long id, @RequestBody @Valid ChangeStatusRequest request){

        DeviceResponse response = deviceService.changeStatus(id, request);

        return ResponseEntity.ok(response);
    }
}
