package com.bolotov.creditbankdeal.service.impl;

import com.bolotov.creditbankdeal.client.CalculatorClient;
import com.bolotov.creditbankdeal.dto.ClientDto;
import com.bolotov.creditbankdeal.dto.CreditDto;
import com.bolotov.creditbankdeal.dto.FinishRegistrationRequestDto;
import com.bolotov.creditbankdeal.dto.LoanOfferDto;
import com.bolotov.creditbankdeal.dto.LoanStatementRequestDto;
import com.bolotov.creditbankdeal.dto.ScoringDataDto;
import com.bolotov.creditbankdeal.dto.StatementDto;
import com.bolotov.creditbankdeal.entity.Statement;
import com.bolotov.creditbankdeal.enums.CreditStatus;
import com.bolotov.creditbankdeal.mapper.ClientMapper;
import com.bolotov.creditbankdeal.mapper.ScoringDataMapper;
import com.bolotov.creditbankdeal.mapper.StatementMapper;
import com.bolotov.creditbankdeal.service.ClientService;
import com.bolotov.creditbankdeal.service.DealService;
import com.bolotov.creditbankdeal.service.OfferService;
import com.bolotov.creditbankdeal.service.StatementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class DealServiceImpl implements DealService {

    private final StatementService statementService;

    private final CalculatorClient calculatorClient;

    private final OfferService offerService;

    private final ClientService clientService;

    private final ClientMapper clientMapper;

    private final StatementMapper statementMapper;

    @Override
    public List<LoanOfferDto> getOffers(LoanStatementRequestDto requestDto) {
        ClientDto clientDto = clientMapper.LoanStatementRequestDtoToClientDto(requestDto);

        StatementDto statementToCreate = new StatementDto();
        statementToCreate.setClient(clientDto);

        Statement createdStatement = statementService.createStatement(statementToCreate);

        List<LoanOfferDto> offers = calculatorClient.getOffers(requestDto);
        offerService.setStatementId(createdStatement.getId(), offers);

        return offers;
    }

    @Override
    public void selectOffer(LoanOfferDto loanOfferDto) {
        Statement statement = statementService.findStatement(loanOfferDto.getStatementId());
        statementService.updateStatementWithAppliedLoanOffer(statement.getId(), loanOfferDto);
    }

    @Override
    public void calculateCredit(String statementId, FinishRegistrationRequestDto requestDto) {
        UUID statementUUID = UUID.fromString(statementId);
        ClientDto clientToUpdate = clientMapper.FinishRegistrationRequestDtoToClientDto(requestDto);
        clientService.updateClient(statementService.findStatement(statementUUID).getClient().getId(),
                clientToUpdate);

        Statement statement = statementService.findStatement(statementUUID);
        ScoringDataDto scoringDataDto = ScoringDataMapper.INSTANCE.StatementDtoToScoringDataDto(
                statementMapper.toDto(statement));

        CreditDto creditDto = calculatorClient.getCredit(scoringDataDto);
        creditDto.setCreditStatus(CreditStatus.CALCULATED);

        StatementDto statementToUpdate = statementMapper.toDto(statement);
        statementToUpdate.setCredit(creditDto);
        statementService.updateStatement(statement.getId(), statementToUpdate);
    }
}
