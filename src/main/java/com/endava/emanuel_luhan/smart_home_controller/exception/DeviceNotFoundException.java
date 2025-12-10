package com.endava.emanuel_luhan.smart_home_controller.exception;

public class DeviceNotFoundException extends RuntimeException{

    public DeviceNotFoundException(Long id){
        super("Device not found with id: " + id);
    }
}
