package com.oteller.example.service.reservation.controller;

import com.oteller.example.service.reservation.constant.EndPointConstant;
import com.oteller.example.service.reservation.payload.request.ReservationRequest;
import com.oteller.example.service.reservation.payload.response.ReservationResponse;
import com.oteller.example.service.reservation.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value= EndPointConstant.RESERVATION_PREFIX,produces={MediaType.APPLICATION_JSON_VALUE})
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping(value = EndPointConstant.ACTION_RESERVATION, produces={MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ResponseEntity<ReservationResponse> actionReservation(@RequestBody ReservationRequest request){
        ReservationResponse response = new ReservationResponse();
        reservationService.actionReservation(request.getReservationDto());
        return ResponseEntity.ok(response);
    }

}
