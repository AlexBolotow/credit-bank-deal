package com.bolotov.creditbankdeal.dto;

import com.bolotov.creditbankdeal.enums.Gender;
import com.bolotov.creditbankdeal.enums.MaritalStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientDto {
    UUID id;
    String lastName;
    String firstName;
    String middleName;
    LocalDate birthdate;
    String email;
    Gender gender;
    MaritalStatus maritalStatus;
    Integer dependentAmount;
    PassportDto passport;
    EmploymentDto employment;
    String accountNumber;
}
