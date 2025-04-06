package com.oteller.example.otel.mapper;

import com.oteller.example.otel.entities.HotelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

import com.oteller.example.otel.payload.dto.HotelDto;

@Mapper(config = BaseMapperConfig.class)
public abstract class HotelMapper {
    public static final HotelMapper INSTANCE= Mappers.getMapper(HotelMapper.class);
    public abstract HotelEntity mapToEntity(HotelDto hotelDto);
    public abstract List<HotelEntity> mapToEntitys(List<HotelDto> hotelDtos);
    public abstract HotelDto mapToDto(HotelEntity hotelEntity);
    public abstract List<HotelDto> mapToDtos(List<HotelEntity> hotelEntitys);
}
