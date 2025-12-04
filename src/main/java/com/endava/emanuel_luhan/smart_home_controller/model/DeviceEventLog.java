package com.endava.emanuel_luhan.smart_home_controller.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "device_event_logs")
@Getter
@Setter
@NoArgsConstructor
public class DeviceEventLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long deviceId;

    @Column(nullable = false, length = 50)
    private String deviceName;

    @Column(length = 20)
    private String oldStatus;

    @Column(length = 20)
    private String newStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LogAction action;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    public DeviceEventLog(Long deviceId,
                          String deviceName,
                          String oldStatus,
                          String newStatus,
                          LogAction action,
                          LocalDateTime timestamp) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
        this.action = action;
        this.timestamp = timestamp;
    }
}
