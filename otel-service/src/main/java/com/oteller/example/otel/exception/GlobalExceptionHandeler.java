package com.oteller.example.otel.exception;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandeler {

    private final MessageSource messageSource;

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandeler.class);

    public GlobalExceptionHandeler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(value = UpdateHotelNotExistException.class)
    public ResponseEntity<Object> handleUpdateHotelNotExistException(UpdateHotelNotExistException exception) {
        String code = exception.getCode();
        Object[] args = exception.getMsgList();
        String msg = "Update Hotel islemleri sirasinda hata alindi.";
        log.error(msg, exception);
        String messageResult = this.messageSource.getMessage(code,args.length==0 ? null:args, Locale.ENGLISH);
        return new ResponseEntity<>(this.messageSource.getMessage(messageResult,new Object[]{code,msg},Locale.ENGLISH), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UpdateRoomNotExistException.class)
    public ResponseEntity<Object> handleUpdateRoomNotExistException(UpdateRoomNotExistException exception) {
        String code = exception.getCode();
        Object[] args = exception.getMsgList();
        String msg = "Update Room islemleri sirasinda hata alindi.";
        log.error(msg, exception);
        String messageResult = this.messageSource.getMessage(code,args.length==0 ? null:args, Locale.ENGLISH);
        return new ResponseEntity<>(this.messageSource.getMessage(messageResult,new Object[]{code,msg},Locale.ENGLISH), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(
            Exception exception
    ) {
        logger.error("Beklenmeyen bir hata alindi...",exception);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }
}
