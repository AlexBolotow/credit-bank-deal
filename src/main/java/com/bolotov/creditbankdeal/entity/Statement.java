package com.bolotov.creditbankdeal.entity;

import com.bolotov.creditbankdeal.dto.CreditDto;
import com.bolotov.creditbankdeal.dto.StatusHistory;
import com.bolotov.creditbankdeal.enums.ApplicationStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Statement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "statement_id_uuid")
    UUID id;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id_uuid")
    Client client;

    @ManyToOne
    @JoinColumn(name = "credit_id", referencedColumnName = "credit_id_uuid")
    Credit credit;

    @Enumerated(EnumType.STRING)
    ApplicationStatus status;

    LocalDateTime creationDate;

    @JdbcTypeCode(SqlTypes.JSON)
    CreditDto appliedOffer;

    LocalDateTime signDate;

    Integer sesCode;

    @JdbcTypeCode(SqlTypes.JSON)
    List<StatusHistory> statusHistory;
}
