package ru.itpark.dao;

import org.springframework.data.repository.CrudRepository;
import ru.itpark.models.SavingsAccount;

public interface SavingsAccountDao extends CrudRepository<SavingsAccount, Long> {

    SavingsAccount findByAccountNumber(int accountNumber);
}
