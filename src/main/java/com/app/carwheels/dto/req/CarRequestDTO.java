package com.app.carwheels.dto.req;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CarRequestDTO {
  @NotBlank(message = "Name is required")
  private String name;

  @NotNull(message = "Wheels is required")
  @Min(value = 1, message = "Need to be at least 1")
  private Long wheels;
}
