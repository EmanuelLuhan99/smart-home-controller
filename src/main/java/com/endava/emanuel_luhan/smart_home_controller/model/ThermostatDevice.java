package com.endava.emanuel_luhan.smart_home_controller.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("THERMOSTAT")
public class ThermostatDevice extends Device{

    @Column
    private Double targetTemperature;

    public ThermostatDevice(String name, String status, double targetTemperature){
        super(name, status);
        this.targetTemperature = targetTemperature;
    }
}
