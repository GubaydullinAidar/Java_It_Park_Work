package ru.itpark.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import ru.itpark.models.SavingsTransaction;


public interface SavingsTransactionDao extends CrudRepository<SavingsTransaction, Long> {

    List<SavingsTransaction> findAll();
}

