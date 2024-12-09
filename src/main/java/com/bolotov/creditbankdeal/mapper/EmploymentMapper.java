package com.bolotov.creditbankdeal.mapper;

import com.bolotov.creditbankdeal.dto.EmploymentDto;
import com.bolotov.creditbankdeal.entity.Employment;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface EmploymentMapper {

    EmploymentDto toDto(Employment entity);

    Employment toEntity(EmploymentDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(@MappingTarget Employment entity, EmploymentDto dto);
}
