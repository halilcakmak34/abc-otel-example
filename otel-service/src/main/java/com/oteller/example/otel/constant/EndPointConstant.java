package com.oteller.example.otel.constant;

import org.springframework.stereotype.Component;

@Component
public class EndPointConstant {
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

}
