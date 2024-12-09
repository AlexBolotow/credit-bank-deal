package com.bolotov.creditbankdeal.controller;

import com.bolotov.creditbankdeal.client.CalculatorRestClient;
import com.bolotov.creditbankdeal.dto.CreditDto;
import com.bolotov.creditbankdeal.dto.FinishRegistrationRequestDto;
import com.bolotov.creditbankdeal.dto.LoanOfferDto;
import com.bolotov.creditbankdeal.dto.LoanStatementRequestDto;
import com.bolotov.creditbankdeal.dto.ScoringDataDto;
import com.bolotov.creditbankdeal.dto.StatementDto;
import com.bolotov.creditbankdeal.entity.Client;
import com.bolotov.creditbankdeal.entity.Statement;
import com.bolotov.creditbankdeal.mapper.ClientMapper;
import com.bolotov.creditbankdeal.mapper.ScoringDataMapper;
import com.bolotov.creditbankdeal.mapper.StatementMapper;
import com.bolotov.creditbankdeal.service.ClientService;
import com.bolotov.creditbankdeal.service.CreditService;
import com.bolotov.creditbankdeal.service.StatementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/deal")
@RequiredArgsConstructor
public class DealController {

    private final ClientService clientService;

    private final StatementService statementService;

    private final CreditService creditService;

    private final CalculatorRestClient calculatorRestClient;

    private final ClientMapper clientMapper;

    @PostMapping("/statement")
    public ResponseEntity<List<LoanOfferDto>> getOffers(@RequestBody LoanStatementRequestDto requestDto) {
        Client createdClient = clientService.createClient(clientMapper.LoanStatementRequestDtoToClientDto(requestDto));

        StatementDto statementToCreate = StatementDto.builder()
                .client(createdClient)
                .build();
        Statement createdStatement = statementService.createStatement(statementToCreate);

        List<LoanOfferDto> offers = calculatorRestClient.getOffers(requestDto);
        offers.forEach(offer -> offer.setStatementId(createdStatement.getId()));

        return ResponseEntity.ok(offers);
    }

    @PostMapping("/offer/select")
    public ResponseEntity<?> selectOffer(@RequestBody LoanOfferDto loanOfferDto) {
        Statement statement = statementService.findStatement(loanOfferDto.getStatementId());

        statementService.updateStatementWithAppliedLoanOffer(statement.getId(), loanOfferDto);

        return ResponseEntity.ok("Offer selected successfully");
    }

    @PostMapping("/calculate/{statementId}")
    public ResponseEntity<?> calculateCredit(@PathVariable String statementId,
                                             @RequestBody FinishRegistrationRequestDto requestDto) {
        UUID statementUUID = UUID.fromString(statementId);
        Statement statement = statementService.findStatement(statementUUID);
        clientService.updateClient(statement.getClient().getId(),
                clientMapper.FinishRegistrationRequestDtoToClientDto(requestDto));

        //updated statement
        statement = statementService.findStatement(statementUUID);

        ScoringDataDto scoringDataDto = ScoringDataMapper.INSTANCE.StatementDtoToScoringDataDto(
                StatementMapper.INSTANCE.toDto(statement));

        CreditDto creditDto = calculatorRestClient.getCredit(scoringDataDto);
        creditService.createCredit(creditDto);

        return ResponseEntity.ok("Credit calculated successfully");
    }
}
