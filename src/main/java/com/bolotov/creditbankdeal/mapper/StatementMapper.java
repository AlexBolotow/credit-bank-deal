package com.bolotov.creditbankdeal.mapper;

import com.bolotov.creditbankdeal.dto.StatementDto;
import com.bolotov.creditbankdeal.entity.Statement;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface StatementMapper {
    StatementDto toDto(Statement entity);

    Statement toEntity(StatementDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(@MappingTarget Statement entity, StatementDto dto);
}
