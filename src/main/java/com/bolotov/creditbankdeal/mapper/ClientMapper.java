package com.bolotov.creditbankdeal.mapper;

import com.bolotov.creditbankdeal.dto.FinishRegistrationRequestDto;
import com.bolotov.creditbankdeal.dto.LoanStatementRequestDto;
import com.bolotov.creditbankdeal.entity.Client;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "middleName", target = "middleName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "birthdate", target = "birthdate")
    @Mapping(source = "passportSeries", target = "passport.series")
    @Mapping(source = "passportNumber", target = "passport.number")
    com.bolotov.creditbankdeal.dto.ClientDto LoanStatementRequestDtoToClientDto(LoanStatementRequestDto requestDto);

    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "maritalStatus", target = "maritalStatus")
    @Mapping(source = "dependentAmount", target = "dependentAmount")
    @Mapping(source = "passportIssueDate", target = "passport.issueDate")
    @Mapping(source = "passportIssueBranch", target = "passport.issueBranch")
    @Mapping(source = "employment", target = "employment")
    @Mapping(source = "accountNumber", target = "accountNumber")
    com.bolotov.creditbankdeal.dto.ClientDto FinishRegistrationRequestDtoToClientDto(FinishRegistrationRequestDto finishRequestDtoRequest);

    com.bolotov.creditbankdeal.dto.ClientDto toDto(Client entity);

    Client toEntity(com.bolotov.creditbankdeal.dto.ClientDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(@MappingTarget Client entity, com.bolotov.creditbankdeal.dto.ClientDto dto);
}
