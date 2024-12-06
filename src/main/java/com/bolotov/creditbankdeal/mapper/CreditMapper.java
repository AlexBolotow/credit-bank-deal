package com.bolotov.creditbankdeal.mapper;

import com.bolotov.creditbankdeal.dto.CreditDto;
import com.bolotov.creditbankdeal.entity.Credit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CreditMapper {

    CreditMapper INSTANCE = Mappers.getMapper(CreditMapper.class);

    CreditDto toDto(Credit entity);

    Credit toEntity(CreditDto dto);
}
