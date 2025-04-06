package com.oteller.example.service.reservation.mapper;


import com.oteller.example.service.reservation.entities.ReservationEntity;
import com.oteller.example.service.reservation.payload.dto.ReservationDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(config = BaseMapperConfig.class)
public abstract class ReservationMapper {

    public static final ReservationMapper INSTANCE= Mappers.getMapper(ReservationMapper.class);
    public abstract ReservationEntity mapToEntity(ReservationDto roomDto);
    public abstract List<ReservationEntity> mapToEntitys(List<ReservationDto> roomDto);
    public abstract ReservationDto mapToDto(ReservationEntity roomEntity);
    public abstract List<ReservationDto> mapToDtos(List<ReservationEntity> roomEntity);


}
