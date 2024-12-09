package com.bolotov.creditbankdeal.service.impl;

import com.bolotov.creditbankdeal.dto.PassportDto;
import com.bolotov.creditbankdeal.entity.Passport;
import com.bolotov.creditbankdeal.exception.PassportException;
import com.bolotov.creditbankdeal.exception.PassportNotFoundException;
import com.bolotov.creditbankdeal.mapper.PassportMapper;
import com.bolotov.creditbankdeal.repository.PassportRepository;
import com.bolotov.creditbankdeal.service.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PassportServiceImpl implements PassportService {

    private final PassportRepository passportRepository;

    private final PassportMapper passportMapper;

    @Override
    public Passport createPassport(PassportDto passportDto) {
        passportRepository.findPassportBySeriesAndNumber(passportDto.getSeries(), passportDto.getNumber())
                .ifPresent(passport -> {
                    throw new PassportException("Passport with series " + passportDto.getSeries() + " and number "
                                                + passportDto.getNumber() + " already exists");
                });

        return passportRepository.save(passportMapper.toEntity(passportDto));
    }

    @Override
    public void updatePassport(UUID id, PassportDto passportDto) {
        passportRepository.findById(id)
                .ifPresentOrElse(passport -> {
                    passportMapper.updateEntityFromDto(passport, passportDto);
                    passportRepository.save(passport);
                }, () -> {
                    throw new PassportNotFoundException("Passport with id " + id + " not found");
                });
    }
}
