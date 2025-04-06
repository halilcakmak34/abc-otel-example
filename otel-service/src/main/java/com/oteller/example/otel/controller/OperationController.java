package com.oteller.example.otel.controller;

import com.oteller.example.otel.constant.EndPointConstant;
import com.oteller.example.otel.exception.UpdateHotelNotExistException;
import com.oteller.example.otel.exception.UpdateRoomNotExistException;
import com.oteller.example.otel.payload.response.BaseResponse;
import com.oteller.example.otel.payload.request.OperationRequest;
import com.oteller.example.otel.service.HelpService;
import com.oteller.example.otel.service.OperationService;
import com.oteller.example.otel.payload.response.OperationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value= EndPointConstant.OPERATION_PREFIX,produces={MediaType.APPLICATION_JSON_VALUE})
public class OperationController {

    @Autowired
    private OperationService operationService;

    @Autowired
    private HelpService helpService;


    @PostMapping(value = EndPointConstant.HOTEL_PREFIX + EndPointConstant.UPDATE, produces={MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ResponseEntity<OperationResponse> updateHotel(@RequestBody OperationRequest request) throws UpdateHotelNotExistException {
        OperationResponse response = new OperationResponse();

        operationService.updateHotel(request.getHotelDto());

        helpService.addOperationMsgForSuccess(response);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = EndPointConstant.HOTEL_PREFIX+EndPointConstant.ADD, produces={MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ResponseEntity<OperationResponse> addHotel(@RequestBody  OperationRequest request) {

        OperationResponse response = new OperationResponse();

        operationService.createHotel(request.getHotelDto());
        helpService.addOperationMsgForSuccess(response);

        return ResponseEntity.ok(response);
    }

    @PostMapping(value = EndPointConstant.ACTION_HOTEL, produces={MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ResponseEntity<OperationResponse> addHotels(@RequestBody  OperationRequest request) {
        OperationResponse response = new OperationResponse();
        request.getHotelDtoList().forEach(hotelDto -> {
            operationService.createHotel(hotelDto);
        });
        helpService.addOperationMsgForSuccess(response);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = EndPointConstant.ROOM_PREFIX + EndPointConstant.ADD, produces={MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ResponseEntity<OperationResponse> addRoom(@RequestBody  OperationRequest request) {

        OperationResponse response = new OperationResponse();

        operationService.createRoom(request.getRoomDto());

        helpService.addOperationMsgForSuccess(response);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = EndPointConstant.ROOM_PREFIX + EndPointConstant.UPDATE, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<OperationResponse> updateRoom(@RequestBody  OperationRequest request) throws UpdateRoomNotExistException {
        OperationResponse response = new OperationResponse();

        operationService.updateRoom(request.getRoomDto());

        helpService.addOperationMsgForSuccess(response);

        return ResponseEntity.ok(response);
    }

    @PostMapping(value =  EndPointConstant.ACTION_ROOM, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<OperationResponse> addRooms(@RequestBody  OperationRequest request) {

        OperationResponse response = new OperationResponse();

        request.getRoomDtoList().forEach(roomDto -> {
            operationService.createRoom(roomDto);
        });

        helpService.addOperationMsgForSuccess(response);
        return ResponseEntity.ok(response);
    }



}
