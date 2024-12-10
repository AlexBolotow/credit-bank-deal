package com.bolotov.creditbankdeal.service.impl;

import com.bolotov.creditbankdeal.dto.CreditDto;
import com.bolotov.creditbankdeal.entity.Credit;
import com.bolotov.creditbankdeal.exception.CreditNotFoundException;
import com.bolotov.creditbankdeal.mapper.CreditMapper;
import com.bolotov.creditbankdeal.repository.CreditRepository;
import com.bolotov.creditbankdeal.service.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;

    private final CreditMapper creditMapper;

    @Override
    public Credit createCredit(CreditDto creditDto) {
        return creditRepository.save(creditMapper.toEntity(creditDto));
    }

    @Override
    public void updateCredit(UUID id, CreditDto creditDto) {
        creditRepository.findById(id)
                .ifPresentOrElse(credit -> {
                    creditMapper.updateEntityFromDto(credit, creditDto);
                    creditRepository.save(credit);
                }, () -> {
                    throw new CreditNotFoundException("Credit with id " + id + " not found");
                });
    }
}
