package com.oteller.example.service.reservation.service;

import com.oteller.example.service.reservation.enm.OperationType;
import com.oteller.example.service.reservation.entities.ReservationEntity;
import com.oteller.example.service.reservation.mapper.ReservationMapper;
import com.oteller.example.service.reservation.payload.dto.ReservationDto;
import com.oteller.example.service.reservation.payload.request.ReservationRequest;
import com.oteller.example.service.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public boolean actionReservation(ReservationDto dto, OperationType operationType) {
        if(operationType.equals(OperationType.CREATE)) {
            ReservationEntity reservationEntity = ReservationMapper.INSTANCE.mapToEntity(dto);
            reservationEntity.setCreatedAt(LocalDateTime.now());
            reservationEntity.setCheckInDate(LocalDateTime.now());
            reservationRepository.save(reservationEntity);
        }
        return true;
    }
}
