package com.oteller.example.otel.payload.response;


import com.oteller.example.otel.model.dto.Msg;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.oteller.example.otel.model.enm.StatusType;

@Data
public class BaseResponse implements Serializable {
    private StatusType statusType;
    private List<Msg> operationMsgList = new ArrayList<>();
}
