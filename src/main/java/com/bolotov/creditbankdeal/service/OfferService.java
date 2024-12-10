package com.bolotov.creditbankdeal.service;

import com.bolotov.creditbankdeal.dto.LoanOfferDto;

import java.util.List;
import java.util.UUID;

public interface OfferService {

    void setStatementId(UUID statementId, List<LoanOfferDto> offers);
}
