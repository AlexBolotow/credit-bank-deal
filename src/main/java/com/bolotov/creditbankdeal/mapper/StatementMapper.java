package com.bolotov.creditbankdeal.mapper;

import com.bolotov.creditbankdeal.dto.StatementDto;
import com.bolotov.creditbankdeal.entity.Statement;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StatementMapper {

    StatementMapper INSTANCE = Mappers.getMapper(StatementMapper.class);

    StatementDto toDto(Statement entity);

    Statement toEntity(StatementDto dto);
}
