package com.oteller.example.service.reservation.feign.otelservice;

import com.oteller.example.service.reservation.constant.EndPointConstantOtelService;
import com.oteller.example.service.reservation.feign.otelservice.model.payload.response.OperationResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="otel-service")
public interface OtelServiceFeignClient {

    @PostMapping(EndPointConstantOtelService.GET_OTEL_INFORMATION)
    OperationResponse getOtelInformation();

    @PostMapping(EndPointConstantOtelService.RESERVATION_ROOM)
    Boolean reservationRoom(@RequestParam Long hotelId, @RequestParam String roomNumber);

    @PostMapping(EndPointConstantOtelService.CANCEL_RESERVATION_ROOM)
    Boolean cancelReservationRoom(@RequestParam Long hotelId, @RequestParam String roomNumber);

    @PostMapping(EndPointConstantOtelService.GET_AVAILABLE_ROOM_LIST)
    OperationResponse getAvailableRoomList(@RequestParam Integer personCount);

    @PostMapping(EndPointConstantOtelService.IS_AVAILABLE_ROOM)
    Boolean isAvailableRoom(@RequestParam Long hotelId, @RequestParam String roomNumber, @RequestParam Integer personCount);

}
