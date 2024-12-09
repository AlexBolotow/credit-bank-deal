package com.bolotov.creditbankdeal.service;

import com.bolotov.creditbankdeal.dto.EmploymentDto;
import com.bolotov.creditbankdeal.entity.Employment;

import java.util.UUID;

public interface EmploymentService {

    Employment createEmployment(EmploymentDto employmentDto);

    void updateEmployment(UUID id, EmploymentDto employmentDto);
}
