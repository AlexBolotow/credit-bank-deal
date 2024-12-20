package com.bolotov.creditbankdeal.client;

import com.bolotov.creditbankdeal.dto.CreditDto;
import com.bolotov.creditbankdeal.dto.LoanOfferDto;
import com.bolotov.creditbankdeal.dto.LoanStatementRequestDto;
import com.bolotov.creditbankdeal.dto.ScoringDataDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "${feign.client.config.calculator.name}", url = "${feign.client.config.calculator.url}")
public interface CalculatorClient {

    @PostMapping("/offers")
    List<LoanOfferDto> getOffers(@RequestBody LoanStatementRequestDto requestDto);

    @PostMapping("/calc")
    CreditDto getCredit(@RequestBody ScoringDataDto scoringDataDto);
}
