package com.oteller.example.otel.payload.dto;

import com.oteller.example.otel.payload.enm.RoomType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
public class RoomDto implements Serializable {
    private String id;
    @NotNull(message = "HotelId is required")
    private String hotelId;
    @NotNull(message = "RoomNumber is required")
    private String roomNumber;
    private Integer capacity;
    @NotNull(message = "RoomType is required")
    private RoomType roomType;
    private Double price;
    private Boolean available;
}
