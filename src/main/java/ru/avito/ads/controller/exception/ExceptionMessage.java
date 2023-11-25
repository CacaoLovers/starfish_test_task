package ru.avito.ads.controller.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionMessage {
    private String message;
    private Integer code;
}
