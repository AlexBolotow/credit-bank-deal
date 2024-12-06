package com.bolotov.creditbankdeal.repository;

import com.bolotov.creditbankdeal.entity.Credit;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CreditRepository extends CrudRepository<Credit, UUID> {
}
