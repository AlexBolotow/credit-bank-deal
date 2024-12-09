package com.bolotov.creditbankdeal.service;

import com.bolotov.creditbankdeal.dto.CreditDto;
import com.bolotov.creditbankdeal.entity.Credit;

public interface CreditService {

    Credit createCredit(CreditDto creditDto);
}
