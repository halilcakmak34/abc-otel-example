package com.oteller.example.otel.service;

import com.oteller.example.otel.entities.HotelEntity;
import com.oteller.example.otel.exception.UpdateHotelNotExistException;
import com.oteller.example.otel.exception.UpdateRoomNotExistException;
import com.oteller.example.otel.mapper.HotelMapper;
import com.oteller.example.otel.payload.dto.HotelDto;
import com.oteller.example.otel.payload.dto.RoomDto;
import com.oteller.example.otel.repository.HotelRepository;
import com.oteller.example.otel.entities.RoomEntity;
import com.oteller.example.otel.mapper.RoomMapper;
import com.oteller.example.otel.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
public class OperationService {
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    public OperationService(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }

    public boolean createHotel(HotelDto hotelDto){
        HotelEntity hotelEntity = HotelMapper.INSTANCE.mapToEntity(hotelDto);
        hotelEntity.setCreatedAt(LocalDateTime.now());
        hotelRepository.save(hotelEntity);
        log.info("Hotel created successfully. info : "+hotelEntity.toString());
        return true;
    }

    public boolean updateHotel(HotelDto hotelDto) throws UpdateHotelNotExistException {

        HotelEntity hotelEntity = HotelMapper.INSTANCE.mapToEntity(hotelDto);

        Optional<HotelEntity> hotelEntityOptional = hotelRepository.findById(hotelEntity.getId());

        if(hotelEntityOptional.isPresent()){
            throw new UpdateHotelNotExistException("00001","Update edilecek hotel kayitli degil");
        }

        hotelEntity.setUpdatedAt(LocalDateTime.now());
        hotelRepository.save(hotelEntity);
        log.info("Hotel updated successfully. info : "+hotelEntity.toString());
        return true;
    }

    public boolean createRoom(RoomDto roomDto){
        RoomEntity roomEntity = RoomMapper.INSTANCE.mapToEntity(roomDto);
        roomRepository.save(roomEntity);
        log.info("Room create successfully. info : "+roomEntity.toString());
        return true;
    }

    public boolean updateRoom(RoomDto roomDto) throws UpdateRoomNotExistException {

        RoomEntity roomEntity = RoomMapper.INSTANCE.mapToEntity(roomDto);

        Optional<RoomEntity> roomEntityOptional = roomRepository.findById(roomEntity.getId());

        if(roomEntityOptional.isPresent()){
            throw new UpdateRoomNotExistException("00001","Update edilecek room kayitli degil");
        }

        roomEntity.setUpdatedAt(LocalDateTime.now());
        roomRepository.save(roomEntity);
        log.info("Room Updated successfully. info : "+roomEntity.toString());
        return true;
    }

}
