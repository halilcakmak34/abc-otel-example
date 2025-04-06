package com.oteller.example.otel.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "Room")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomEntity extends  BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "HOTEL_ID",referencedColumnName = "id")
    private HotelEntity hotelEntity;

    @Column(name = "ROOM_NUMBER")
    private String roomNumber;

    @Column(name = "CAPACITY")
    private Integer capacity;

    @Column(name = "PRICE_PER_NIGHT")
    private BigDecimal pricePerNight;

    @Column(name = "AVAILABLE")
    private Boolean available;
}
