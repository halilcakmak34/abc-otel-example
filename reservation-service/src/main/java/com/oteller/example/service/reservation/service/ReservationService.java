package com.oteller.example.service.reservation.service;

import com.oteller.example.service.reservation.config.AbcLoggerDto;
import com.oteller.example.service.reservation.enm.OperationType;
import com.oteller.example.service.reservation.enm.ReservationState;
import com.oteller.example.service.reservation.entities.ReservationEntity;
import com.oteller.example.service.reservation.exception.NotAvailableRoomException;
import com.oteller.example.service.reservation.feign.otelservice.OtelServiceFeignClient;
import com.oteller.example.service.reservation.mapper.ReservationMapper;
import com.oteller.example.service.reservation.payload.dto.ReservationDto;
import com.oteller.example.service.reservation.payload.request.ReservationRequest;
import com.oteller.example.service.reservation.repository.ReservationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.time.LocalDateTime;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Autowired
    private OtelServiceFeignClient otelServiceFeignClient;


    @Transactional
    public boolean actionReservation(ReservationDto dto, OperationType operationType) throws NotAvailableRoomException, Exception {

        if(operationType.equals(OperationType.CHECK_IN)) {

            if(otelServiceFeignClient.isAvailableRoom(dto.getHotelId(),String.valueOf(dto.getRoomId()),dto.getPersonCount())) {
                otelServiceFeignClient.reservationRoom(dto.getHotelId(),String.valueOf(dto.getRoomId()));
                ReservationEntity reservationEntity = ReservationMapper.INSTANCE.mapToEntity(dto);
                reservationEntity.setCreatedAt(LocalDateTime.now());
                reservationEntity.setCheckInDate(LocalDateTime.now());
                reservationEntity.setStatus(ReservationState.RESERVED);
                reservationRepository.save(reservationEntity);
                kafkaProducerService.sendAbcLogger(AbcLoggerDto.builder().message("operation : checkIn hotelId : "+dto.getHotelId()+", roomId: "+dto.getRoomId()).build());
                return true;
            }

            kafkaProducerService.sendAbcLogger(AbcLoggerDto.builder().level("ERROR").message("Talep edilen yer uygun degil").build());

            throw new NotAvailableRoomException("Talep edilen yer uygun degil");

        }else if(operationType.equals(OperationType.CHECK_OUT)) {
            ReservationEntity reservationEntity = ReservationMapper.INSTANCE.mapToEntity(dto);

            if(reservationRepository.findById(dto.getId()).isPresent()){
                otelServiceFeignClient.cancelReservationRoom(dto.getHotelId(),String.valueOf(dto.getRoomId()));
                reservationEntity.setCheckOutDate(LocalDateTime.now());
                reservationEntity.setStatus(ReservationState.CANCEL);
                reservationEntity.setUpdatedAt(LocalDateTime.now());
                reservationRepository.save(reservationEntity);
                kafkaProducerService.sendAbcLogger(AbcLoggerDto.builder().level("INFO").message("operation : checkOut hotelId : "+dto.getHotelId()+", roomId: "+dto.getRoomId()).build());
                return true;
            }

            kafkaProducerService.sendAbcLogger(AbcLoggerDto.builder().level("ERROR").message("Reservation not found").build());
            throw new Exception("Reservation not found");

        }else{
            kafkaProducerService.sendAbcLogger(AbcLoggerDto.builder().level("ERROR").message("Operation not found").build());
            throw new Exception("Operation not found");
        }

    }
}
