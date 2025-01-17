package com.bolotov.creditbankdeal.service;

import com.bolotov.creditbankdeal.dto.FinishRegistrationRequestDto;
import com.bolotov.creditbankdeal.dto.LoanOfferDto;
import com.bolotov.creditbankdeal.dto.LoanStatementRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface DealService {

    List<LoanOfferDto> getOffers(LoanStatementRequestDto requestDto);

    void selectOffer(LoanOfferDto loanOfferDto);

    void calculateCredit(String statementId, FinishRegistrationRequestDto requestDto);
}
