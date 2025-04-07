package com.oteller.example.log.payload.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class AbcLoggerDto implements Serializable {
    private String microServiceName = "log-service";
    private String message;
    private String level;
}
