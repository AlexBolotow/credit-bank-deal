package com.bolotov.creditbankdeal.dto;

import com.bolotov.creditbankdeal.enums.CreditStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreditDto {
    UUID id;
    BigDecimal amount;
    Integer term;
    BigDecimal monthlyPayment;
    BigDecimal rate;
    BigDecimal psk;
    Boolean insuranceEnabled;
    Boolean salaryClient;
    List<PaymentScheduleElementDto> paymentSchedule;
    CreditStatus creditStatus;
}
