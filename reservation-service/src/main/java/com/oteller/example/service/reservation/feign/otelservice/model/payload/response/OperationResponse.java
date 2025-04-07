package com.oteller.example.service.reservation.feign.otelservice.model.payload.response;

import com.oteller.example.service.reservation.feign.otelservice.model.payload.dto.HotelDto;
import com.oteller.example.service.reservation.feign.otelservice.model.payload.dto.RoomDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode
@Data
public class OperationResponse extends BaseResponse {
    private List<HotelDto> hotelDtoList;
    private List<RoomDto> roomDtoList;
}
