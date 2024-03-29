package com.app.carwheels.dto.res;

import lombok.Data;

@Data
public class ResponseMessage<T> {
  private String message;
  private T data;
}
