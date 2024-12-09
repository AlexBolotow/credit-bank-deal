package com.bolotov.creditbankdeal.repository;

import com.bolotov.creditbankdeal.entity.Employment;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EmploymentRepository extends CrudRepository<Employment, UUID> {
}
