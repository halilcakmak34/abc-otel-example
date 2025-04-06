package com.oteller.example.otel.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "Hotel")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelEntity extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "STAR_RATING")
    private Integer starRating;

    @OneToMany(mappedBy = "hotelEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RoomEntity> roomEntityList;
}
