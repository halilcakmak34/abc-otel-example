package com.oteller.example.service.reservation.feign.otelservice.model.payload.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
public class HotelDto implements Serializable {
    private String id;
    @NotNull(message = "Name is required")
    private String name;
    @NotNull(message = "Address is required")
    private String address;
    private Integer starRating;

}
