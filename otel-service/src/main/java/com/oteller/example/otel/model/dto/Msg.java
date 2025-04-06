package com.oteller.example.otel.model.dto;

import com.oteller.example.otel.model.enm.MsgType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Msg {
    private String msg;
    private String detail;
    private MsgType msgType;
    private Throwable throwable;
}
