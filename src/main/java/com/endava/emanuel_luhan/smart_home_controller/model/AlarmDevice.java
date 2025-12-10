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
@DiscriminatorValue("ALARM")
public class AlarmDevice extends Device{

    @Column
    private Boolean armed = false;

    public AlarmDevice(String name, String status, boolean armed){
        super(name, status);
        this.armed = armed;
    }
}
