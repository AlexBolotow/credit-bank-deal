package com.bolotov.creditbankdeal.entity;

import com.bolotov.creditbankdeal.enums.Gender;
import com.bolotov.creditbankdeal.enums.MaritalStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id_uuid")
    UUID id;

    String lastName;

    String firstName;

    String middleName;

    LocalDate birthdate;

    String email;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Enumerated(EnumType.STRING)
    MaritalStatus maritalStatus;

    Integer dependentAmount;

    @OneToOne
    @JoinColumn(name = "passport_id", referencedColumnName = "passport_id_uuid")
    Passport passport;

    @OneToOne
    @JoinColumn(name = "employment_id", referencedColumnName = "employment_id_uuid")
    Employment employment;

    String accountNumber;
}
