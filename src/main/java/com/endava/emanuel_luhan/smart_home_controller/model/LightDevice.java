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
@DiscriminatorValue("LIGHT")
public class LightDevice extends Device{

    @Column
    private Integer brightness = 0;

    public LightDevice(String name, String status, int brightness){
        super(name, status);
        this.brightness = brightness;
    }
}
