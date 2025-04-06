package com.oteller.example.otel.mapper;

import com.oteller.example.otel.entities.RoomEntity;
import com.oteller.example.otel.payload.dto.RoomDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.List;

@Mapper(config = BaseMapperConfig.class)
public abstract class RoomMapper {

    public static final RoomMapper INSTANCE= Mappers.getMapper(RoomMapper.class);

    @Mapping(source = "price",target = "pricePerNight", qualifiedByName = "doubleToBigDecimal")
    public abstract RoomEntity mapToEntity(RoomDto roomDto);
    public abstract List<RoomEntity> mapToEntitys(List<RoomDto> roomDto);
    @Mapping(source = "pricePerNight",target = "price",qualifiedByName = "bigDecimalToDouble")
    public abstract RoomDto mapToDto(RoomEntity roomEntity);
    public abstract List<RoomDto> mapToDtos(List<RoomEntity> roomEntity);

    @Named("bigDecimalToDouble")
    Double bigDecimalToDouble(BigDecimal pricePerNight){
        return pricePerNight.doubleValue();
    }

    @Named("doubleToBigDecimal")
    BigDecimal doubleToBigDecimal(Double price){
        return BigDecimal.valueOf(price);
    }
}
