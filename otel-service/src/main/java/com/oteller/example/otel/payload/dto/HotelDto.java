package com.oteller.example.otel.payload.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

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
