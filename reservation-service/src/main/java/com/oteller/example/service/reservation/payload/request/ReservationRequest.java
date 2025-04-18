package com.oteller.example.service.reservation.payload.request;

import com.oteller.example.service.reservation.enm.OperationType;
import com.oteller.example.service.reservation.payload.dto.ReservationDto;
import lombok.Data;

@Data
public class ReservationRequest {
    private ReservationDto reservationDto;
    private OperationType operation;
}
