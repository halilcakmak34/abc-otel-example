package com.oteller.example.log.payload.request;

import com.oteller.example.log.payload.dto.AbcLoggerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogRequest {
    private AbcLoggerDto abcLoggerDto;
}
