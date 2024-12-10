package com.bolotov.creditbankdeal.mapper;

import com.bolotov.creditbankdeal.dto.CreditDto;
import com.bolotov.creditbankdeal.entity.Credit;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CreditMapper {

    CreditDto toDto(Credit entity);

    Credit toEntity(CreditDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(@MappingTarget Credit entity, CreditDto dto);
}
