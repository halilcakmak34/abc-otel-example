package com.oteller.example.otel.payload.dto;

import com.oteller.example.otel.payload.enm.MsgType;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Msg {
    private String msg;
    private String detail;
    private MsgType msgType;
    private Throwable throwable;
}
