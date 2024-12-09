package com.bolotov.creditbankdeal.dto;

import com.bolotov.creditbankdeal.enums.ApplicationStatus;
import com.bolotov.creditbankdeal.enums.ChangeType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatusHistory {
    ApplicationStatus status;
    LocalDateTime time;
    ChangeType changeType;
}
