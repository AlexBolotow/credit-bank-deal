package com.bolotov.creditbankdeal.mapper;

import com.bolotov.creditbankdeal.dto.ClientDto;
import com.bolotov.creditbankdeal.dto.LoanStatementRequestDto;
import com.bolotov.creditbankdeal.utils.DataUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

class ClientMapperTest {

    @Test
    @DisplayName("Test loan statement request mapping to client functionality")
    void givenLoanStatementRequestDto_whenToDto_ReturnCorrectClientDto() {
        // given
        LoanStatementRequestDto requestDto = DataUtils.getLoanStatementRequestDtoJohnDoe();

        // when
        ClientDto clientDto = ClientMapper.INSTANCE.toDto(requestDto);

        // then
        assertEquals(requestDto.getLastName(), clientDto.getLastName());
        assertEquals(requestDto.getFirstName(), clientDto.getFirstName());
        assertEquals(requestDto.getMiddleName(), clientDto.getMiddleName());
        assertEquals(requestDto.getEmail(), clientDto.getEmail());
        assertEquals(requestDto.getBirthdate(), clientDto.getBirthdate());
        assertEquals(requestDto.getPassportSeries(), clientDto.getPassport().getSeries());
        assertEquals(requestDto.getPassportNumber(), clientDto.getPassport().getNumber());
    }
}