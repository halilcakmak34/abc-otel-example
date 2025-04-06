package com.oteller.example.otel.mapper;

import org.mapstruct.*;

@MapperConfig(uses={
},
nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
unmappedTargetPolicy = ReportingPolicy.WARN)
public interface BaseMapperConfig {
}
