package com.bolotov.creditbankdeal.service;

import com.bolotov.creditbankdeal.dto.CreditDto;
import com.bolotov.creditbankdeal.entity.Credit;

import java.util.UUID;

public interface CreditService {

    Credit createCredit(CreditDto creditDto);

    void updateCredit(UUID id, CreditDto creditDto);
}
