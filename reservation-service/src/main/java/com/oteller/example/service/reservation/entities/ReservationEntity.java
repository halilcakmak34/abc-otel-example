package com.oteller.example.service.reservation.entities;

import com.oteller.example.service.reservation.enm.ReservationState;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "RESERVATION")
@Data
public class ReservationEntity {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "HOTEL_ID")
    private Long hotelId;
    @Column(name = "ROOM_ID")
    private Long roomId;
    @Column(name = "GUEST_NAME")
    private String guestName;
    @Column(name = "PERSON_COUNT")
    private Integer personCount;
    @Enumerated(EnumType.STRING)
    private ReservationState status;
    @Column(name = "CHECK_IN_DATE")
    private LocalDateTime checkInDate;
    @Column(name = "CHECK_OUT_DATE")
    private LocalDateTime checkOutDate;
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;
    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;
}
