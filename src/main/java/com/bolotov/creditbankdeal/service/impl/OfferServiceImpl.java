package com.bolotov.creditbankdeal.service.impl;

import com.bolotov.creditbankdeal.dto.LoanOfferDto;
import com.bolotov.creditbankdeal.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OfferServiceImpl implements OfferService {

    @Override
    public void setStatementId(UUID statementId, List<LoanOfferDto> offers) {
        offers.forEach(offer -> offer.setStatementId(statementId));
    }
}
