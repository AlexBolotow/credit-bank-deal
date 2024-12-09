package com.bolotov.creditbankdeal.mapper;

import com.bolotov.creditbankdeal.dto.ScoringDataDto;
import com.bolotov.creditbankdeal.dto.StatementDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScoringDataMapper {

    ScoringDataMapper INSTANCE = Mappers.getMapper(ScoringDataMapper.class);

    @Mapping(source = "appliedOffer.requestedAmount", target = "amount")
    @Mapping(source = "appliedOffer.term", target = "term")
    @Mapping(source = "client.firstName", target = "firstName")
    @Mapping(source = "client.lastName", target = "lastName")
    @Mapping(source = "client.middleName", target = "middleName")
    @Mapping(source = "client.gender", target = "gender")
    @Mapping(source = "client.birthdate", target = "birthdate")
    @Mapping(source = "client.passport.series", target = "passportSeries")
    @Mapping(source = "client.passport.number", target = "passportNumber")
    @Mapping(source = "client.passport.issueDate", target = "passportIssueDate")
    @Mapping(source = "client.passport.issueBranch", target = "passportIssueBranch")
    @Mapping(source = "client.maritalStatus", target = "maritalStatus")
    @Mapping(source = "client.dependentAmount", target = "dependentAmount")
    @Mapping(source = "client.employment", target = "employment")
    @Mapping(source = "client.accountNumber", target = "accountNumber")
    @Mapping(source = "appliedOffer.isInsuranceEnabled", target = "isInsuranceEnabled")
    @Mapping(source = "appliedOffer.isSalaryClient", target = "isSalaryClient")
    ScoringDataDto StatementDtoToScoringDataDto(StatementDto clientDto);
}
