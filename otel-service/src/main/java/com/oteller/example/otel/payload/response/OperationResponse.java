package com.oteller.example.otel.payload.response;

import com.oteller.example.otel.payload.dto.RoomDto;
import com.oteller.example.otel.payload.dto.HotelDto;
import lombok.*;

import java.util.List;


@Data
public class OperationResponse extends BaseResponse {
    private List<HotelDto> hotelDtoList;
    private List<RoomDto> roomDtoList;
}
