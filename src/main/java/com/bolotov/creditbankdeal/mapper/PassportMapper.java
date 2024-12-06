package com.bolotov.creditbankdeal.mapper;

import com.bolotov.creditbankdeal.dto.PassportDto;
import com.bolotov.creditbankdeal.entity.Passport;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PassportMapper {

    PassportMapper INSTANCE = Mappers.getMapper(PassportMapper.class);

    PassportDto toDto(Passport entity);

    Passport toEntity(PassportDto dto);
}
