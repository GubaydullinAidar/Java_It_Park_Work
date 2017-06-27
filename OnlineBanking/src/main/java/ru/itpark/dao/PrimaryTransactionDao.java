package ru.itpark.dao;

import org.springframework.data.repository.CrudRepository;
import ru.itpark.models.PrimaryTransaction;

public interface PrimaryTransactionDao extends CrudRepository<PrimaryTransaction, Long> {
}
