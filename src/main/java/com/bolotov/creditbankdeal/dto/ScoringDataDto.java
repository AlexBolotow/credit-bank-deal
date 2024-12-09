package com.bolotov.creditbankdeal.dto;

import com.bolotov.creditbankdeal.dto.validation.ValidAge;
import com.bolotov.creditbankdeal.enums.Gender;
import com.bolotov.creditbankdeal.enums.MaritalStatus;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScoringDataDto {

    @NotNull
    @DecimalMin("20000")
    BigDecimal amount;

    @NotNull
    @DecimalMin("6")
    Integer term;

    @NotNull
    @Size(min = 2, max = 30)
    String firstName;

    @NotNull
    @Size(min = 2, max = 30)
    String lastName;

    @Size(min = 2, max = 30)
    String middleName;

    Gender gender;

    @NotNull
    @ValidAge
    LocalDate birthdate;

    @NotNull
    @Size(min = 4, max = 4)
    String passportSeries;

    @NotNull
    @Size(min = 6, max = 6)
    String passportNumber;

    @NotNull
    LocalDate passportIssueDate;

    @NotNull
    String passportIssueBranch;

    @NotNull
    MaritalStatus maritalStatus;

    @NotNull
    Integer dependentAmount;

    @NotNull
    EmploymentDto employment;

    @NotNull
    String accountNumber;

    @NotNull
    Boolean isInsuranceEnabled;

    @NotNull
    Boolean isSalaryClient;
}
