package com.oteller.example.service.reservation.feign.otelservice.model.payload.response;

import com.oteller.example.service.reservation.feign.otelservice.model.payload.dto.Msg;
import com.oteller.example.service.reservation.feign.otelservice.model.payload.enm.StatusType;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class BaseResponse implements Serializable {
    private StatusType statusType;
    private List<Msg> operationMsgList = new ArrayList<>();
}
