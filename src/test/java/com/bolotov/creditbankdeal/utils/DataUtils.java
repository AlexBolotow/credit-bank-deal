package com.bolotov.creditbankdeal.utils;

import com.bolotov.creditbankdeal.dto.EmploymentDto;
import com.bolotov.creditbankdeal.dto.FinishRegistrationRequestDto;
import com.bolotov.creditbankdeal.dto.LoanStatementRequestDto;
import com.bolotov.creditbankdeal.enums.EmploymentPosition;
import com.bolotov.creditbankdeal.enums.EmploymentStatus;
import com.bolotov.creditbankdeal.enums.Gender;
import com.bolotov.creditbankdeal.enums.MaritalStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DataUtils {

    public static LoanStatementRequestDto getLoanStatementRequestDtoJohnDoe() {
        return LoanStatementRequestDto.builder()
                .amount(new BigDecimal("20000"))
                .term(12)
                .firstName("John")
                .lastName("Doe")
                .middleName("AAA")
                .email("john.doe@example.com")
                .birthdate(LocalDate.of(1990, 1, 1))
                .passportSeries("1234")
                .passportNumber("123456")
                .build();
    }

    public static FinishRegistrationRequestDto getFinishRegistrationRequestDto() {
        return FinishRegistrationRequestDto.builder()
                .gender(Gender.MALE)
                .maritalStatus(MaritalStatus.MARRIED)
                .dependentAmount(2)
                .passportIssueDate(LocalDate.now())
                .passportIssueBranch("City")
                .employment(EmploymentDto.builder()
                        .employmentStatus(EmploymentStatus.EMPLOYED)
                        .position(EmploymentPosition.MIDDLE_MANAGER)
                        .employerINN("12345646742354135")
                        .salary(BigDecimal.valueOf(5000))
                        .workExperienceTotal(48)
                        .workExperienceCurrent(20)
                        .build())
                .accountNumber("12")
                .build();
    }
/*
    public static LoanStatementRequestDto getIncorrectLoanStatementRequestDtoJohnDoe() {
        return LoanStatementRequestDto.builder()
                .amount(new BigDecimal("10000"))
                .term(4)
                .firstName("John")
                .lastName("Doe")
                .middleName("A")
                .email("john.doe.com")
                .birthdate(LocalDate.of(2024, 1, 1))
                .passportSeries("12")
                .passportNumber("1")
                .build();
    }

    public static List<LoanOfferDto> getOffers() {
        return List.of(
                LoanOfferDto.builder()
                        .statementId(UUID.randomUUID())
                        .term(12)
                        .isInsuranceEnabled(false)
                        .isSalaryClient(false)
                        .requestedAmount(new BigDecimal("15000"))
                        .totalAmount(new BigDecimal("18000"))
                        .rate(new BigDecimal("0.10"))
                        .monthlyPayment(new BigDecimal("1500"))
                        .build(),
                LoanOfferDto.builder()
                        .statementId(UUID.randomUUID())
                        .term(12)
                        .isInsuranceEnabled(true)
                        .isSalaryClient(false)
                        .requestedAmount(new BigDecimal("17000"))
                        .totalAmount(new BigDecimal("20000"))
                        .rate(new BigDecimal("0.09"))
                        .monthlyPayment(new BigDecimal("1700"))
                        .build(),
                LoanOfferDto.builder()
                        .statementId(UUID.randomUUID())
                        .term(12)
                        .isInsuranceEnabled(false)
                        .isSalaryClient(true)
                        .requestedAmount(new BigDecimal("19000"))
                        .totalAmount(new BigDecimal("22000"))
                        .rate(new BigDecimal("0.08"))
                        .monthlyPayment(new BigDecimal("1900"))
                        .build(),
                LoanOfferDto.builder()
                        .statementId(UUID.randomUUID())
                        .term(12)
                        .isInsuranceEnabled(true)
                        .isSalaryClient(true)
                        .requestedAmount(new BigDecimal("30000"))
                        .totalAmount(new BigDecimal("22000"))
                        .rate(new BigDecimal("0.07"))
                        .monthlyPayment(new BigDecimal("1700"))
                        .build()
        );
    }

    public static ScoringDataDto getScoringDataDtoJohnDoe() {
        return ScoringDataDto.builder()
                .amount(new BigDecimal("20000"))
                .term(12)
                .firstName("John")
                .lastName("Doe")
                .middleName("AAA")
                .gender(Gender.MALE)
                .birthdate(LocalDate.of(1990, 1, 1))
                .passportSeries("1234")
                .passportNumber("123456")
                .passportIssueDate(LocalDate.of(2021, 1, 1))
                .passportIssueBranch("Example branch")
                .maritalStatus(MaritalStatus.MARRIED)
                .dependentAmount(2)
                .employment(EmploymentDto.builder()
                        .employmentStatus(EmploymentStatus.EMPLOYED)
                        .position(EmploymentPosition.MIDDLE_MANAGER)
                        .employerINN("12345646742354135")
                        .salary(BigDecimal.valueOf(5000))
                        .workExperienceTotal(48)
                        .workExperienceCurrent(20)
                        .build())
                .accountNumber("6456452")
                .isInsuranceEnabled(true)
                .isSalaryClient(true)
                .build();
    }

    public static Credit getCreditDto() {
        return Credit.builder()
                .amount(BigDecimal.valueOf(20000.0))
                .term(1)
                .monthlyPayment(BigDecimal.valueOf(1000.0))
                .rate(BigDecimal.valueOf(0.2))
                .psk(BigDecimal.valueOf(0.12))
                .isInsuranceEnabled(true)
                .isSalaryClient(true)
                .paymentSchedule(List.of(PaymentScheduleElementDto.builder()
                                .number(1)
                                .date(LocalDate.now())
                                .totalPayment(BigDecimal.valueOf(1500))
                                .interestPayment(BigDecimal.valueOf(500))
                                .debtPayment(BigDecimal.valueOf(1000))
                                .remainingDebt(BigDecimal.valueOf(18500))
                        .build()))
                .build();
    }*/
}
