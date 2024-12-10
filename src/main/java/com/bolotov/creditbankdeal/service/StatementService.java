package com.bolotov.creditbankdeal.service;

import com.bolotov.creditbankdeal.dto.LoanOfferDto;
import com.bolotov.creditbankdeal.dto.StatementDto;
import com.bolotov.creditbankdeal.entity.Statement;

import java.util.UUID;

public interface StatementService {

    Statement createStatement(StatementDto statementDto);

    Statement findStatement(UUID id);

    void updateStatement(UUID id, StatementDto statementDto);

    void updateStatementWithAppliedLoanOffer(UUID statementId, LoanOfferDto appliedOffer);
}
