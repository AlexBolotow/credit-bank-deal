package com.bolotov.creditbankdeal.service;

import com.bolotov.creditbankdeal.dto.PassportDto;
import com.bolotov.creditbankdeal.entity.Passport;

import java.util.UUID;

public interface PassportService {

    Passport createPassport(PassportDto passportDto);

    void updatePassport(UUID id, PassportDto passportDto);
}
