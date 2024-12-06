package com.bolotov.creditbankdeal.dto;

import com.bolotov.creditbankdeal.entity.Client;
import com.bolotov.creditbankdeal.entity.Credit;
import com.bolotov.creditbankdeal.enums.ApplicationStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatementDto {
    UUID id;
    Client client;
    Credit credit;
    ApplicationStatus status;
    LocalDateTime creationDate;
    CreditDto appliedOffer;
    LocalDateTime signDate;
    Integer sesCode;
    List<StatusHistory> statusHistory;
}
