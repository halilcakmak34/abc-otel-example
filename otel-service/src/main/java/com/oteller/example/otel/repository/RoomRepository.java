package com.oteller.example.otel.repository;

import com.oteller.example.otel.entities.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
    List<RoomEntity> findByCapacityGreaterThanEqualAndAvailableIsTrue(Integer capacity);
    Optional<RoomEntity> findByHotelEntity_idAndRoomNumber(Long hotelId, String roomNumber);
    Optional<RoomEntity> findByRoomNumberAndCapacityGreaterThanEqualAndAvailableIsTrueAndHotelEntity_id(String roomNumber,Integer personCount,Long hotelId);
}
