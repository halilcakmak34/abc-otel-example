package com.oteller.example.service.reservation.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class NotAvailableRoomException extends Throwable {
    private static final long serialVersionUID = 1L;

    private String code;
    private String msg;
    private Object[] msgList;
    public NotAvailableRoomException(String code, String ... msgList){
        super(msgList[0]);
        this.code = code;
        this.msg = msgList[0];
        this.msgList = msgList;
    }
}
