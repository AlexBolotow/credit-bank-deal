package com.bolotov.creditbankdeal.repository;

import com.bolotov.creditbankdeal.entity.Passport;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface PassportRepository extends CrudRepository<Passport, UUID> {

    Optional<Passport> findPassportBySeriesAndNumber(String series, String number);
}
