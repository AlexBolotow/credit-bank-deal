package com.bolotov.creditbankdeal.mapper;

import com.bolotov.creditbankdeal.dto.EmploymentDto;
import com.bolotov.creditbankdeal.entity.Employment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmploymentMapper {

    EmploymentMapper INSTANCE = Mappers.getMapper(EmploymentMapper.class);

    EmploymentDto toDto(Employment entity);

    Employment toEntity(EmploymentDto dto);
}
