package com.oteller.example.service.reservation.constant;

import org.springframework.stereotype.Component;

@Component
public class EndPointConstantOtelService {
    public static final String HOTEL_PREFIX = "/hotel";
    public static final String ROOM_PREFIX = "/room";
    public static final String ACTION_HOTEL = "/action-hotel";
    public static final String ACTION_ROOM = "/action-room";
    public static final String OPERATION_PREFIX = "/operation";
    public static final String ADD = "/add";

    public static final String UPDATE = "/update";
    public static final String DELETE_BY_ID = "/delete/{deleteId}";
    public static final String DELETE = "/delete";
    public static final String GET = "/get";

    public static final String GET_OTEL_INFORMATION = "/get-otel-information";
    public static final String IS_AVAILABLE_ROOM = "/is-available-room";
    public static final String GET_AVAILABLE_ROOM_LIST = "/get-available-room-list";
    public static final String RESERVATION_ROOM = "/reservation-room";
    public static final String CANCEL_RESERVATION_ROOM = "/cancel-reservation-room";
}
