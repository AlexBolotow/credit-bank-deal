package com.bolotov.creditbankdeal.service.impl;

import com.bolotov.creditbankdeal.dto.LoanOfferDto;
import com.bolotov.creditbankdeal.dto.StatementDto;
import com.bolotov.creditbankdeal.dto.StatusHistory;
import com.bolotov.creditbankdeal.entity.Client;
import com.bolotov.creditbankdeal.entity.Credit;
import com.bolotov.creditbankdeal.entity.Statement;
import com.bolotov.creditbankdeal.enums.ApplicationStatus;
import com.bolotov.creditbankdeal.enums.ChangeType;
import com.bolotov.creditbankdeal.exception.StatementNotFoundException;
import com.bolotov.creditbankdeal.mapper.ClientMapper;
import com.bolotov.creditbankdeal.mapper.CreditMapper;
import com.bolotov.creditbankdeal.mapper.StatementMapper;
import com.bolotov.creditbankdeal.repository.StatementRepository;
import com.bolotov.creditbankdeal.service.ClientService;
import com.bolotov.creditbankdeal.service.CreditService;
import com.bolotov.creditbankdeal.service.StatementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class StatementServiceImpl implements StatementService {

    private final StatementRepository statementRepository;

    private final ClientService clientService;

    private final CreditService creditService;

    private final StatementMapper statementMapper;

    private final CreditMapper creditMapper;

    private final ClientMapper clientMapper;

    @Override
    public Statement createStatement(StatementDto statementDto) {
        if (statementDto.getClient() != null) {
            Client savedClient = clientService.createClient(statementDto.getClient());
            statementDto.setClient(clientMapper.toDto(savedClient));
        }

        if (statementDto.getCredit() != null) {
            Credit credit = creditService.createCredit(statementDto.getCredit());
            statementDto.setCredit(creditMapper.toDto(credit));
        }

        return statementRepository.save(statementMapper.toEntity(statementDto));
    }

    @Override
    public Statement findStatement(UUID id) {
        return statementRepository.findById(id)
                .orElseThrow(
                        () -> new StatementNotFoundException("Statement with id " + id + " not found")
                );
    }

    @Override
    public void updateStatement(UUID id, StatementDto statementDto) {
        Statement statement = findStatement(id);

        //upsert client
        if (statementDto.getClient() != null) {
            if (statement.getClient() == null) {
                Client savedClient = clientService.createClient(statementDto.getClient());
                statementDto.setClient(clientMapper.toDto(savedClient));
            } else {
                clientService.updateClient(statement.getClient().getId(), statementDto.getClient());
            }
        }

        //upsert credit
        if (statementDto.getCredit() != null) {
            if (statement.getCredit() == null) {
                Credit savedCredit = creditService.createCredit(statementDto.getCredit());
                statementDto.setCredit(creditMapper.toDto(savedCredit));
            } else {
                creditService.updateCredit(statement.getCredit().getId(), statementDto.getCredit());
            }
        }

        statementMapper.updateEntityFromDto(statement, statementDto);
        statementRepository.save(statement);
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
