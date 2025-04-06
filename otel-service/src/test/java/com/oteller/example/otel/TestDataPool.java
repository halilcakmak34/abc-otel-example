package com.oteller.example.otel;

import com.oteller.example.otel.entities.HotelEntity;
import com.oteller.example.otel.payload.dto.HotelDto;
import com.oteller.example.otel.payload.dto.RoomDto;
import com.oteller.example.otel.payload.request.OperationRequest;

public class TestDataPool {

    public static OperationRequest createOperationRequest() {
        OperationRequest request = new OperationRequest();
        request.setHotelDto(createHotelDto());
        request.setRoomDto(createRoomDto());
        return request;
    }

    public static HotelDto createHotelDto() {
        HotelDto hotelDto = new HotelDto();
        hotelDto.setName("testHotel");
        hotelDto.setAddress("testAddress");
        return hotelDto;
    }

    public static HotelEntity createHotelEntity() {
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setName("testHotel");
        hotelEntity.setAddress("testAddress");
        return hotelEntity;
    }

    public static RoomDto createRoomDto(){
        RoomDto roomDto = new RoomDto();
        roomDto.setHotelId("1");
        roomDto.setRoomNumber("1234");
        return roomDto;
    }

}
