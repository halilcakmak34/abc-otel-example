package com.oteller.example.service.reservation.payload.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
public class ReservationDto implements Serializable {
    private Long id;
    @NotNull(message = "Hotel ID cannot be null")
    private Long hotelId;
    @NotNull(message = "Room ID cannot be null")
    private Long roomId;
    @NotNull(message = "Guest ID cannot be null")
    private String guestName;
}
