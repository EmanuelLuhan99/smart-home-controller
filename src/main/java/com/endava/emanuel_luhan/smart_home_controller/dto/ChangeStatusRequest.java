package com.endava.emanuel_luhan.smart_home_controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChangeStatusRequest {

    @NotBlank(message = "You have to specify a status!!!")
    private String status;
}
