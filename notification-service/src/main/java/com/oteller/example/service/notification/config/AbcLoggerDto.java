package com.oteller.example.service.notification.config;

import java.io.Serializable;
import lombok.Data;

@Data
public class AbcLoggerDto implements Serializable {
    private String microServiceName;
    private String message;
}
