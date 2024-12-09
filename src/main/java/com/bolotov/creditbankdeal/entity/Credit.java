package com.bolotov.creditbankdeal.entity;

import com.bolotov.creditbankdeal.dto.PaymentScheduleElementDto;
import com.bolotov.creditbankdeal.enums.CreditStatus;
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
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "credit_id_uuid")
    UUID id;

    BigDecimal amount;

    Integer term;

    BigDecimal monthlyPayment;

    BigDecimal rate;

    BigDecimal psk;

    @JdbcTypeCode(SqlTypes.JSON)
    List<PaymentScheduleElementDto> paymentSchedule;

    Boolean insuranceEnabled;

    Boolean salaryClient;

    @Enumerated(EnumType.STRING)
    CreditStatus creditStatus;
}
