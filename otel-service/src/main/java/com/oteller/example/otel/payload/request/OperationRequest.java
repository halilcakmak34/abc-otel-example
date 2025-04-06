package com.oteller.example.otel.payload.request;

import com.oteller.example.otel.payload.dto.HotelDto;
import com.oteller.example.otel.payload.dto.RoomDto;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
public class OperationRequest implements Serializable {

    private HotelDto hotelDto;
    private RoomDto roomDto;
    private List<HotelDto> hotelDtoList;
    private List<RoomDto> roomDtoList;

}
