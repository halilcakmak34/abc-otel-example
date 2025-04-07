package com.oteller.example.service.reservation.feign.otelservice.model.payload.request;


import com.oteller.example.service.reservation.feign.otelservice.model.payload.dto.HotelDto;
import com.oteller.example.service.reservation.feign.otelservice.model.payload.dto.RoomDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OperationRequest implements Serializable {

    private HotelDto hotelDto;
    private RoomDto roomDto;
    private List<HotelDto> hotelDtoList;
    private List<RoomDto> roomDtoList;

}
