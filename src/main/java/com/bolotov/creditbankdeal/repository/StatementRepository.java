package com.bolotov.creditbankdeal.repository;


import com.bolotov.creditbankdeal.entity.Statement;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StatementRepository extends CrudRepository<Statement, UUID> {
}
