package com.endava.emanuel_luhan.smart_home_controller.controller;

import com.endava.emanuel_luhan.smart_home_controller.dto.DeviceEventLogResponse;
import com.endava.emanuel_luhan.smart_home_controller.mapper.DeviceEventLogMapper;
import com.endava.emanuel_luhan.smart_home_controller.service.DeviceLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
public class LogController {

    private final DeviceLogService deviceLogService;

    @GetMapping("/devices/{deviceId}/logs")
    public ResponseEntity<List<DeviceEventLogResponse>> getLogsForDevice(@PathVariable Long deviceId){
        log.info("Fetching logs for device with id={}", deviceId);

        List<DeviceEventLogResponse> responses = deviceLogService.getLogsForDevice(deviceId)
                .stream()
                .map(DeviceEventLogMapper::toResponse)
                .toList();

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/logs")
    public ResponseEntity<List<DeviceEventLogResponse>> getAllLogs() {
        log.info("Fetching all device logs");

        List<DeviceEventLogResponse> responses = deviceLogService.getAllLogs()
                .stream()
                .map(DeviceEventLogMapper::toResponse)
                .toList();

        return ResponseEntity.ok(responses);
    }

}
