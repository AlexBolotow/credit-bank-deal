package com.bolotov.creditbankdeal.service.impl;

import com.bolotov.creditbankdeal.dto.CreditDto;
import com.bolotov.creditbankdeal.entity.Credit;
import com.bolotov.creditbankdeal.mapper.CreditMapper;
import com.bolotov.creditbankdeal.repository.CreditRepository;
import com.bolotov.creditbankdeal.service.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;

    @Override
    public Credit createCredit(CreditDto creditDto) {
        return creditRepository.save(CreditMapper.INSTANCE.toEntity(creditDto));
    }
}
