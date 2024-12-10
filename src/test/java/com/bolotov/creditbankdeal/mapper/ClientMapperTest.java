package com.bolotov.creditbankdeal.mapper;

import com.bolotov.creditbankdeal.dto.ClientDto;
import com.bolotov.creditbankdeal.dto.FinishRegistrationRequestDto;
import com.bolotov.creditbankdeal.dto.LoanStatementRequestDto;
import com.bolotov.creditbankdeal.utils.DataUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientMapperTest {

    @Autowired
    ClientMapper clientMapperUnderTest;

    @Test
    @DisplayName("Test loan statement request mapping to clientDto functionality")
    void givenLoanStatementRequestDto_whenToDto_ReturnCorrectClientDto() {
        // given
        LoanStatementRequestDto requestDto = DataUtils.getLoanStatementRequestDtoJohnDoe();

        // when
        ClientDto clientDto = clientMapperUnderTest.LoanStatementRequestDtoToClientDto(requestDto);

        // then
        assertNotNull(clientDto);
        assertEquals(requestDto.getLastName(), clientDto.getLastName());
        assertEquals(requestDto.getFirstName(), clientDto.getFirstName());
        assertEquals(requestDto.getMiddleName(), clientDto.getMiddleName());
        assertEquals(requestDto.getEmail(), clientDto.getEmail());
        assertEquals(requestDto.getBirthdate(), clientDto.getBirthdate());
        assertEquals(requestDto.getPassportSeries(), clientDto.getPassport().getSeries());
        assertEquals(requestDto.getPassportNumber(), clientDto.getPassport().getNumber());
    }

    @Test
    @DisplayName("Test finish registration request mapping to clientDto functionality")
    void givenFinishRegistrationRequestDto_whenToDto_ReturnCorrectClientDto() {
        // given
        FinishRegistrationRequestDto requestDto = DataUtils.getFinishRegistrationRequestDto();

        // when
        ClientDto clientDto = clientMapperUnderTest.FinishRegistrationRequestDtoToClientDto(requestDto);
        clientDto.setId(UUID.randomUUID());
        clientDto.setEmail("uuuasdj@gmail.com");

        // then
        assertNotNull(clientDto);
        assertEquals(requestDto.getGender(), clientDto.getGender());
        assertEquals(requestDto.getMaritalStatus(), clientDto.getMaritalStatus());
        assertEquals(requestDto.getDependentAmount(), clientDto.getDependentAmount());
        assertEquals(requestDto.getPassportIssueDate(), clientDto.getPassport().getIssueDate());
        assertEquals(requestDto.getPassportIssueBranch(), clientDto.getPassport().getIssueBranch());
        assertEquals(requestDto.getEmployment(), clientDto.getEmployment());
        assertEquals(requestDto.getAccountNumber(), clientDto.getAccountNumber());
        System.out.println(clientDto);
    }
}