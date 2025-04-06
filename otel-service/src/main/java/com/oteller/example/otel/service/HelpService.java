package com.oteller.example.otel.service;

import com.oteller.example.otel.payload.response.BaseResponse;
import com.oteller.example.otel.model.dto.Msg;
import com.oteller.example.otel.model.enm.StatusType;
import com.oteller.example.otel.model.enm.MsgType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class HelpService {

    public void addOperationMsgForInfo(BaseResponse baseResponse, String msg) {
        baseResponse.setStatusType(StatusType.SUCCESS);
        baseResponse.setOperationMsgList(List.of(new Msg(msg,"", MsgType.SUCCESS,null)));
    }

    public void addOperationMsgForSuccess(BaseResponse baseResponse) {
        baseResponse.setStatusType(StatusType.SUCCESS);
        baseResponse.setOperationMsgList(List.of(new Msg("islem basariyla gerceklesmistir","", MsgType.SUCCESS,null)));
    }

    public static void addOperationMsgForError(BaseResponse baseResponse, Throwable throwable) {
        baseResponse.setStatusType(StatusType.FAILURE);
        baseResponse.setOperationMsgList(List.of(new Msg(throwable.getMessage(),throwable.getMessage(), MsgType.ERROR,throwable)));
    }
}
