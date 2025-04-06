package com.oteller.example.service.reservation.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "RESERVATION")
@Data
public class ReservationEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Long hotelId;
    private Long roomId;
    private String guestName;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;
    private LocalDateTime createdAt;
}
