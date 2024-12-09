package com.bolotov.creditbankdeal.service.impl;

import com.bolotov.creditbankdeal.dto.EmploymentDto;
import com.bolotov.creditbankdeal.entity.Employment;
import com.bolotov.creditbankdeal.exception.EmploymentNotFoundException;
import com.bolotov.creditbankdeal.mapper.EmploymentMapper;
import com.bolotov.creditbankdeal.repository.EmploymentRepository;
import com.bolotov.creditbankdeal.service.EmploymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class EmploymentServiceImpl implements EmploymentService {

    private final EmploymentRepository employmentRepository;

    private final EmploymentMapper employmentMapper;

    @Override
    public Employment createEmployment(EmploymentDto employmentDto) {
        return employmentRepository.save(employmentMapper.toEntity(employmentDto));
    }

    @Override
    public void updateEmployment(UUID id, EmploymentDto employmentDto) {
        employmentRepository.findById(id)
                .ifPresentOrElse(employment -> {
                    employmentMapper.updateEntityFromDto(employment, employmentDto);
                    employmentRepository.save(employment);
                }, () -> {
                    throw new EmploymentNotFoundException("Employment with id " + id + " not found");
                });
    }
}
