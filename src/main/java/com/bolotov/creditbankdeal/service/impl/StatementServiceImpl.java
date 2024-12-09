package com.bolotov.creditbankdeal.service.impl;

import com.bolotov.creditbankdeal.dto.LoanOfferDto;
import com.bolotov.creditbankdeal.dto.StatementDto;
import com.bolotov.creditbankdeal.dto.StatusHistory;
import com.bolotov.creditbankdeal.entity.Statement;
import com.bolotov.creditbankdeal.enums.ApplicationStatus;
import com.bolotov.creditbankdeal.enums.ChangeType;
import com.bolotov.creditbankdeal.exception.StatementNotFoundException;
import com.bolotov.creditbankdeal.mapper.StatementMapper;
import com.bolotov.creditbankdeal.repository.StatementRepository;
import com.bolotov.creditbankdeal.service.StatementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class StatementServiceImpl implements StatementService {

    private final StatementRepository statementRepository;

    @Override
    public Statement createStatement(StatementDto statementDto) {
        return statementRepository.save(StatementMapper.INSTANCE.toEntity(statementDto));
    }

    @Override
    public Statement findStatement(UUID id) {
        return statementRepository.findById(id)
                .orElseThrow(
                        () -> new StatementNotFoundException("Statement with id " + id + " not found")
                );
    }

    @Override
    public void updateStatementWithAppliedLoanOffer(UUID statementId, LoanOfferDto appliedOffer) {
        StatusHistory statusHistory = StatusHistory.builder()
                .status(ApplicationStatus.PREAPPROVAL)
                .time(LocalDateTime.now())
                .changeType(ChangeType.AUTOMATIC)
                .build();

        statementRepository.findById(statementId)
                .ifPresentOrElse(statement -> {
                    statement.setStatus(ApplicationStatus.PREAPPROVAL);
                    statement.setAppliedOffer(appliedOffer);
                    statement.getStatusHistory().add(statusHistory);
                    statementRepository.save(statement);
                }, () -> {
                    throw new StatementNotFoundException("Statement with id " + statementId + " not found");
                });
    }

}
