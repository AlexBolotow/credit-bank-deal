package com.bolotov.creditbankdeal.client;

import com.bolotov.creditbankdeal.dto.CreditDto;
import com.bolotov.creditbankdeal.dto.LoanOfferDto;
import com.bolotov.creditbankdeal.dto.LoanStatementRequestDto;
import com.bolotov.creditbankdeal.dto.ScoringDataDto;

import java.util.List;

public interface CalculatorRestClient {

    List<LoanOfferDto> getOffers(LoanStatementRequestDto requestDto);

    CreditDto getCredit(ScoringDataDto scoringDataDto);
}
