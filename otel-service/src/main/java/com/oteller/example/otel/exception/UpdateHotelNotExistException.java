package com.oteller.example.otel.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateHotelNotExistException extends Throwable{
    private static final long serialVersionUID = 1L;

    private String code;
    private String msg;
    private Object[] msgList;
    public UpdateHotelNotExistException(String code, String ... msgList){
        super();
        this.code = code;
        this.msg = msgList[0];
        this.msgList = msgList;
    }
}
