package com.oteller.example.service.reservation.feign.otelservice.model.payload.dto;

import com.oteller.example.service.reservation.feign.otelservice.model.payload.enm.MsgType;
import lombok.Data;

@Data
public class Msg {
    private String msg;
    private String detail;
    private MsgType msgType;
    private Throwable throwable;
}
