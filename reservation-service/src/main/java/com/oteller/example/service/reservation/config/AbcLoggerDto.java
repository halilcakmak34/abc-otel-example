package com.oteller.example.service.reservation.config;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class AbcLoggerDto implements Serializable {
    private String microServiceName = "reservation-service";
    private String message;
    private String level;
}
