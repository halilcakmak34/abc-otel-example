package com.oteller.example.otel.confıg;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class AbcLoggerDto implements Serializable {
    private String microServiceName = "otel-service";
    private String message;
    private String level;
}
