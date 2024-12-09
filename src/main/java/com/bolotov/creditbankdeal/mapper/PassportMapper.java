package com.bolotov.creditbankdeal.mapper;

import com.bolotov.creditbankdeal.dto.PassportDto;
import com.bolotov.creditbankdeal.entity.Passport;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface PassportMapper {

    PassportDto toDto(Passport entity);

    Passport toEntity(PassportDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(@MappingTarget Passport entity, PassportDto dto);
}
