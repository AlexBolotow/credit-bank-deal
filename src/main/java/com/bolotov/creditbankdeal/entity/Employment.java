package com.bolotov.creditbankdeal.entity;

import com.bolotov.creditbankdeal.enums.EmploymentPosition;
import com.bolotov.creditbankdeal.enums.EmploymentStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Employment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employment_id_uuid")
    UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    EmploymentStatus employmentStatus;

    @Column(name = "employer_inn")
    String employerINN;

    BigDecimal salary;

    @Enumerated(EnumType.STRING)
    EmploymentPosition position;

    Integer workExperienceTotal;

    Integer workExperienceCurrent;
}
