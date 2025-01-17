package com.bolotov.creditbankdeal.controller;

import com.bolotov.creditbankdeal.client.CalculatorClient;
import com.bolotov.creditbankdeal.dto.FinishRegistrationRequestDto;
import com.bolotov.creditbankdeal.dto.LoanOfferDto;
import com.bolotov.creditbankdeal.dto.LoanStatementRequestDto;
import com.bolotov.creditbankdeal.mapper.ClientMapper;
import com.bolotov.creditbankdeal.mapper.StatementMapper;
import com.bolotov.creditbankdeal.service.ClientService;
import com.bolotov.creditbankdeal.service.DealService;
import com.bolotov.creditbankdeal.service.OfferService;
import com.bolotov.creditbankdeal.service.StatementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deal")
@RequiredArgsConstructor
public class DealController {

    private final DealService dealService;

    @PostMapping("/statement")
    public ResponseEntity<List<LoanOfferDto>> getOffers(@RequestBody LoanStatementRequestDto requestDto) {
        List<LoanOfferDto> result = dealService.getOffers(requestDto);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/offer/select")
    public ResponseEntity<?> selectOffer(@RequestBody LoanOfferDto loanOfferDto) {
        dealService.selectOffer(loanOfferDto);
        return ResponseEntity.ok("Offer selected successfully");
    }

    @PostMapping("/calculate/{statementId}")
    public ResponseEntity<?> calculateCredit(@PathVariable String statementId,
                                             @RequestBody FinishRegistrationRequestDto requestDto) {
        dealService.calculateCredit(statementId, requestDto);
        return ResponseEntity.ok("Credit calculated successfully");
    }
}
