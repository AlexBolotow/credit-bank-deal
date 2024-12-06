package com.bolotov.creditbankdeal.mapper;

import com.bolotov.creditbankdeal.dto.ClientDto;
import com.bolotov.creditbankdeal.dto.LoanStatementRequestDto;
import com.bolotov.creditbankdeal.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "middleName", target = "middleName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "birthdate", target = "birthdate")
    @Mapping(source = "passportSeries", target = "passport.series")
    @Mapping(source = "passportNumber", target = "passport.number")
    ClientDto toDto(LoanStatementRequestDto requestDto);

    ClientDto toDto(Client entity);

    Client toEntity(ClientDto dto);
}
