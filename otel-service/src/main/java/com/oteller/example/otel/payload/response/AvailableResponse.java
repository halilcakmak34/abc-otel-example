package com.oteller.example.otel.payload.response;

import com.oteller.example.otel.payload.dto.RoomDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AvailableResponse implements Serializable {
    private List<RoomDto> roomDtoList;
}
