package com.endava.emanuel_luhan.smart_home_controller.dto;

import com.endava.emanuel_luhan.smart_home_controller.model.DeviceType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class DeviceCreateRequest {

    @NotBlank(message = "Name is required")
    @Size(max = 50)
    private String name;

    @NotBlank(message = "Status is required")
    @Size(max = 20)
    private String status;

    @NotNull(message = "Type is required")
    private DeviceType type;
}
